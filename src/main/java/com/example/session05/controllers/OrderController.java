package com.example.session05.controllers;

import com.example.session05.models.entity.Order;
import com.example.session05.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    //Lấy tất cả danh sách
    @GetMapping()
    public ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/searchStatus")
    public ResponseEntity<List<Order>> getByStatus(@RequestParam("status") String status) {
        return new ResponseEntity<>(orderService.getOrdersByStatus(status), HttpStatus.OK);
    }

    @GetMapping("/searchByCustomer")
    public ResponseEntity<List<Order>> getByCustomerName(@RequestParam("customerName") String customerName) {
        return new ResponseEntity<>(orderService.getOrdersByCustomerName(customerName), HttpStatus.OK);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<Order>> getAllOrdersSorted(@RequestParam("sortBy") String sortBy,  @RequestParam("dir") String dir) {
        return new ResponseEntity<>(orderService.getAllOrdersSorted(sortBy, dir), HttpStatus.OK);
    }

    @GetMapping("/paging")
    public ResponseEntity<Page<Order>> findByPage(@RequestParam("page") int page , @RequestParam("size") int size){
        return new ResponseEntity<>(orderService.getOrdersPaged(page,size),HttpStatus.OK);
    }

    @GetMapping("/findOrderHighPrice")
    public ResponseEntity<List<Order>> findByOrderHighPrice() {
        return new ResponseEntity<>(orderService.findOrderHighPrice(), HttpStatus.OK);
    }
}
