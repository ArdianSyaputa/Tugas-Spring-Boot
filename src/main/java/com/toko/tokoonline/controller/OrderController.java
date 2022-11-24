package com.toko.tokoonline.controller;

import com.toko.tokoonline.model.Order;
import com.toko.tokoonline.response.ResponseHelper;
import com.toko.tokoonline.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public Object getAllOrder(){
        return ResponseHelper.ok(orderService.getAllOrder()) ;
    }

    @GetMapping("/{id}")
    public Object  getOrder(@PathVariable("id") Long id) {
        return ResponseHelper.ok(orderService.getOrder(id)) ;
    }

    @PostMapping
    public Object addOrder(@RequestBody Order order) {
        return ResponseHelper.ok( orderService.addOrder(order)) ;
    }

    @PutMapping("/{id}")
    public Object editOrderById(@PathVariable("id") Long id, @RequestBody Order order) {
        return ResponseHelper.ok(  orderService.editOrder(id, order.getNamaBarang(), order.getTanggalDibuat(), order.getHarga(), order.getPemilik())) ;
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable("id") Long id) { orderService.deleteOrderById(id);}

}
