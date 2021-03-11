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
 * GetNormalBasicDataData
 */
@Validated
public class GetNormalBasicDataData  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("msgCnt")
  private Integer msgCnt = null;

  @JsonProperty("applicationCnt")
  private Integer applicationCnt = null;

  @JsonProperty("organizeCnt")
  private Integer organizeCnt = null;

  @JsonProperty("collectCnt")
  private Integer collectCnt = null;

  public GetNormalBasicDataData msgCnt(Integer msgCnt) {
    this.msgCnt = msgCnt;
    return this;
  }

  /**
   * 消息个数
   * @return msgCnt
  **/
  @ApiModelProperty(example = "10", value = "消息个数")

  public Integer getMsgCnt() {
    return msgCnt;
  }

  public void setMsgCnt(Integer msgCnt) {
    this.msgCnt = msgCnt;
  }

  public GetNormalBasicDataData applicationCnt(Integer applicationCnt) {
    this.applicationCnt = applicationCnt;
    return this;
  }

  /**
   * 入队申请个数
   * @return applicationCnt
  **/
  @ApiModelProperty(example = "10", value = "入队申请个数")

  public Integer getApplicationCnt() {
    return applicationCnt;
  }

  public void setApplicationCnt(Integer applicationCnt) {
    this.applicationCnt = applicationCnt;
  }

  public GetNormalBasicDataData organizeCnt(Integer organizeCnt) {
    this.organizeCnt = organizeCnt;
    return this;
  }

  /**
   * 队伍
   * @return organizeCnt
  **/
  @ApiModelProperty(example = "10", value = "队伍")

  public Integer getOrganizeCnt() {
    return organizeCnt;
  }

  public void setOrganizeCnt(Integer organizeCnt) {
    this.organizeCnt = organizeCnt;
  }

  public GetNormalBasicDataData collectCnt(Integer collectCnt) {
    this.collectCnt = collectCnt;
    return this;
  }

  /**
   * 队伍
   * @return collectCnt
  **/
  @ApiModelProperty(example = "10", value = "队伍")

  public Integer getCollectCnt() {
    return collectCnt;
  }

  public void setCollectCnt(Integer collectCnt) {
    this.collectCnt = collectCnt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetNormalBasicDataData getNormalBasicDataData = (GetNormalBasicDataData) o;
    return Objects.equals(this.msgCnt, getNormalBasicDataData.msgCnt) &&
        Objects.equals(this.applicationCnt, getNormalBasicDataData.applicationCnt) &&
        Objects.equals(this.organizeCnt, getNormalBasicDataData.organizeCnt) &&
        Objects.equals(this.collectCnt, getNormalBasicDataData.collectCnt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(msgCnt, applicationCnt, organizeCnt, collectCnt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetNormalBasicDataData {\n");
    
    sb.append("    msgCnt: ").append(toIndentedString(msgCnt)).append("\n");
    sb.append("    applicationCnt: ").append(toIndentedString(applicationCnt)).append("\n");
    sb.append("    organizeCnt: ").append(toIndentedString(organizeCnt)).append("\n");
    sb.append("    collectCnt: ").append(toIndentedString(collectCnt)).append("\n");
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
