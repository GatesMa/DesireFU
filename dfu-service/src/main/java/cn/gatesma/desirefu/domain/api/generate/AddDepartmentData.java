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
 * AddDepartmentData
 */
@Validated
public class AddDepartmentData  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("department_id")
  private Integer departmentId = null;

  public AddDepartmentData departmentId(Integer departmentId) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddDepartmentData addDepartmentData = (AddDepartmentData) o;
    return Objects.equals(this.departmentId, addDepartmentData.departmentId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(departmentId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddDepartmentData {\n");
    
    sb.append("    departmentId: ").append(toIndentedString(departmentId)).append("\n");
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
