package cn.gatesma.desirefu.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author gatesma
 * @date 2020/11/7
 * @desc HostUtils
 */
public class HostUtils {

    private final static String ETH1 = "eth1";
    private final static String LOCAL_IP = "127.0.0.1";

    /**
     * 返回机器的主机名和IP
     * <br>
     * 本方法无法在全部场景返回期待的IP，只是保证在linux物理机上可以返回正确的结果
     * <br>
     * 在复杂网络配置下（虚拟设备等）使用会失效
     */
    public static String[] getHostnameAndIp() {
        String hostname, ip = null;
        try {
            InetAddress host = InetAddress.getLocalHost();
            hostname = host.getHostName();
            ip = host.getHostAddress();
        } catch (UnknownHostException e) {
            // 在某些云机器会出错
            hostname = getHostName();
        }

        // 在复杂的网卡配置情况下，上面的ip值经常不对
        if (ip == null || LOCAL_IP.equals(ip)) {
            ip = getEth1Address();
        }
        if (ip == null) {
            ip = getIPv4ExcludeLocal();
        }

        return new String[] {hostname, ip};
    }

    /**
     * 获取主机名称，比如我现在的电脑：GATESMA-MB1
     */
    private static String getHostName() {

        Callable<String> task = new Callable<String>() {
            public String call() {
                BufferedReader br = null;
                try {
                    Process p = Runtime.getRuntime().exec("hostname");
                    br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    p.waitFor();

                    // 只读第一行
                    return br.readLine();
                } catch (IOException | InterruptedException ignored) {
                } finally {
                    try {
                        if (br != null) {
                            br.close();
                        }
                    } catch (IOException e) {
                    }
                }

                return null;
            }
        };

        String result = null;

        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            Future<String> future = executor.submit(task);
            result = future.get(3, TimeUnit.SECONDS);
        } catch (Exception e) {
            result = "UNKNOWN";
        } finally {
            executor.shutdown();
        }

        return result;
    }

    /**
     * 获取eth1接口的地址
     */
    private static String getEth1Address() {
        try {
            NetworkInterface eth1 = NetworkInterface.getByName(ETH1);
            List<InterfaceAddress> ips = eth1.getInterfaceAddresses();

            // 只对linux机器有效
            if (!ips.isEmpty()) {
                return ips.get(0).getAddress().getHostAddress();
            }
        } catch (SocketException ignored) {

        } catch (NullPointerException e){
            // ignored
        }

        return null;
    }

    /**
     * 获取一个非本地环回地址的IPv4地址（本地环回地址：127.0.0.1）
     */
    private static String getIPv4ExcludeLocal() {

        Enumeration<NetworkInterface> nis = null;
        try {
            nis = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException ignored) {
        }
        if (nis == null) {
            return null;
        }

        while (nis.hasMoreElements()) {

            List<InterfaceAddress> interfaceAddresses = nis.nextElement().getInterfaceAddresses();

            for (InterfaceAddress interfaceAddress : interfaceAddresses) {

                InetAddress address = interfaceAddress.getAddress();
                if (address instanceof Inet6Address || address == null) {
                    continue;
                }

                String ip = address.getHostAddress();
                if (LOCAL_IP.equals(ip)) {
                    continue;
                }
                return ip;
            }
        }

        return null;
    }

}
