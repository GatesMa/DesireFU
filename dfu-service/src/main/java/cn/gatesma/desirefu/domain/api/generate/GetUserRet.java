package cn.gatesma.desirefu.domain.api.generate;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

/**
 * GetUserRet
 */
@Validated
public class GetUserRet extends ReturnCode implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("data")
    private User data = null;

    public GetUserRet data(User data) {
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
    public User getData() {
        return data;
    }

    public void setData(User data) {
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
        GetUserRet getUserRet = (GetUserRet) o;
        return Objects.equals(this.data, getUserRet.data) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetUserRet {\n");
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
