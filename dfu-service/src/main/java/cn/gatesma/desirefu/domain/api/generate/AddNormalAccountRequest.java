package cn.gatesma.desirefu.domain.api.generate;

import java.util.Objects;
import cn.gatesma.desirefu.domain.api.generate.AddAccountRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AddNormalAccountRequest
 */
@Validated
public class AddNormalAccountRequest extends AddAccountRequest implements Serializable {
  private static final long serialVersionUID = 1L;

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

  public AddNormalAccountRequest collegeId(Integer collegeId) {
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

  public AddNormalAccountRequest departmentId(Integer departmentId) {
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

  public AddNormalAccountRequest major(String major) {
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

  public AddNormalAccountRequest stuId(String stuId) {
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

  public AddNormalAccountRequest realName(String realName) {
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
    AddNormalAccountRequest addNormalAccountRequest = (AddNormalAccountRequest) o;
    return Objects.equals(this.collegeId, addNormalAccountRequest.collegeId) &&
        Objects.equals(this.departmentId, addNormalAccountRequest.departmentId) &&
        Objects.equals(this.major, addNormalAccountRequest.major) &&
        Objects.equals(this.stuId, addNormalAccountRequest.stuId) &&
        Objects.equals(this.realName, addNormalAccountRequest.realName) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(collegeId, departmentId, major, stuId, realName, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddNormalAccountRequest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
