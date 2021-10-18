package com.tn.totnghiep.service.customer.mapper;

import com.tn.totnghiep.config.mapper.ParentMapper;
import com.tn.totnghiep.entity.CustomerEntity;
import com.tn.totnghiep.service.customer.dto.CustomerDto;
import com.tn.totnghiep.service.customer.input.CustomerInput;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CustomerMapper extends ParentMapper<CustomerEntity, CustomerDto, CustomerInput> {
}
