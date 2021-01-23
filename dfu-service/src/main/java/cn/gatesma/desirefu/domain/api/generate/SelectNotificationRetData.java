package cn.gatesma.desirefu.domain.api.generate;

import java.util.Objects;
import cn.gatesma.desirefu.domain.api.generate.SelectNotificationData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SelectNotificationRetData
 */
@Validated
public class SelectNotificationRetData  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("list")
  @Valid
  private java.util.List<SelectNotificationData> list = null;

  public SelectNotificationRetData list(java.util.List<SelectNotificationData> list) {
    this.list = list;
    return this;
  }

  public SelectNotificationRetData addListItem(SelectNotificationData listItem) {
    if (this.list == null) {
      this.list = new java.util.ArrayList<SelectNotificationData>();
    }
    this.list.add(listItem);
    return this;
  }

  /**
   * Get list
   * @return list
  **/
  @ApiModelProperty(value = "")
  @Valid
  public java.util.List<SelectNotificationData> getList() {
    return list;
  }

  public void setList(java.util.List<SelectNotificationData> list) {
    this.list = list;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SelectNotificationRetData selectNotificationRetData = (SelectNotificationRetData) o;
    return Objects.equals(this.list, selectNotificationRetData.list);
  }

  @Override
  public int hashCode() {
    return Objects.hash(list);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SelectNotificationRetData {\n");
    
    sb.append("    list: ").append(toIndentedString(list)).append("\n");
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
