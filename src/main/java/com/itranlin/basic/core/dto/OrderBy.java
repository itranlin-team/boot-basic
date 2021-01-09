package com.itranlin.basic.core.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author itranlin
 */
@Data
public class OrderBy {

    @ApiModelProperty("列名")
    private String columnsName;
    @ApiModelProperty("是否升序")
    private boolean asc = false;
}
