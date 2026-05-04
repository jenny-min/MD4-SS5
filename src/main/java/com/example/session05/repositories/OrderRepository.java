package com.example.session05.repositories;

import com.example.session05.models.dto.OrderSummary;
import com.example.session05.models.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    //Lấy danh sách đơn hàng theo trạng thái
    List<Order> findByStatus(String status);
    //Lấy danh sách đơn hàng theo tên khách hàng
    List<Order> findByCustomerNameContaining(String name);

    //câu lệnh JPQL truy vấn lấy về danh sách đơn hàng có tổng tiền lớn hơn tổng tiền trung bình của tháng hiện tại
    @Query("from Order o where o.totalPrice > (select avg(o2.totalPrice) from Order o2 where month(o2.createdAt) = month(now()))")
    List<Order> findOrderHighPrice();

    @Query("select new com.example.session05.models.dto.OrderSummary(o.orderCode, o.customerName, o.totalPrice) from Order o")
    Page<OrderSummary> findAllAndPagination(Pageable pageable);
}
