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
 * SelectNotificationRequest
 */
@Validated
public class SelectNotificationRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("noticeId")
  private Integer noticeId = null;

  @JsonProperty("type")
  private Integer type = null;

  @JsonProperty("status")
  private Integer status = null;

  public SelectNotificationRequest noticeId(Integer noticeId) {
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

  public SelectNotificationRequest type(Integer type) {
    this.type = type;
    return this;
  }

  /**
   * 类型
   * @return type
  **/
  @ApiModelProperty(example = "1", value = "类型")

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public SelectNotificationRequest status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * 是否草稿
   * @return status
  **/
  @ApiModelProperty(example = "1", value = "是否草稿")

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
    SelectNotificationRequest selectNotificationRequest = (SelectNotificationRequest) o;
    return Objects.equals(this.noticeId, selectNotificationRequest.noticeId) &&
        Objects.equals(this.type, selectNotificationRequest.type) &&
        Objects.equals(this.status, selectNotificationRequest.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(noticeId, type, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SelectNotificationRequest {\n");
    
    sb.append("    noticeId: ").append(toIndentedString(noticeId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
