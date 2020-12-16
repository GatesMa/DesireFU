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
 * AddCollegeData
 */
@Validated
public class AddCollegeData  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("college_id")
  private Integer collegeId = null;

  public AddCollegeData collegeId(Integer collegeId) {
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
    AddCollegeData addCollegeData = (AddCollegeData) o;
    return Objects.equals(this.collegeId, addCollegeData.collegeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(collegeId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddCollegeData {\n");
    
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
