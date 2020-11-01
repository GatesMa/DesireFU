package cn.gatesma.desirefu.domain.api.generate;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Objects;
import org.springframework.validation.annotation.Validated;

/**
 * AddUserRetData
 */
@Validated
public class AddUserRetData implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("user_id")
    private Long userId = null;

    public AddUserRetData userId(Long userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 用户ID
     *
     * @return userId
     **/
    @ApiModelProperty(example = "100000", value = "用户ID")

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AddUserRetData addUserRetData = (AddUserRetData) o;
        return Objects.equals(this.userId, addUserRetData.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AddUserRetData {\n");

        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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
