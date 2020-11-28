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
 * AddCollegeRequest
 */
@Validated
public class AddCollegeRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("ministry")
  private String ministry = null;

  @JsonProperty("identification")
  private String identification = null;

  @JsonProperty("location")
  private String location = null;

  @JsonProperty("level")
  private String level = null;

  @JsonProperty("memo")
  private String memo = null;

  public AddCollegeRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * 学校名称
   * @return name
  **/
  @ApiModelProperty(example = "四川大学", required = true, value = "学校名称")
  @NotNull

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AddCollegeRequest ministry(String ministry) {
    this.ministry = ministry;
    return this;
  }

  /**
   * 主管部门
   * @return ministry
  **/
  @ApiModelProperty(example = "教育部", required = true, value = "主管部门")
  @NotNull

  public String getMinistry() {
    return ministry;
  }

  public void setMinistry(String ministry) {
    this.ministry = ministry;
  }

  public AddCollegeRequest identification(String identification) {
    this.identification = identification;
    return this;
  }

  /**
   * 学校标识码
   * @return identification
  **/
  @ApiModelProperty(example = "4151010610", required = true, value = "学校标识码")
  @NotNull

  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }

  public AddCollegeRequest location(String location) {
    this.location = location;
    return this;
  }

  /**
   * 所在地
   * @return location
  **/
  @ApiModelProperty(example = "成都", value = "所在地")

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public AddCollegeRequest level(String level) {
    this.level = level;
    return this;
  }

  /**
   * 办学层次
   * @return level
  **/
  @ApiModelProperty(example = "本科", value = "办学层次")

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public AddCollegeRequest memo(String memo) {
    this.memo = memo;
    return this;
  }

  /**
   * 备注
   * @return memo
  **/
  @ApiModelProperty(example = "备注", value = "备注")

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddCollegeRequest addCollegeRequest = (AddCollegeRequest) o;
    return Objects.equals(this.name, addCollegeRequest.name) &&
        Objects.equals(this.ministry, addCollegeRequest.ministry) &&
        Objects.equals(this.identification, addCollegeRequest.identification) &&
        Objects.equals(this.location, addCollegeRequest.location) &&
        Objects.equals(this.level, addCollegeRequest.level) &&
        Objects.equals(this.memo, addCollegeRequest.memo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, ministry, identification, location, level, memo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddCollegeRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ministry: ").append(toIndentedString(ministry)).append("\n");
    sb.append("    identification: ").append(toIndentedString(identification)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    memo: ").append(toIndentedString(memo)).append("\n");
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
