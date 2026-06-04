package com.pag.order_service;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    public Order createOrder(
            @RequestBody OrderRequest request
    ){

        return service.createOrder(
                request
        );
    }

    @GetMapping
    public String getOrders(){
        return "Response from order Service";
    }
}
