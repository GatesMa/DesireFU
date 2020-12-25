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
 * CanLoginAccountItem
 */
@Validated
public class CanLoginAccountItem  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("account_id")
  private Long accountId = null;

  @JsonProperty("account_type")
  private Integer accountType = null;

  @JsonProperty("account_name")
  private String accountName = null;

  @JsonProperty("role")
  private Integer role = null;

  @JsonProperty("role_name")
  private String roleName = null;

  @JsonProperty("account_status")
  private Integer accountStatus = null;

  @JsonProperty("account_status_str")
  private String accountStatusStr = null;

  public CanLoginAccountItem accountId(Long accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * 账号ID
   * @return accountId
  **/
  @ApiModelProperty(example = "100000", value = "账号ID")

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public CanLoginAccountItem accountType(Integer accountType) {
    this.accountType = accountType;
    return this;
  }

  /**
   * 账号类型
   * @return accountType
  **/
  @ApiModelProperty(example = "1", value = "账号类型")

  public Integer getAccountType() {
    return accountType;
  }

  public void setAccountType(Integer accountType) {
    this.accountType = accountType;
  }

  public CanLoginAccountItem accountName(String accountName) {
    this.accountName = accountName;
    return this;
  }

  /**
   * 账号名称
   * @return accountName
  **/
  @ApiModelProperty(value = "账号名称")

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public CanLoginAccountItem role(Integer role) {
    this.role = role;
    return this;
  }

  /**
   * 角色
   * @return role
  **/
  @ApiModelProperty(example = "1", value = "角色")

  public Integer getRole() {
    return role;
  }

  public void setRole(Integer role) {
    this.role = role;
  }

  public CanLoginAccountItem roleName(String roleName) {
    this.roleName = roleName;
    return this;
  }

  /**
   * 角色名称
   * @return roleName
  **/
  @ApiModelProperty(value = "角色名称")

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public CanLoginAccountItem accountStatus(Integer accountStatus) {
    this.accountStatus = accountStatus;
    return this;
  }

  /**
   * 账号状态
   * @return accountStatus
  **/
  @ApiModelProperty(example = "1", value = "账号状态")

  public Integer getAccountStatus() {
    return accountStatus;
  }

  public void setAccountStatus(Integer accountStatus) {
    this.accountStatus = accountStatus;
  }

  public CanLoginAccountItem accountStatusStr(String accountStatusStr) {
    this.accountStatusStr = accountStatusStr;
    return this;
  }

  /**
   * 账号状态
   * @return accountStatusStr
  **/
  @ApiModelProperty(example = "有效", value = "账号状态")

  public String getAccountStatusStr() {
    return accountStatusStr;
  }

  public void setAccountStatusStr(String accountStatusStr) {
    this.accountStatusStr = accountStatusStr;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CanLoginAccountItem canLoginAccountItem = (CanLoginAccountItem) o;
    return Objects.equals(this.accountId, canLoginAccountItem.accountId) &&
        Objects.equals(this.accountType, canLoginAccountItem.accountType) &&
        Objects.equals(this.accountName, canLoginAccountItem.accountName) &&
        Objects.equals(this.role, canLoginAccountItem.role) &&
        Objects.equals(this.roleName, canLoginAccountItem.roleName) &&
        Objects.equals(this.accountStatus, canLoginAccountItem.accountStatus) &&
        Objects.equals(this.accountStatusStr, canLoginAccountItem.accountStatusStr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, accountType, accountName, role, roleName, accountStatus, accountStatusStr);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CanLoginAccountItem {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    accountName: ").append(toIndentedString(accountName)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    roleName: ").append(toIndentedString(roleName)).append("\n");
    sb.append("    accountStatus: ").append(toIndentedString(accountStatus)).append("\n");
    sb.append("    accountStatusStr: ").append(toIndentedString(accountStatusStr)).append("\n");
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
