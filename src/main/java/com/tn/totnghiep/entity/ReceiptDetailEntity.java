package com.tn.totnghiep.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Receipt_detail")
public class ReceiptDetailEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne @JoinColumn(name = "receipt_id")
    private ReceiptEntity receipt;

    /*Số lượng của 1 sản phẩm*/
    @Column(name="number")
    private Integer number;

    @Column(name="price")
    private BigDecimal price;

    /*Thành tiền của tất cả sản phẩm trong phiếu nhập*/
    @Column(name="total")
    private BigDecimal total;

}
