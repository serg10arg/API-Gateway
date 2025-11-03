package com.mycompany.productservice.interfaces;

import com.mycompany.productservice.model.Price;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="gateway-service")
public interface PriceClient {
    @GetMapping("/price/{productid}")
    public Price getPriceDetails(@PathVariable("productid") Long productid);
}
