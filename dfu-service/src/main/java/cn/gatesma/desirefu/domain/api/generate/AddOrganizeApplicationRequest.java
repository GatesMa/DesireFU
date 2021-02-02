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
 * AddOrganizeApplicationRequest
 */
@Validated
public class AddOrganizeApplicationRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("organizeId")
  private Long organizeId = null;

  @JsonProperty("accountId")
  private Long accountId = null;

  @JsonProperty("accountType")
  private Integer accountType = null;

  @JsonProperty("createdUserId")
  private Long createdUserId = null;

  public AddOrganizeApplicationRequest organizeId(Long organizeId) {
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

  public AddOrganizeApplicationRequest accountId(Long accountId) {
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

  public AddOrganizeApplicationRequest accountType(Integer accountType) {
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

  public AddOrganizeApplicationRequest createdUserId(Long createdUserId) {
    this.createdUserId = createdUserId;
    return this;
  }

  /**
   * 创建者
   * @return createdUserId
  **/
  @ApiModelProperty(example = "3453454", value = "创建者")

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
    AddOrganizeApplicationRequest addOrganizeApplicationRequest = (AddOrganizeApplicationRequest) o;
    return Objects.equals(this.organizeId, addOrganizeApplicationRequest.organizeId) &&
        Objects.equals(this.accountId, addOrganizeApplicationRequest.accountId) &&
        Objects.equals(this.accountType, addOrganizeApplicationRequest.accountType) &&
        Objects.equals(this.createdUserId, addOrganizeApplicationRequest.createdUserId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(organizeId, accountId, accountType, createdUserId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddOrganizeApplicationRequest {\n");
    
    sb.append("    organizeId: ").append(toIndentedString(organizeId)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
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
