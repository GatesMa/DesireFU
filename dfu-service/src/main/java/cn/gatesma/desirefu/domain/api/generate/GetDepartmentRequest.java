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
 * GetDepartmentRequest
 */
@Validated
public class GetDepartmentRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("department_id")
  private Integer departmentId = null;

  @JsonProperty("college_id")
  private Integer collegeId = null;

  public GetDepartmentRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * 学院名称
   * @return name
  **/
  @ApiModelProperty(example = "计算机学院", value = "学院名称")

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GetDepartmentRequest departmentId(Integer departmentId) {
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

  public GetDepartmentRequest collegeId(Integer collegeId) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetDepartmentRequest getDepartmentRequest = (GetDepartmentRequest) o;
    return Objects.equals(this.name, getDepartmentRequest.name) &&
        Objects.equals(this.departmentId, getDepartmentRequest.departmentId) &&
        Objects.equals(this.collegeId, getDepartmentRequest.collegeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, departmentId, collegeId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetDepartmentRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    departmentId: ").append(toIndentedString(departmentId)).append("\n");
    sb.append("    collegeId: ").append(toIndentedString(collegeId)).append("\n");
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
