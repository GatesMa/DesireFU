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
 * DeleteMessageRequest
 */
@Validated
public class DeleteMessageRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("ids")
  @Valid
  private java.util.List<Long> ids = null;

  public DeleteMessageRequest ids(java.util.List<Long> ids) {
    this.ids = ids;
    return this;
  }

  public DeleteMessageRequest addIdsItem(Long idsItem) {
    if (this.ids == null) {
      this.ids = new java.util.ArrayList<Long>();
    }
    this.ids.add(idsItem);
    return this;
  }

  /**
   * Get ids
   * @return ids
  **/
  @ApiModelProperty(example = "[177953]", value = "")

  public java.util.List<Long> getIds() {
    return ids;
  }

  public void setIds(java.util.List<Long> ids) {
    this.ids = ids;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteMessageRequest deleteMessageRequest = (DeleteMessageRequest) o;
    return Objects.equals(this.ids, deleteMessageRequest.ids);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ids);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteMessageRequest {\n");
    
    sb.append("    ids: ").append(toIndentedString(ids)).append("\n");
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
