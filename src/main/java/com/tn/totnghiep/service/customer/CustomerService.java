package com.tn.totnghiep.service.customer;

import com.tn.totnghiep.service.customer.dto.CustomerDto;
import com.tn.totnghiep.service.customer.input.CustomerInput;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    /* Khách hàng đăng kí */
    public ResponseEntity<CustomerDto> create(CustomerInput input);

    /* Khách hàng đổi mật khẩu */
    public ResponseEntity<CustomerDto> update(CustomerInput input);

    /* Lấy Email của khách hàng -> đổi lại mật khẩu */
    public ResponseEntity<CustomerDto> getEmail(String email);
}
