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
 * AddCompetitionCreatorAccountRequest
 */
@Validated
public class AddCompetitionCreatorAccountRequest extends AddAccountRequest implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("author")
  private String author = null;

  public AddCompetitionCreatorAccountRequest author(String author) {
    this.author = author;
    return this;
  }

  /**
   * 可以创建的比赛范围
   * @return author
  **/
  @ApiModelProperty(example = "1,2,3,4", value = "可以创建的比赛范围")

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddCompetitionCreatorAccountRequest addCompetitionCreatorAccountRequest = (AddCompetitionCreatorAccountRequest) o;
    return Objects.equals(this.author, addCompetitionCreatorAccountRequest.author) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(author, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddCompetitionCreatorAccountRequest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
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
