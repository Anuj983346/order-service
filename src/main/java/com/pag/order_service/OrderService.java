package com.pag.order_service;




import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    private final OrderProducer producer;

    public Order createOrder(
            OrderRequest request
    ){

        Order order =
                Order.builder()
                        .customerId(
                                request.getCustomerId()
                        )
                        .productId(
                                request.getProductId()
                        )
                        .quantity(
                                request.getQuantity()
                        )
                        .amount(
                                request.getAmount()
                        )
                        .status("CREATED")
                        .build();

        Order saved =
                repository.save(order);

        producer.publish(
                OrderEvent.builder()
                        .orderId(saved.getId())
                        .amount(saved.getAmount())
                        .status(saved.getStatus())
                        .build()
        );

        return saved;
    }
}
