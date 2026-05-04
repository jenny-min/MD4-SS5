package com.example.session05.repositories;

import com.example.session05.models.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    //Lấy danh sách đơn hàng theo trạng thái
    List<Order> findByStatus(String status);
    //Lấy danh sách đơn hàng theo tên khách hàng
    List<Order> findByCustomerNameContaining(String name);
}
