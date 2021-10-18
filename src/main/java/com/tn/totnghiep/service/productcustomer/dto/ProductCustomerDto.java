package com.tn.totnghiep.service.productcustomer.dto;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class ProductCustomerDto {
//    private CategoryDto category;

    private String name;

    private boolean status;

    private BigDecimal price;

    private Float rating;

    private Date create_date;

    private Integer number;

    private String describe;

    private String photo;
}
