package cn.gatesma.desirefu.domain.api.generate;

import java.util.Objects;

import cn.gatesma.desirefu.domain.api.generate.ReturnCode;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * HelloRet
 */
@Validated
public class HelloRet extends ReturnCode implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("data")
    private String data = null;

    public HelloRet data(String data) {
        this.data = data;
        return this;
    }

    /**
     * 返回字符串
     *
     * @return data
     **/
    @ApiModelProperty(value = "返回字符串")

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HelloRet helloRet = (HelloRet) o;
        return Objects.equals(this.data, helloRet.data) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class HelloRet {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
