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
 * 学院
 */
@ApiModel(description = "学院")
@Validated
public class Department  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("department_id")
  private Integer departmentId = null;

  @JsonProperty("college_id")
  private Integer collegeId = null;

  @JsonProperty("created_time")
  private String createdTime = null;

  @JsonProperty("last_modified_time")
  private String lastModifiedTime = null;

  public Department name(String name) {
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

  public Department departmentId(Integer departmentId) {
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

  public Department collegeId(Integer collegeId) {
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

  public Department createdTime(String createdTime) {
    this.createdTime = createdTime;
    return this;
  }

  /**
   * 创建时间，格式：yyyy-MM-dd HH:mm:ss
   * @return createdTime
  **/
  @ApiModelProperty(example = "2020-01-01 00:00:00", value = "创建时间，格式：yyyy-MM-dd HH:mm:ss")

  public String getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(String createdTime) {
    this.createdTime = createdTime;
  }

  public Department lastModifiedTime(String lastModifiedTime) {
    this.lastModifiedTime = lastModifiedTime;
    return this;
  }

  /**
   * 最后修改时间，格式：yyyy-MM-dd HH:mm:ss
   * @return lastModifiedTime
  **/
  @ApiModelProperty(example = "2000-01-01 00:00:00", value = "最后修改时间，格式：yyyy-MM-dd HH:mm:ss")

  public String getLastModifiedTime() {
    return lastModifiedTime;
  }

  public void setLastModifiedTime(String lastModifiedTime) {
    this.lastModifiedTime = lastModifiedTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Department department = (Department) o;
    return Objects.equals(this.name, department.name) &&
        Objects.equals(this.departmentId, department.departmentId) &&
        Objects.equals(this.collegeId, department.collegeId) &&
        Objects.equals(this.createdTime, department.createdTime) &&
        Objects.equals(this.lastModifiedTime, department.lastModifiedTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, departmentId, collegeId, createdTime, lastModifiedTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Department {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    departmentId: ").append(toIndentedString(departmentId)).append("\n");
    sb.append("    collegeId: ").append(toIndentedString(collegeId)).append("\n");
    sb.append("    createdTime: ").append(toIndentedString(createdTime)).append("\n");
    sb.append("    lastModifiedTime: ").append(toIndentedString(lastModifiedTime)).append("\n");
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
