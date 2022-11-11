package cn.azh.fmmall.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value = "响应的VO对象",description = "封装接口返回给前端的数据")
public class ResultVo {

    @ApiModelProperty("状态码")
    private int code;//状态码
    @ApiModelProperty("提示信息")
    private String msg;//提示信息
    @ApiModelProperty("响应数据")
    private Object data;//对象

}
