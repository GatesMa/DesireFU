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
 * SelectNotificationData
 */
@Validated
public class SelectNotificationData  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("noticeId")
  private Integer noticeId = null;

  @JsonProperty("front_img")
  private String frontImg = null;

  @JsonProperty("type")
  private Integer type = null;

  @JsonProperty("content")
  private String content = null;

  @JsonProperty("status")
  private Integer status = null;

  public SelectNotificationData noticeId(Integer noticeId) {
    this.noticeId = noticeId;
    return this;
  }

  /**
   * 公告Id, 用于筛选
   * @return noticeId
  **/
  @ApiModelProperty(example = "100001", value = "公告Id, 用于筛选")

  public Integer getNoticeId() {
    return noticeId;
  }

  public void setNoticeId(Integer noticeId) {
    this.noticeId = noticeId;
  }

  public SelectNotificationData frontImg(String frontImg) {
    this.frontImg = frontImg;
    return this;
  }

  /**
   * 图片url
   * @return frontImg
  **/
  @ApiModelProperty(example = "http://xxx", value = "图片url")

  public String getFrontImg() {
    return frontImg;
  }

  public void setFrontImg(String frontImg) {
    this.frontImg = frontImg;
  }

  public SelectNotificationData type(Integer type) {
    this.type = type;
    return this;
  }

  /**
   * 公告类型
   * @return type
  **/
  @ApiModelProperty(example = "1", value = "公告类型")

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public SelectNotificationData content(String content) {
    this.content = content;
    return this;
  }

  /**
   * 内容
   * @return content
  **/
  @ApiModelProperty(example = "1", value = "内容")

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public SelectNotificationData status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * 状态
   * @return status
  **/
  @ApiModelProperty(example = "1", value = "状态")

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SelectNotificationData selectNotificationData = (SelectNotificationData) o;
    return Objects.equals(this.noticeId, selectNotificationData.noticeId) &&
        Objects.equals(this.frontImg, selectNotificationData.frontImg) &&
        Objects.equals(this.type, selectNotificationData.type) &&
        Objects.equals(this.content, selectNotificationData.content) &&
        Objects.equals(this.status, selectNotificationData.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(noticeId, frontImg, type, content, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SelectNotificationData {\n");
    
    sb.append("    noticeId: ").append(toIndentedString(noticeId)).append("\n");
    sb.append("    frontImg: ").append(toIndentedString(frontImg)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
