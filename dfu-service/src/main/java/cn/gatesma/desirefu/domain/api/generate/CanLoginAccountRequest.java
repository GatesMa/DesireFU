package cn.gatesma.desirefu.domain.api.generate;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CanLoginAccountRequest
 */
@Validated
public class CanLoginAccountRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("login_name")
  private String loginName = null;

  @JsonProperty("login_name_type")
  private Integer loginNameType = null;

  @JsonProperty("user_id")
  private Long userId = null;

  public CanLoginAccountRequest loginName(String loginName) {
    this.loginName = loginName;
    return this;
  }

  /**
   * 登录账号名称
   * @return loginName
  **/
  @ApiModelProperty(value = "登录账号名称")

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public CanLoginAccountRequest loginNameType(Integer loginNameType) {
    this.loginNameType = loginNameType;
    return this;
  }

  /**
   * 登录账号类型
   * @return loginNameType
  **/
  @ApiModelProperty(example = "1", value = "登录账号类型")

  public Integer getLoginNameType() {
    return loginNameType;
  }

  public void setLoginNameType(Integer loginNameType) {
    this.loginNameType = loginNameType;
  }

  public CanLoginAccountRequest userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * 用户ID
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
    CanLoginAccountRequest canLoginAccountRequest = (CanLoginAccountRequest) o;
    return Objects.equals(this.loginName, canLoginAccountRequest.loginName) &&
        Objects.equals(this.loginNameType, canLoginAccountRequest.loginNameType) &&
        Objects.equals(this.userId, canLoginAccountRequest.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(loginName, loginNameType, userId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CanLoginAccountRequest {\n");
    
    sb.append("    loginName: ").append(toIndentedString(loginName)).append("\n");
    sb.append("    loginNameType: ").append(toIndentedString(loginNameType)).append("\n");
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
