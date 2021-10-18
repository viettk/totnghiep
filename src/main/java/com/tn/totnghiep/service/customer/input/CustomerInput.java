package com.tn.totnghiep.service.customer.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class CustomerInput {

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotBlank(message = "Password không được để trống")
    private String password;

    @NotBlank(message = "Họ tên không được để trống")
    private String name;

    @NotBlank(message = "Mời nhập lại mật khẩu")
    private String repeatPassword;

//    private String token;

//    private boolean status;

//    private Date register_day;
//
//    private Date last_login;
}
