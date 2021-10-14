package com.sample.lwj.remote.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 公共参数
 * @date 2021/10/12 18:02
 */
@Data
@ApiModel("公共参数")
public class CommonParamDTO implements Serializable {
    @ApiModelProperty("搜索开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date searchStartTime;

    @ApiModelProperty("搜索结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date searchEndTime;
}
