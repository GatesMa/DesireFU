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
 * GetCollegeRequest
 */
@Validated
public class GetCollegeRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("ministry")
  private String ministry = null;

  @JsonProperty("identification")
  private String identification = null;

  public GetCollegeRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * 高校名称
   * @return name
  **/
  @ApiModelProperty(example = "四川大学", value = "高校名称")

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GetCollegeRequest ministry(String ministry) {
    this.ministry = ministry;
    return this;
  }

  /**
   * 主管部门
   * @return ministry
  **/
  @ApiModelProperty(example = "教育部", value = "主管部门")

  public String getMinistry() {
    return ministry;
  }

  public void setMinistry(String ministry) {
    this.ministry = ministry;
  }

  public GetCollegeRequest identification(String identification) {
    this.identification = identification;
    return this;
  }

  /**
   * 唯一标识码
   * @return identification
  **/
  @ApiModelProperty(example = "4151010610", value = "唯一标识码")

  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCollegeRequest getCollegeRequest = (GetCollegeRequest) o;
    return Objects.equals(this.name, getCollegeRequest.name) &&
        Objects.equals(this.ministry, getCollegeRequest.ministry) &&
        Objects.equals(this.identification, getCollegeRequest.identification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, ministry, identification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCollegeRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ministry: ").append(toIndentedString(ministry)).append("\n");
    sb.append("    identification: ").append(toIndentedString(identification)).append("\n");
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
