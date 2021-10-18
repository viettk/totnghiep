package com.tn.totnghiep.repository.product;

import com.tn.totnghiep.entity.ProductEntity;
import com.tn.totnghiep.service.productcustomer.param.ProductCustomerParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    @Query("from ProductEntity p where p.status = false order by p.id desc")
    Page<ProductEntity> searchNewArrival(Pageable pageable);


    /* select theo danh mục cha: SHF */
    @Query("from ProductEntity p where p.status = false and p.category.parent_name like 'SHF'")
    Page<ProductEntity> searchBySHF(Pageable pageable );

    /* select theo danh mục cha: Mô hình tĩnh */
    @Query("from ProductEntity p where p.status = false and p.category.parent_name like 'Static Model' ")
    Page<ProductEntity> searchByStaticModel(Pageable pageable );

    @Query("from ProductEntity p where p.status = false and p.category.parent_name like 'Model Kit'")
    Page<ProductEntity> searchByModelKit(Pageable pageable );

    /* xem, lọc sản phẩm theo từng danh mục con */
    @Query("from ProductEntity p where p.status = false " +
            "and (:#{#product.name} is null or p.name like :#{#product.name})" +
            "and (:#{#product.categoryId} is null or p.category.id = :#{#product.categoryId})" +
            "and (:#{#product.create_date} is null or p.createDate = :#{#product.create_date})" +
            "and (:#{#product.price} is null or p.price = :#{#product.price})")
    Page<ProductEntity> searchByCategoryName(@Param("product") ProductCustomerParam product, Pageable pageable );

    Optional<ProductEntity> findByIdAndStatusIsFalse(Integer id);
}
