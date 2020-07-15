package com.chinaedu.springcloud.results;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.results
 * @ClassName: CommonResult
 * @Author: Justin
 * @Description:
 * @Date: 18:05 2020/7/3
 * @Version: 1.0
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
   //404 ,200,
   private Integer code;

   private String message;

   private T data;

    public CommonResult() {
    }

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
