package cn.gatesma.desirefu.domain.api.generate;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;

/**
 * Page
 */
@Validated
public class Page implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("page_num")
    private Integer pageNum = 1;

    @JsonProperty("page_size")
    private Integer pageSize = 10;

    public Page pageNum(Integer pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    /**
     * 页号
     * minimum: 1
     *
     * @return pageNum
     **/
    @ApiModelProperty(value = "页号")

    @Min(1)
    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Page pageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    /**
     * 每页数据量
     * minimum: 1
     *
     * @return pageSize
     **/
    @ApiModelProperty(value = "每页数据量")

    @Min(1)
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Page page = (Page) o;
        return Objects.equals(this.pageNum, page.pageNum) &&
                Objects.equals(this.pageSize, page.pageSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageNum, pageSize);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Page {\n");

        sb.append("    pageNum: ").append(toIndentedString(pageNum)).append("\n");
        sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
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
