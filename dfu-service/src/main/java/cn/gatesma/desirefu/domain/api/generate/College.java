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
 * 高校
 */
@ApiModel(description = "高校")
@Validated
public class College  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("college_id")
  private Integer collegeId = null;

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

  @JsonProperty("created_time")
  private String createdTime = null;

  @JsonProperty("last_modified_time")
  private String lastModifiedTime = null;

  public College collegeId(Integer collegeId) {
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

  public College name(String name) {
    this.name = name;
    return this;
  }

  /**
   * 学校名称
   * @return name
  **/
  @ApiModelProperty(example = "四川大学", value = "学校名称")

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public College ministry(String ministry) {
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

  public College identification(String identification) {
    this.identification = identification;
    return this;
  }

  /**
   * 学校标识码
   * @return identification
  **/
  @ApiModelProperty(example = "4151010610", value = "学校标识码")

  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }

  public College location(String location) {
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

  public College level(String level) {
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

  public College memo(String memo) {
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

  public College createdTime(String createdTime) {
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

  public College lastModifiedTime(String lastModifiedTime) {
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
    College college = (College) o;
    return Objects.equals(this.collegeId, college.collegeId) &&
        Objects.equals(this.name, college.name) &&
        Objects.equals(this.ministry, college.ministry) &&
        Objects.equals(this.identification, college.identification) &&
        Objects.equals(this.location, college.location) &&
        Objects.equals(this.level, college.level) &&
        Objects.equals(this.memo, college.memo) &&
        Objects.equals(this.createdTime, college.createdTime) &&
        Objects.equals(this.lastModifiedTime, college.lastModifiedTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(collegeId, name, ministry, identification, location, level, memo, createdTime, lastModifiedTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class College {\n");
    
    sb.append("    collegeId: ").append(toIndentedString(collegeId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ministry: ").append(toIndentedString(ministry)).append("\n");
    sb.append("    identification: ").append(toIndentedString(identification)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    memo: ").append(toIndentedString(memo)).append("\n");
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
