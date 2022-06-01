package com.microsservice.shoppingapi.model.dto;

import java.math.BigDecimal;

public class ShopReportDTO {

    private Integer count;

    private BigDecimal total;

    private BigDecimal mean;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getMean() {
        return mean;
    }

    public void setMean(BigDecimal mean) {
        this.mean = mean;
    }
}
