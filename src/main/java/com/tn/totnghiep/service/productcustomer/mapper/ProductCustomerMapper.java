package com.tn.totnghiep.service.productcustomer.mapper;

import com.tn.totnghiep.config.mapper.ParentMapper;
import com.tn.totnghiep.entity.ProductEntity;
import com.tn.totnghiep.service.productcustomer.dto.ProductCustomerDto;
import com.tn.totnghiep.service.productcustomer.param.ProductCustomerParam;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProductCustomerMapper extends ParentMapper<ProductEntity, ProductCustomerDto, ProductCustomerParam> {
}
