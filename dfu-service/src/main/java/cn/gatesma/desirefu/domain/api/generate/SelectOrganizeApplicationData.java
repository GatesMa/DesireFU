package cn.gatesma.desirefu.domain.api.generate;

import java.util.Objects;
import cn.gatesma.desirefu.domain.api.generate.GetNormalAccountData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SelectOrganizeApplicationData
 */
@Validated
public class SelectOrganizeApplicationData  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("organizeId")
  private Long organizeId = null;

  @JsonProperty("account_id")
  private Long accountId = null;

  @JsonProperty("account_type")
  private Integer accountType = null;

  @JsonProperty("applicant")
  private GetNormalAccountData applicant = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("created_time")
  private String createdTime = null;

  public SelectOrganizeApplicationData id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * id
   * @return id
  **/
  @ApiModelProperty(example = "100000", value = "id")

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public SelectOrganizeApplicationData organizeId(Long organizeId) {
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

  public SelectOrganizeApplicationData accountId(Long accountId) {
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

  public SelectOrganizeApplicationData accountType(Integer accountType) {
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

  public SelectOrganizeApplicationData applicant(GetNormalAccountData applicant) {
    this.applicant = applicant;
    return this;
  }

  /**
   * Get applicant
   * @return applicant
  **/
  @ApiModelProperty(value = "")

  @Valid
  public GetNormalAccountData getApplicant() {
    return applicant;
  }

  public void setApplicant(GetNormalAccountData applicant) {
    this.applicant = applicant;
  }

  public SelectOrganizeApplicationData status(Integer status) {
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

  public SelectOrganizeApplicationData createdTime(String createdTime) {
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
    SelectOrganizeApplicationData selectOrganizeApplicationData = (SelectOrganizeApplicationData) o;
    return Objects.equals(this.id, selectOrganizeApplicationData.id) &&
        Objects.equals(this.organizeId, selectOrganizeApplicationData.organizeId) &&
        Objects.equals(this.accountId, selectOrganizeApplicationData.accountId) &&
        Objects.equals(this.accountType, selectOrganizeApplicationData.accountType) &&
        Objects.equals(this.applicant, selectOrganizeApplicationData.applicant) &&
        Objects.equals(this.status, selectOrganizeApplicationData.status) &&
        Objects.equals(this.createdTime, selectOrganizeApplicationData.createdTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, organizeId, accountId, accountType, applicant, status, createdTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SelectOrganizeApplicationData {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    organizeId: ").append(toIndentedString(organizeId)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    applicant: ").append(toIndentedString(applicant)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
