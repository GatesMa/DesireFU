package cn.gatesma.desirefu.domain.api.generate;

import java.util.Objects;
import cn.gatesma.desirefu.domain.api.generate.GetNormalAccountData;
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
 * OrganizeData
 */
@Validated
public class OrganizeData  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("organizeId")
  private Long organizeId = null;

  @JsonProperty("competitionId")
  private Long competitionId = null;

  @JsonProperty("competition")
  private SelectCompetitionData competition = null;

  @JsonProperty("srcAccountId")
  private Long srcAccountId = null;

  @JsonProperty("nickName")
  private String nickName = null;

  @JsonProperty("created_ime")
  private String createdIme = null;

  @JsonProperty("memberNum")
  private Integer memberNum = null;

  @JsonProperty("captain")
  private GetNormalAccountData captain = null;

  public OrganizeData organizeId(Long organizeId) {
    this.organizeId = organizeId;
    return this;
  }

  /**
   * 账号ID
   * @return organizeId
  **/
  @ApiModelProperty(example = "100000", value = "账号ID")

  public Long getOrganizeId() {
    return organizeId;
  }

  public void setOrganizeId(Long organizeId) {
    this.organizeId = organizeId;
  }

  public OrganizeData competitionId(Long competitionId) {
    this.competitionId = competitionId;
    return this;
  }

  /**
   * 比赛ID
   * @return competitionId
  **/
  @ApiModelProperty(example = "2211", value = "比赛ID")

  public Long getCompetitionId() {
    return competitionId;
  }

  public void setCompetitionId(Long competitionId) {
    this.competitionId = competitionId;
  }

  public OrganizeData competition(SelectCompetitionData competition) {
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

  public OrganizeData srcAccountId(Long srcAccountId) {
    this.srcAccountId = srcAccountId;
    return this;
  }

  /**
   * 队长账号ID
   * @return srcAccountId
  **/
  @ApiModelProperty(example = "1111", value = "队长账号ID")

  public Long getSrcAccountId() {
    return srcAccountId;
  }

  public void setSrcAccountId(Long srcAccountId) {
    this.srcAccountId = srcAccountId;
  }

  public OrganizeData nickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  /**
   * 队伍名称
   * @return nickName
  **/
  @ApiModelProperty(value = "队伍名称")

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public OrganizeData createdIme(String createdIme) {
    this.createdIme = createdIme;
    return this;
  }

  /**
   * 创建时间，格式：yyyy-MM-dd HH:mm:ss
   * @return createdIme
  **/
  @ApiModelProperty(example = "2020-01-01 12:00:00", value = "创建时间，格式：yyyy-MM-dd HH:mm:ss")

  public String getCreatedIme() {
    return createdIme;
  }

  public void setCreatedIme(String createdIme) {
    this.createdIme = createdIme;
  }

  public OrganizeData memberNum(Integer memberNum) {
    this.memberNum = memberNum;
    return this;
  }

  /**
   * 队伍人数
   * @return memberNum
  **/
  @ApiModelProperty(example = "5", value = "队伍人数")

  public Integer getMemberNum() {
    return memberNum;
  }

  public void setMemberNum(Integer memberNum) {
    this.memberNum = memberNum;
  }

  public OrganizeData captain(GetNormalAccountData captain) {
    this.captain = captain;
    return this;
  }

  /**
   * Get captain
   * @return captain
  **/
  @ApiModelProperty(value = "")

  @Valid
  public GetNormalAccountData getCaptain() {
    return captain;
  }

  public void setCaptain(GetNormalAccountData captain) {
    this.captain = captain;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganizeData organizeData = (OrganizeData) o;
    return Objects.equals(this.organizeId, organizeData.organizeId) &&
        Objects.equals(this.competitionId, organizeData.competitionId) &&
        Objects.equals(this.competition, organizeData.competition) &&
        Objects.equals(this.srcAccountId, organizeData.srcAccountId) &&
        Objects.equals(this.nickName, organizeData.nickName) &&
        Objects.equals(this.createdIme, organizeData.createdIme) &&
        Objects.equals(this.memberNum, organizeData.memberNum) &&
        Objects.equals(this.captain, organizeData.captain);
  }

  @Override
  public int hashCode() {
    return Objects.hash(organizeId, competitionId, competition, srcAccountId, nickName, createdIme, memberNum, captain);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizeData {\n");
    
    sb.append("    organizeId: ").append(toIndentedString(organizeId)).append("\n");
    sb.append("    competitionId: ").append(toIndentedString(competitionId)).append("\n");
    sb.append("    competition: ").append(toIndentedString(competition)).append("\n");
    sb.append("    srcAccountId: ").append(toIndentedString(srcAccountId)).append("\n");
    sb.append("    nickName: ").append(toIndentedString(nickName)).append("\n");
    sb.append("    createdIme: ").append(toIndentedString(createdIme)).append("\n");
    sb.append("    memberNum: ").append(toIndentedString(memberNum)).append("\n");
    sb.append("    captain: ").append(toIndentedString(captain)).append("\n");
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
