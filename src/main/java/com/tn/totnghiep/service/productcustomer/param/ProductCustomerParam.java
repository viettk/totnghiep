package com.tn.totnghiep.service.productcustomer.param;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class ProductCustomerParam {
    private Integer categoryId;

    private String name;

    private BigDecimal price;

    private Date create_date;
}
