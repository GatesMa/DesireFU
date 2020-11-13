package cn.gatesma.desirefu.domain.api.generate;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

/**
 * AddUserRet
 */
@Validated
public class AddUserRet extends ReturnCode implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("data")
    private AddUserRetData data = null;

    public AddUserRet data(AddUserRetData data) {
        this.data = data;
        return this;
    }

    /**
     * Get data
     *
     * @return data
     **/
    @ApiModelProperty(value = "")

    @Valid
    public AddUserRetData getData() {
        return data;
    }

    public void setData(AddUserRetData data) {
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
        AddUserRet addUserRet = (AddUserRet) o;
        return Objects.equals(this.data, addUserRet.data) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AddUserRet {\n");
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
