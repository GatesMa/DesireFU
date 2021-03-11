package cn.gatesma.desirefu.domain.api.generate;

import java.util.Objects;
import cn.gatesma.desirefu.domain.api.generate.GetNormalAccountData;
import cn.gatesma.desirefu.domain.api.generate.ReturnCode;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GetExamAccountRet
 */
@Validated
public class GetExamAccountRet extends ReturnCode implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("data")
  @Valid
  private java.util.List<GetNormalAccountData> data = null;

  public GetExamAccountRet data(java.util.List<GetNormalAccountData> data) {
    this.data = data;
    return this;
  }

  public GetExamAccountRet addDataItem(GetNormalAccountData dataItem) {
    if (this.data == null) {
      this.data = new java.util.ArrayList<GetNormalAccountData>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(value = "")
  @Valid
  public java.util.List<GetNormalAccountData> getData() {
    return data;
  }

  public void setData(java.util.List<GetNormalAccountData> data) {
    this.data = data;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetExamAccountRet getExamAccountRet = (GetExamAccountRet) o;
    return Objects.equals(this.data, getExamAccountRet.data) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetExamAccountRet {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
