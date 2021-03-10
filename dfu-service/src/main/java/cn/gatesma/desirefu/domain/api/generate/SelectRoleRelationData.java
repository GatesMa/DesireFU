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
 * SelectRoleRelationData
 */
@Validated
public class SelectRoleRelationData  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("accountRoleId")
  private Long accountRoleId = null;

  @JsonProperty("accountId")
  private Long accountId = null;

  @JsonProperty("userId")
  private Long userId = null;

  @JsonProperty("role")
  private Integer role = null;

  @JsonProperty("createdTime")
  private String createdTime = null;

  public SelectRoleRelationData accountRoleId(Long accountRoleId) {
    this.accountRoleId = accountRoleId;
    return this;
  }

  /**
   * accountRoleId
   * @return accountRoleId
  **/
  @ApiModelProperty(example = "1", value = "accountRoleId")

  public Long getAccountRoleId() {
    return accountRoleId;
  }

  public void setAccountRoleId(Long accountRoleId) {
    this.accountRoleId = accountRoleId;
  }

  public SelectRoleRelationData accountId(Long accountId) {
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

  public SelectRoleRelationData userId(Long userId) {
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

  public SelectRoleRelationData role(Integer role) {
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

  public SelectRoleRelationData createdTime(String createdTime) {
    this.createdTime = createdTime;
    return this;
  }

  /**
   * 创建时间，格式：yyyy-MM-dd HH:mm:ss
   * @return createdTime
  **/
  @ApiModelProperty(example = "2020-01-01 12:00:00", value = "创建时间，格式：yyyy-MM-dd HH:mm:ss")

  public String getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(String createdTime) {
    this.createdTime = createdTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SelectRoleRelationData selectRoleRelationData = (SelectRoleRelationData) o;
    return Objects.equals(this.accountRoleId, selectRoleRelationData.accountRoleId) &&
        Objects.equals(this.accountId, selectRoleRelationData.accountId) &&
        Objects.equals(this.userId, selectRoleRelationData.userId) &&
        Objects.equals(this.role, selectRoleRelationData.role) &&
        Objects.equals(this.createdTime, selectRoleRelationData.createdTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountRoleId, accountId, userId, role, createdTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SelectRoleRelationData {\n");
    
    sb.append("    accountRoleId: ").append(toIndentedString(accountRoleId)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    createdTime: ").append(toIndentedString(createdTime)).append("\n");
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
