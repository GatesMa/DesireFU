package cn.gatesma.desirefu.domain.api.generate;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

/**
 * PageInfo
 */
@Validated
public class PageInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("page_num")
    private Integer pageNum = null;

    @JsonProperty("page_size")
    private Integer pageSize = null;

    @JsonProperty("total_page")
    private Integer totalPage = null;

    @JsonProperty("total_count")
    private Integer totalCount = null;

    public PageInfo pageNum(Integer pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    /**
     * 当前页号
     *
     * @return pageNum
     **/
    @ApiModelProperty(value = "当前页号")

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public PageInfo pageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    /**
     * 当前页数据量
     *
     * @return pageSize
     **/
    @ApiModelProperty(value = "当前页数据量")

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public PageInfo totalPage(Integer totalPage) {
        this.totalPage = totalPage;
        return this;
    }

    /**
     * 总共页数
     *
     * @return totalPage
     **/
    @ApiModelProperty(value = "总共页数")

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public PageInfo totalCount(Integer totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    /**
     * 总共数据量
     *
     * @return totalCount
     **/
    @ApiModelProperty(value = "总共数据量")

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PageInfo pageInfo = (PageInfo) o;
        return Objects.equals(this.pageNum, pageInfo.pageNum) &&
                Objects.equals(this.pageSize, pageInfo.pageSize) &&
                Objects.equals(this.totalPage, pageInfo.totalPage) &&
                Objects.equals(this.totalCount, pageInfo.totalCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageNum, pageSize, totalPage, totalCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PageInfo {\n");

        sb.append("    pageNum: ").append(toIndentedString(pageNum)).append("\n");
        sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
        sb.append("    totalPage: ").append(toIndentedString(totalPage)).append("\n");
        sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
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
