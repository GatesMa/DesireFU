package cn.gatesma.desirefu.domain.api.generate;

import java.util.Objects;
import cn.gatesma.desirefu.domain.api.generate.SelectCompetitionData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GetCollectCompetitionData
 */
@Validated
public class GetCollectCompetitionData  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("accountId")
  private Long accountId = null;

  @JsonProperty("competitionId")
  private Long competitionId = null;

  @JsonProperty("competition")
  private SelectCompetitionData competition = null;

  @JsonProperty("createdTime")
  private String createdTime = null;

  public GetCollectCompetitionData id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * id
   * @return id
  **/
  @ApiModelProperty(example = "100000", value = "id")

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public GetCollectCompetitionData accountId(Long accountId) {
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

  public GetCollectCompetitionData competitionId(Long competitionId) {
    this.competitionId = competitionId;
    return this;
  }

  /**
   * 比赛id
   * @return competitionId
  **/
  @ApiModelProperty(example = "123", value = "比赛id")

  public Long getCompetitionId() {
    return competitionId;
  }

  public void setCompetitionId(Long competitionId) {
    this.competitionId = competitionId;
  }

  public GetCollectCompetitionData competition(SelectCompetitionData competition) {
    this.competition = competition;
    return this;
  }

  /**
   * Get competition
   * @return competition
  **/
  @ApiModelProperty(value = "")

  @Valid
  public SelectCompetitionData getCompetition() {
    return competition;
  }

  public void setCompetition(SelectCompetitionData competition) {
    this.competition = competition;
  }

  public GetCollectCompetitionData createdTime(String createdTime) {
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
    GetCollectCompetitionData getCollectCompetitionData = (GetCollectCompetitionData) o;
    return Objects.equals(this.id, getCollectCompetitionData.id) &&
        Objects.equals(this.accountId, getCollectCompetitionData.accountId) &&
        Objects.equals(this.competitionId, getCollectCompetitionData.competitionId) &&
        Objects.equals(this.competition, getCollectCompetitionData.competition) &&
        Objects.equals(this.createdTime, getCollectCompetitionData.createdTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, accountId, competitionId, competition, createdTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCollectCompetitionData {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    competitionId: ").append(toIndentedString(competitionId)).append("\n");
    sb.append("    competition: ").append(toIndentedString(competition)).append("\n");
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
