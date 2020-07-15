package com.chinaedu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.entity
 * @ClassName: Payment
 * @Author: Justin
 * @Description:
 * @Date: 18:00 2020/7/3
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment implements Serializable {

    private Long pid;

    private String pusername;

    private String pserial;


}
