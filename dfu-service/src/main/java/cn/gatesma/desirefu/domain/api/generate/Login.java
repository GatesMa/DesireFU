package cn.gatesma.desirefu.domain.api.generate;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

/**
 * 登录信息
 */
@ApiModel(description = "登录信息")
@Validated
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("login_name")
    private String loginName = null;

    @JsonProperty("login_name_type")
    private Integer loginNameType = null;

    @JsonProperty("uin")
    private String uin = null;

    public Login loginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    /**
     * 登录账号名称
     *
     * @return loginName
     **/
    @ApiModelProperty(example = "78837721", required = true, value = "登录账号名称")
    @NotNull

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Login loginNameType(Integer loginNameType) {
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

    public Login uin(String uin) {
        this.uin = uin;
        return this;
    }

    /**
     * 微信或QQ对应的openID
     *
     * @return uin
     **/
    @ApiModelProperty(example = "wid_syndekas34mnsj", value = "微信或QQ对应的openID")

    public String getUin() {
        return uin;
    }

    public void setUin(String uin) {
        this.uin = uin;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Login login = (Login) o;
        return Objects.equals(this.loginName, login.loginName) &&
                Objects.equals(this.loginNameType, login.loginNameType) &&
                Objects.equals(this.uin, login.uin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginName, loginNameType, uin);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Login {\n");

        sb.append("    loginName: ").append(toIndentedString(loginName)).append("\n");
        sb.append("    loginNameType: ").append(toIndentedString(loginNameType)).append("\n");
        sb.append("    uin: ").append(toIndentedString(uin)).append("\n");
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
