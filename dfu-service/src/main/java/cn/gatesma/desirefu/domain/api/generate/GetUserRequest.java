package cn.gatesma.desirefu.domain.api.generate;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

/**
 * GetUserRequest
 */
@Validated
public class GetUserRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("user_id")
    private Long userId = null;

    @JsonProperty("login_name")
    private String loginName = null;

    @JsonProperty("login_name_type")
    private Integer loginNameType = null;

    public GetUserRequest userId(Long userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 用户登录信息 (login_name, login_name_type) 和 user_id两个必填一个
     *
     * @return userId
     **/
    @ApiModelProperty(example = "17998821", value = "用户登录信息 (login_name, login_name_type) 和 user_id两个必填一个")

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public GetUserRequest loginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    /**
     * 用户登录名称
     *
     * @return loginName
     **/
    @ApiModelProperty(example = "78837721", value = "用户登录名称")

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public GetUserRequest loginNameType(Integer loginNameType) {
        this.loginNameType = loginNameType;
        return this;
    }

    /**
     * 用户登录类型
     *
     * @return loginNameType
     **/
    @ApiModelProperty(example = "1", value = "用户登录类型")

    public Integer getLoginNameType() {
        return loginNameType;
    }

    public void setLoginNameType(Integer loginNameType) {
        this.loginNameType = loginNameType;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetUserRequest getUserRequest = (GetUserRequest) o;
        return Objects.equals(this.userId, getUserRequest.userId) &&
                Objects.equals(this.loginName, getUserRequest.loginName) &&
                Objects.equals(this.loginNameType, getUserRequest.loginNameType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, loginName, loginNameType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetUserRequest {\n");

        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    loginName: ").append(toIndentedString(loginName)).append("\n");
        sb.append("    loginNameType: ").append(toIndentedString(loginNameType)).append("\n");
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
