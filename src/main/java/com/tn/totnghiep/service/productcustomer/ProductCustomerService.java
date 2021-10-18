package com.tn.totnghiep.service.productcustomer;

import com.tn.totnghiep.service.productcustomer.dto.ProductCustomerDto;
import com.tn.totnghiep.service.productcustomer.param.ProductCustomerParam;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ProductCustomerService {
    ResponseEntity<Page<ProductCustomerDto>> searchNewArrival();

    ResponseEntity<Page<ProductCustomerDto>> searchBySHF();

    ResponseEntity<Page<ProductCustomerDto>> searchByModelKit();

    ResponseEntity<Page<ProductCustomerDto>> searchByStaticModel();

    ResponseEntity<Page<ProductCustomerDto>> searchByCategoryName(ProductCustomerParam param, Optional<String> field, String known);

    ResponseEntity<ProductCustomerDto> getOne(Integer id);
}
