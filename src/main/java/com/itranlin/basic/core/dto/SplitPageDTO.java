package com.itranlin.basic.core.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.base.CaseFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author itranlin
 */
@Data
public class SplitPageDTO<T> {

    @ApiModelProperty(value = "当前页")
    private Integer page;

    @ApiModelProperty(value = "每页数据")
    private Integer pageSize;

    @ApiModelProperty(value = "当前页")
    private List<OrderBy> orderBy;

    public Integer getPage() {
        if (null == page) {
            return 1;
        }
        return page;
    }

    public Integer getPageSize() {
        if (null == pageSize) {
            return 10;
        }
        return pageSize;
    }

    public void initOrderBy(QueryWrapper<T> wrapper) {
        if (null != this.orderBy) {
            this.orderBy.forEach(o -> wrapper.orderBy(true, o.isAsc(),
                    CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, o.getColumnsName())));
        } else {
            wrapper.orderBy(true, false, "id");
        }
    }

}
