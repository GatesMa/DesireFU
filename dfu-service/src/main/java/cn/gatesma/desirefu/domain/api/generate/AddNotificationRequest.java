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
 * AddNotificationRequest
 */
@Validated
public class AddNotificationRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("front_img")
  private String frontImg = null;

  @JsonProperty("type")
  private Integer type = null;

  @JsonProperty("content")
  private String content = null;

  public AddNotificationRequest frontImg(String frontImg) {
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

  public AddNotificationRequest type(Integer type) {
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

  public AddNotificationRequest content(String content) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddNotificationRequest addNotificationRequest = (AddNotificationRequest) o;
    return Objects.equals(this.frontImg, addNotificationRequest.frontImg) &&
        Objects.equals(this.type, addNotificationRequest.type) &&
        Objects.equals(this.content, addNotificationRequest.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(frontImg, type, content);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddNotificationRequest {\n");
    
    sb.append("    frontImg: ").append(toIndentedString(frontImg)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
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
