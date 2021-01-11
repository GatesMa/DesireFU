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
 * SelectCompetitionRetData
 */
@Validated
public class SelectCompetitionRetData  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("list")
  @Valid
  private java.util.List<SelectCompetitionData> list = null;

  public SelectCompetitionRetData list(java.util.List<SelectCompetitionData> list) {
    this.list = list;
    return this;
  }

  public SelectCompetitionRetData addListItem(SelectCompetitionData listItem) {
    if (this.list == null) {
      this.list = new java.util.ArrayList<SelectCompetitionData>();
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
  public java.util.List<SelectCompetitionData> getList() {
    return list;
  }

  public void setList(java.util.List<SelectCompetitionData> list) {
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
    SelectCompetitionRetData selectCompetitionRetData = (SelectCompetitionRetData) o;
    return Objects.equals(this.list, selectCompetitionRetData.list);
  }

  @Override
  public int hashCode() {
    return Objects.hash(list);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SelectCompetitionRetData {\n");
    
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
