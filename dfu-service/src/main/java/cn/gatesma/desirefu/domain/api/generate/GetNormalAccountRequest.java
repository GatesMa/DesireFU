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
 * GetNormalAccountRequest
 */
@Validated
public class GetNormalAccountRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("account_id")
  private Long accountId = null;

  @JsonProperty("college_id")
  private Integer collegeId = null;

  @JsonProperty("department_id")
  private Integer departmentId = null;

  @JsonProperty("major")
  private String major = null;

  @JsonProperty("stu_id")
  private String stuId = null;

  @JsonProperty("real_name")
  private String realName = null;

  public GetNormalAccountRequest accountId(Long accountId) {
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

  public GetNormalAccountRequest collegeId(Integer collegeId) {
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

  public GetNormalAccountRequest departmentId(Integer departmentId) {
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

  public GetNormalAccountRequest major(String major) {
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

  public GetNormalAccountRequest stuId(String stuId) {
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

  public GetNormalAccountRequest realName(String realName) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetNormalAccountRequest getNormalAccountRequest = (GetNormalAccountRequest) o;
    return Objects.equals(this.accountId, getNormalAccountRequest.accountId) &&
        Objects.equals(this.collegeId, getNormalAccountRequest.collegeId) &&
        Objects.equals(this.departmentId, getNormalAccountRequest.departmentId) &&
        Objects.equals(this.major, getNormalAccountRequest.major) &&
        Objects.equals(this.stuId, getNormalAccountRequest.stuId) &&
        Objects.equals(this.realName, getNormalAccountRequest.realName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, collegeId, departmentId, major, stuId, realName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetNormalAccountRequest {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    collegeId: ").append(toIndentedString(collegeId)).append("\n");
    sb.append("    departmentId: ").append(toIndentedString(departmentId)).append("\n");
    sb.append("    major: ").append(toIndentedString(major)).append("\n");
    sb.append("    stuId: ").append(toIndentedString(stuId)).append("\n");
    sb.append("    realName: ").append(toIndentedString(realName)).append("\n");
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
