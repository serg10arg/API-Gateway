package com.mycompany.productservice.interfaces;

import com.mycompany.productservice.model.Inventory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="gateway-service")
public interface InventoryClient {
    @GetMapping("/inventory/{productid}")
    public Inventory getInventoryDetails(@PathVariable("productid") Long productid);
}
