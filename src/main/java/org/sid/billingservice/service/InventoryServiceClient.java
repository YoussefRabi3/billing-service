package org.sid.billingservice.service;

import org.sid.billingservice.entities.Customer;
import org.sid.billingservice.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FeignClient(name = "inventory-service")
public interface InventoryServiceClient {
    @GetMapping("/products/{id}?projection=fullProduct")
    Product findProductById(@PathVariable("id")Long id);

    @GetMapping("/products?projection=fullProduct")
    PagedModel<Product> findAll();

}
