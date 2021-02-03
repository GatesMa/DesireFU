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
 * SelectOrganizeApplicationRequest
 */
@Validated
public class SelectOrganizeApplicationRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("captainAccountId")
  private Long captainAccountId = null;

  @JsonProperty("organizeId")
  private Long organizeId = null;

  @JsonProperty("account_id")
  private Long accountId = null;

  @JsonProperty("account_type")
  private Integer accountType = null;

  @JsonProperty("status")
  private Integer status = null;

  public SelectOrganizeApplicationRequest captainAccountId(Long captainAccountId) {
    this.captainAccountId = captainAccountId;
    return this;
  }

  /**
   * 队长的账号Id，如果传了这个字段，organizeId无效
   * @return captainAccountId
  **/
  @ApiModelProperty(example = "100000", value = "队长的账号Id，如果传了这个字段，organizeId无效")

  public Long getCaptainAccountId() {
    return captainAccountId;
  }

  public void setCaptainAccountId(Long captainAccountId) {
    this.captainAccountId = captainAccountId;
  }

  public SelectOrganizeApplicationRequest organizeId(Long organizeId) {
    this.organizeId = organizeId;
    return this;
  }

  /**
   * 账号ID
   * @return organizeId
  **/
  @ApiModelProperty(example = "100000", value = "账号ID")

  public Long getOrganizeId() {
    return organizeId;
  }

  public void setOrganizeId(Long organizeId) {
    this.organizeId = organizeId;
  }

  public SelectOrganizeApplicationRequest accountId(Long accountId) {
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

  public SelectOrganizeApplicationRequest accountType(Integer accountType) {
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

  public SelectOrganizeApplicationRequest status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * 申请状态
   * @return status
  **/
  @ApiModelProperty(example = "1", value = "申请状态")

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SelectOrganizeApplicationRequest selectOrganizeApplicationRequest = (SelectOrganizeApplicationRequest) o;
    return Objects.equals(this.captainAccountId, selectOrganizeApplicationRequest.captainAccountId) &&
        Objects.equals(this.organizeId, selectOrganizeApplicationRequest.organizeId) &&
        Objects.equals(this.accountId, selectOrganizeApplicationRequest.accountId) &&
        Objects.equals(this.accountType, selectOrganizeApplicationRequest.accountType) &&
        Objects.equals(this.status, selectOrganizeApplicationRequest.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(captainAccountId, organizeId, accountId, accountType, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SelectOrganizeApplicationRequest {\n");
    
    sb.append("    captainAccountId: ").append(toIndentedString(captainAccountId)).append("\n");
    sb.append("    organizeId: ").append(toIndentedString(organizeId)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
