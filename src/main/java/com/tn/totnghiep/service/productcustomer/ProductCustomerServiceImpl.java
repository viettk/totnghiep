package com.tn.totnghiep.service.productcustomer;

import com.tn.totnghiep.entity.ProductEntity;
import com.tn.totnghiep.repository.product.ProductRepository;
import com.tn.totnghiep.service.productcustomer.dto.ProductCustomerDto;
import com.tn.totnghiep.service.productcustomer.mapper.ProductCustomerMapper;
import com.tn.totnghiep.service.productcustomer.param.ProductCustomerParam;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductCustomerServiceImpl implements ProductCustomerService{

    private final ProductRepository productRepository;

    private final ProductCustomerMapper mapper;

    @Override
    @Transactional
    public ResponseEntity<Page<ProductCustomerDto>> searchNewArrival() {
        Pageable pageable = PageRequest.of(0,10);
        Page<ProductCustomerDto> dto = this.productRepository.searchNewArrival(pageable).map(mapper::entityToDto);
        return ResponseEntity.ok().body(dto);
    }

    @Override
    @Transactional
    public ResponseEntity<Page<ProductCustomerDto>> searchBySHF() {
        Pageable pageable = PageRequest.of(0,4);
        Page<ProductCustomerDto> dto = this.productRepository.searchBySHF(pageable).map(mapper::entityToDto);
        return ResponseEntity.ok().body(dto);
    }

    @Override
    @Transactional
    public ResponseEntity<Page<ProductCustomerDto>> searchByModelKit() {
        Pageable pageable = PageRequest.of(0,4);
        Page<ProductCustomerDto> dto = this.productRepository.searchByModelKit(pageable).map(mapper::entityToDto);
        return ResponseEntity.ok().body(dto);
    }

    @Override
    @Transactional
    public ResponseEntity<Page<ProductCustomerDto>> searchByStaticModel() {
        Pageable pageable = PageRequest.of(0,4);
        Page<ProductCustomerDto> dto = this.productRepository.searchByStaticModel(pageable).map(mapper::entityToDto);
        return ResponseEntity.ok().body(dto);
    }


    /* Search theo danh mục */
    @Override
    @Transactional
    public ResponseEntity<Page<ProductCustomerDto>> searchByCategoryName(ProductCustomerParam param, Optional<String> field, String known) {
        /*sắp xếp tăng dần + sắp xếp theo giá, tên sản phầm*/
        if(known.equals("up")){
            Sort sort =Sort.by(Sort.Direction.ASC, field.orElse("id"));
            Pageable pageable = PageRequest.of(0, 15, sort);
            Page<ProductCustomerDto> dto = this.productRepository.searchByCategoryName(param, pageable).map(mapper::entityToDto);
            return ResponseEntity.ok().body(dto);
        }
        /*sắp xếp giảm dần + sắp xếp theo giá, tên sản phầm*/
        else{
            Sort sort =Sort.by(Sort.Direction.DESC, field.orElse("id"));
            Pageable pageable = PageRequest.of(0, 15, sort);
            Page<ProductCustomerDto> dto = this.productRepository.searchByCategoryName(param, pageable).map(mapper::entityToDto);
            return ResponseEntity.ok().body(dto);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<ProductCustomerDto> getOne(Integer id) {
        /* Kiểm tra id của sản phẩm có tồn tại hay ko */
        ProductEntity entity = this.productRepository.findByIdAndStatusIsFalse(id)
                .orElseThrow(() -> new RuntimeException("Sản phẩm không tồn tại"));
        return ResponseEntity.ok().body(mapper.entityToDto(entity));
    }
}
