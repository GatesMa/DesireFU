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
 * GetCompetitionBasicDataData
 */
@Validated
public class GetCompetitionBasicDataData  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("allCnt")
  private Integer allCnt = null;

  @JsonProperty("validCnt")
  private Integer validCnt = null;

  @JsonProperty("pv")
  private Integer pv = null;

  @JsonProperty("notStartCnt")
  private Integer notStartCnt = null;

  @JsonProperty("startCnt")
  private Integer startCnt = null;

  @JsonProperty("endCnt")
  private Integer endCnt = null;

  public GetCompetitionBasicDataData allCnt(Integer allCnt) {
    this.allCnt = allCnt;
    return this;
  }

  /**
   * 全部个数
   * @return allCnt
  **/
  @ApiModelProperty(example = "10", value = "全部个数")

  public Integer getAllCnt() {
    return allCnt;
  }

  public void setAllCnt(Integer allCnt) {
    this.allCnt = allCnt;
  }

  public GetCompetitionBasicDataData validCnt(Integer validCnt) {
    this.validCnt = validCnt;
    return this;
  }

  /**
   * 有效个数
   * @return validCnt
  **/
  @ApiModelProperty(example = "8", value = "有效个数")

  public Integer getValidCnt() {
    return validCnt;
  }

  public void setValidCnt(Integer validCnt) {
    this.validCnt = validCnt;
  }

  public GetCompetitionBasicDataData pv(Integer pv) {
    this.pv = pv;
    return this;
  }

  /**
   * 浏览量
   * @return pv
  **/
  @ApiModelProperty(example = "124", value = "浏览量")

  public Integer getPv() {
    return pv;
  }

  public void setPv(Integer pv) {
    this.pv = pv;
  }

  public GetCompetitionBasicDataData notStartCnt(Integer notStartCnt) {
    this.notStartCnt = notStartCnt;
    return this;
  }

  /**
   * 未开始
   * @return notStartCnt
  **/
  @ApiModelProperty(example = "1", value = "未开始")

  public Integer getNotStartCnt() {
    return notStartCnt;
  }

  public void setNotStartCnt(Integer notStartCnt) {
    this.notStartCnt = notStartCnt;
  }

  public GetCompetitionBasicDataData startCnt(Integer startCnt) {
    this.startCnt = startCnt;
    return this;
  }

  /**
   * 进行中
   * @return startCnt
  **/
  @ApiModelProperty(example = "1", value = "进行中")

  public Integer getStartCnt() {
    return startCnt;
  }

  public void setStartCnt(Integer startCnt) {
    this.startCnt = startCnt;
  }

  public GetCompetitionBasicDataData endCnt(Integer endCnt) {
    this.endCnt = endCnt;
    return this;
  }

  /**
   * 已结束
   * @return endCnt
  **/
  @ApiModelProperty(example = "1", value = "已结束")

  public Integer getEndCnt() {
    return endCnt;
  }

  public void setEndCnt(Integer endCnt) {
    this.endCnt = endCnt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCompetitionBasicDataData getCompetitionBasicDataData = (GetCompetitionBasicDataData) o;
    return Objects.equals(this.allCnt, getCompetitionBasicDataData.allCnt) &&
        Objects.equals(this.validCnt, getCompetitionBasicDataData.validCnt) &&
        Objects.equals(this.pv, getCompetitionBasicDataData.pv) &&
        Objects.equals(this.notStartCnt, getCompetitionBasicDataData.notStartCnt) &&
        Objects.equals(this.startCnt, getCompetitionBasicDataData.startCnt) &&
        Objects.equals(this.endCnt, getCompetitionBasicDataData.endCnt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(allCnt, validCnt, pv, notStartCnt, startCnt, endCnt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCompetitionBasicDataData {\n");
    
    sb.append("    allCnt: ").append(toIndentedString(allCnt)).append("\n");
    sb.append("    validCnt: ").append(toIndentedString(validCnt)).append("\n");
    sb.append("    pv: ").append(toIndentedString(pv)).append("\n");
    sb.append("    notStartCnt: ").append(toIndentedString(notStartCnt)).append("\n");
    sb.append("    startCnt: ").append(toIndentedString(startCnt)).append("\n");
    sb.append("    endCnt: ").append(toIndentedString(endCnt)).append("\n");
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
