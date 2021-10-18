package com.tn.totnghiep.controller.productcustomer;

import com.tn.totnghiep.service.productcustomer.ProductCustomerService;
import com.tn.totnghiep.service.productcustomer.dto.ProductCustomerDto;
import com.tn.totnghiep.service.productcustomer.param.ProductCustomerParam;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class ProductCustomerRest {
    private final ProductCustomerService service;

    @GetMapping("/new-arrival")
    public ResponseEntity<Page<ProductCustomerDto>> searchNewArrival(){
        return service.searchNewArrival();
    }

    @GetMapping("/model-kit")
    public ResponseEntity<Page<ProductCustomerDto>> searchbyModelKit(){
        return service.searchByModelKit();
    }

    @GetMapping("/static-model")
    public ResponseEntity<Page<ProductCustomerDto>> searchByStaticModel(){
        return service.searchByStaticModel();
    }

    @GetMapping("/shf")
    public ResponseEntity<Page<ProductCustomerDto>> searchBySHF(){
        return service.searchBySHF();
    }

    @GetMapping("/category")
    public ResponseEntity<Page<ProductCustomerDto>> searchByCategoryName(ProductCustomerParam param, Optional<String> field, String known){
        return service.searchByCategoryName(param, field, known);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCustomerDto> getOne(@PathVariable Integer id){
        return service.getOne(id);
    }

}
