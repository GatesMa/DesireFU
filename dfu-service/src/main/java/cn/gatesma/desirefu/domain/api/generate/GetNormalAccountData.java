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
 * GetNormalAccountData
 */
@Validated
public class GetNormalAccountData  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("account_id")
  private Long accountId = null;

  @JsonProperty("account_type")
  private Integer accountType = null;

  @JsonProperty("college_id")
  private Integer collegeId = null;

  @JsonProperty("college_name")
  private String collegeName = null;

  @JsonProperty("department_id")
  private Integer departmentId = null;

  @JsonProperty("department_name")
  private String departmentName = null;

  @JsonProperty("major")
  private String major = null;

  @JsonProperty("stu_id")
  private String stuId = null;

  @JsonProperty("real_name")
  private String realName = null;

  @JsonProperty("created_time")
  private String createdTime = null;

  public GetNormalAccountData accountId(Long accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * 账号ID
   * @return accountId
  **/
  @ApiModelProperty(example = "3939494", value = "账号ID")

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public GetNormalAccountData accountType(Integer accountType) {
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

  public GetNormalAccountData collegeId(Integer collegeId) {
    this.collegeId = collegeId;
    return this;
  }

  /**
   * 学校ID
   * @return collegeId
  **/
  @ApiModelProperty(example = "2211", value = "学校ID")

  public Integer getCollegeId() {
    return collegeId;
  }

  public void setCollegeId(Integer collegeId) {
    this.collegeId = collegeId;
  }

  public GetNormalAccountData collegeName(String collegeName) {
    this.collegeName = collegeName;
    return this;
  }

  /**
   * 学校中文
   * @return collegeName
  **/
  @ApiModelProperty(value = "学校中文")

  public String getCollegeName() {
    return collegeName;
  }

  public void setCollegeName(String collegeName) {
    this.collegeName = collegeName;
  }

  public GetNormalAccountData departmentId(Integer departmentId) {
    this.departmentId = departmentId;
    return this;
  }

  /**
   * 学院ID
   * @return departmentId
  **/
  @ApiModelProperty(example = "1111", value = "学院ID")

  public Integer getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Integer departmentId) {
    this.departmentId = departmentId;
  }

  public GetNormalAccountData departmentName(String departmentName) {
    this.departmentName = departmentName;
    return this;
  }

  /**
   * 学院中文
   * @return departmentName
  **/
  @ApiModelProperty(value = "学院中文")

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public GetNormalAccountData major(String major) {
    this.major = major;
    return this;
  }

  /**
   * 专业
   * @return major
  **/
  @ApiModelProperty(example = "计算机科学与技术", value = "专业")

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public GetNormalAccountData stuId(String stuId) {
    this.stuId = stuId;
    return this;
  }

  /**
   * 学号
   * @return stuId
  **/
  @ApiModelProperty(example = "2017141461189", value = "学号")

  public String getStuId() {
    return stuId;
  }

  public void setStuId(String stuId) {
    this.stuId = stuId;
  }

  public GetNormalAccountData realName(String realName) {
    this.realName = realName;
    return this;
  }

  /**
   * 真实姓名
   * @return realName
  **/
  @ApiModelProperty(example = "马保国", value = "真实姓名")

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public GetNormalAccountData createdTime(String createdTime) {
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
    GetNormalAccountData getNormalAccountData = (GetNormalAccountData) o;
    return Objects.equals(this.accountId, getNormalAccountData.accountId) &&
        Objects.equals(this.accountType, getNormalAccountData.accountType) &&
        Objects.equals(this.collegeId, getNormalAccountData.collegeId) &&
        Objects.equals(this.collegeName, getNormalAccountData.collegeName) &&
        Objects.equals(this.departmentId, getNormalAccountData.departmentId) &&
        Objects.equals(this.departmentName, getNormalAccountData.departmentName) &&
        Objects.equals(this.major, getNormalAccountData.major) &&
        Objects.equals(this.stuId, getNormalAccountData.stuId) &&
        Objects.equals(this.realName, getNormalAccountData.realName) &&
        Objects.equals(this.createdTime, getNormalAccountData.createdTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, accountType, collegeId, collegeName, departmentId, departmentName, major, stuId, realName, createdTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetNormalAccountData {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    collegeId: ").append(toIndentedString(collegeId)).append("\n");
    sb.append("    collegeName: ").append(toIndentedString(collegeName)).append("\n");
    sb.append("    departmentId: ").append(toIndentedString(departmentId)).append("\n");
    sb.append("    departmentName: ").append(toIndentedString(departmentName)).append("\n");
    sb.append("    major: ").append(toIndentedString(major)).append("\n");
    sb.append("    stuId: ").append(toIndentedString(stuId)).append("\n");
    sb.append("    realName: ").append(toIndentedString(realName)).append("\n");
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
