package cn.gatesma.desirefu.domain.api.generate;

import java.util.Objects;
import cn.gatesma.desirefu.domain.api.generate.AddAccountRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AddRootAccountRequest
 */
@Validated
public class AddRootAccountRequest extends AddAccountRequest implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("ext")
  private String ext = null;

  public AddRootAccountRequest ext(String ext) {
    this.ext = ext;
    return this;
  }

  /**
   * 可选字段
   * @return ext
  **/
  @ApiModelProperty(value = "可选字段")

  public String getExt() {
    return ext;
  }

  public void setExt(String ext) {
    this.ext = ext;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddRootAccountRequest addRootAccountRequest = (AddRootAccountRequest) o;
    return Objects.equals(this.ext, addRootAccountRequest.ext) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ext, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddRootAccountRequest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    ext: ").append(toIndentedString(ext)).append("\n");
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
