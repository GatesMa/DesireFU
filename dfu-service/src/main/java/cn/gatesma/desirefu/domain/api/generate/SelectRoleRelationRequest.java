package cn.gatesma.desirefu.domain.api.generate;

import java.util.Objects;
import cn.gatesma.desirefu.domain.api.generate.Page;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SelectRoleRelationRequest
 */
@Validated
public class SelectRoleRelationRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("page")
  private Page page = null;

  @JsonProperty("accountId")
  private Long accountId = null;

  @JsonProperty("userId")
  private Long userId = null;

  @JsonProperty("role")
  private Integer role = null;

  public SelectRoleRelationRequest page(Page page) {
    this.page = page;
    return this;
  }

  /**
   * Get page
   * @return page
  **/
  @ApiModelProperty(value = "")

  @Valid
  public Page getPage() {
    return page;
  }

  public void setPage(Page page) {
    this.page = page;
  }

  public SelectRoleRelationRequest accountId(Long accountId) {
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

  public SelectRoleRelationRequest userId(Long userId) {
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

  public SelectRoleRelationRequest role(Integer role) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SelectRoleRelationRequest selectRoleRelationRequest = (SelectRoleRelationRequest) o;
    return Objects.equals(this.page, selectRoleRelationRequest.page) &&
        Objects.equals(this.accountId, selectRoleRelationRequest.accountId) &&
        Objects.equals(this.userId, selectRoleRelationRequest.userId) &&
        Objects.equals(this.role, selectRoleRelationRequest.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, accountId, userId, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SelectRoleRelationRequest {\n");
    
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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
