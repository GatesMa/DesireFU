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
 * AddRoleRelationRequest
 */
@Validated
public class AddRoleRelationRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("accountId")
  private Long accountId = null;

  @JsonProperty("userId")
  private Long userId = null;

  @JsonProperty("role")
  private Integer role = null;

  @JsonProperty("accountType")
  private Integer accountType = null;

  public AddRoleRelationRequest accountId(Long accountId) {
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

  public AddRoleRelationRequest userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * 操作者
   * @return userId
  **/
  @ApiModelProperty(example = "3453454", value = "操作者")

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public AddRoleRelationRequest role(Integer role) {
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

  public AddRoleRelationRequest accountType(Integer accountType) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddRoleRelationRequest addRoleRelationRequest = (AddRoleRelationRequest) o;
    return Objects.equals(this.accountId, addRoleRelationRequest.accountId) &&
        Objects.equals(this.userId, addRoleRelationRequest.userId) &&
        Objects.equals(this.role, addRoleRelationRequest.role) &&
        Objects.equals(this.accountType, addRoleRelationRequest.accountType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, userId, role, accountType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddRoleRelationRequest {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
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
