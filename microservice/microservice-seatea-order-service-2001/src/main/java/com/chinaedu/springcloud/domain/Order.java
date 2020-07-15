package com.chinaedu.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @ProjectName: springcloud_v2.0
 * @Package: com.chinaedu.springcloud.domain
 * @ClassName: Order
 * @Author: Justin
 * @Description:
 * @Date: 11:32 2020/7/9
 * @Version: 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Order {

    private Long id;

    private Long userId;

    private Long productId;

    private Integer counts;

    private BigDecimal money;

    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
