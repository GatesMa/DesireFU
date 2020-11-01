package cn.gatesma.desirefu.domain.api.generate;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

/**
 * AddUserRequest
 */
@Validated
public class AddUserRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("login_name")
    private String loginName = null;

    @JsonProperty("login_name_type")
    private Integer loginNameType = null;

    @JsonProperty("user_name")
    private String userName = null;

    @JsonProperty("cellphone")
    private String cellphone = null;

    @JsonProperty("email")
    private String email = null;

    @JsonProperty("created_user_id")
    private Long createdUserId = null;

    public AddUserRequest loginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    /**
     * 登录账号名称
     *
     * @return loginName
     **/
    @ApiModelProperty(required = true, value = "登录账号名称")
    @NotNull

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public AddUserRequest loginNameType(Integer loginNameType) {
        this.loginNameType = loginNameType;
        return this;
    }

    /**
     * 登录账号类型
     *
     * @return loginNameType
     **/
    @ApiModelProperty(example = "1", required = true, value = "登录账号类型")
    @NotNull

    public Integer getLoginNameType() {
        return loginNameType;
    }

    public void setLoginNameType(Integer loginNameType) {
        this.loginNameType = loginNameType;
    }

    public AddUserRequest userName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * 用户名称
     *
     * @return userName
     **/
    @ApiModelProperty(value = "用户名称")

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public AddUserRequest cellphone(String cellphone) {
        this.cellphone = cellphone;
        return this;
    }

    /**
     * 手机号码
     *
     * @return cellphone
     **/
    @ApiModelProperty(value = "手机号码")

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public AddUserRequest email(String email) {
        this.email = email;
        return this;
    }

    /**
     * 邮箱
     *
     * @return email
     **/
    @ApiModelProperty(value = "邮箱")

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddUserRequest createdUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
        return this;
    }

    /**
     * 创建者userId
     *
     * @return createdUserId
     **/
    @ApiModelProperty(example = "3453454", value = "创建者userId")

    public Long getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AddUserRequest addUserRequest = (AddUserRequest) o;
        return Objects.equals(this.loginName, addUserRequest.loginName) &&
                Objects.equals(this.loginNameType, addUserRequest.loginNameType) &&
                Objects.equals(this.userName, addUserRequest.userName) &&
                Objects.equals(this.cellphone, addUserRequest.cellphone) &&
                Objects.equals(this.email, addUserRequest.email) &&
                Objects.equals(this.createdUserId, addUserRequest.createdUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginName, loginNameType, userName, cellphone, email, createdUserId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AddUserRequest {\n");

        sb.append("    loginName: ").append(toIndentedString(loginName)).append("\n");
        sb.append("    loginNameType: ").append(toIndentedString(loginNameType)).append("\n");
        sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
        sb.append("    cellphone: ").append(toIndentedString(cellphone)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    createdUserId: ").append(toIndentedString(createdUserId)).append("\n");
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
