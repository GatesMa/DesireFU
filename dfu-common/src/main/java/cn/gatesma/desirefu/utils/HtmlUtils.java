package cn.gatesma.desirefu.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import java.util.List;

/**
 * User: gatesma
 * Date: 2021/1/15 2:01 下午
 * Desc:
 */
public class HtmlUtils {

    private static String extractText(Node node){
        /* TextNode直接返回结果 */
        if(node instanceof TextNode){
            return ((TextNode) node).text();
        }
        /* 非TextNode的Node，遍历其孩子Node */
        List<Node> children = node.childNodes();
        StringBuffer buffer = new StringBuffer();
        for (Node child: children) {
            buffer.append(extractText(child));
        }
        return buffer.toString();
    }
    /* 使用jsoup解析html并转化为提取字符串*/
    public static String html2Str(String html){
        Document doc = Jsoup.parse(html);
        return extractText(doc);
    }

    public static void main(String[] args) {

        String str = "<div class=\"creativecommons\">\n" +
                "                            版权声明：本文为博主原创文章，遵循<a href=\"http://creativecommons.org/licenses/by-sa/4.0/\" target=\"_blank\" rel=\"noopener\"> CC 4.0 BY-SA </a>版权协议，转载请附上原文出处链接和本声明。\n" +
                "                        </div>\n" +
                "                        <div class=\"article-source-link\">\n" +
                "                            本文链接：<a href=\"https://blog.csdn.net/qq_36336003/article/details/88078365\" target=\"_blank\">https://blog.csdn.net/qq_36336003/article/details/88078365</a>\n" +
                "                        </div>";

        System.out.println(html2Str(str));


    }

}
