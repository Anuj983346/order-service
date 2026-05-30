package com.pag.order_service;
import lombok.Data;

@Data
public class OrderRequest {

    private Long customerId;

    private Long productId;

    private Integer quantity;

    private Double amount;
}
