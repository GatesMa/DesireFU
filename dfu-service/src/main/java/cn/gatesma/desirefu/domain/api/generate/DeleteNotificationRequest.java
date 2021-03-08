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
 * DeleteNotificationRequest
 */
@Validated
public class DeleteNotificationRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("noticeId")
  private Integer noticeId = null;

  public DeleteNotificationRequest noticeId(Integer noticeId) {
    this.noticeId = noticeId;
    return this;
  }

  /**
   * noticeId
   * @return noticeId
  **/
  @ApiModelProperty(value = "noticeId")

  public Integer getNoticeId() {
    return noticeId;
  }

  public void setNoticeId(Integer noticeId) {
    this.noticeId = noticeId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteNotificationRequest deleteNotificationRequest = (DeleteNotificationRequest) o;
    return Objects.equals(this.noticeId, deleteNotificationRequest.noticeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(noticeId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteNotificationRequest {\n");
    
    sb.append("    noticeId: ").append(toIndentedString(noticeId)).append("\n");
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
