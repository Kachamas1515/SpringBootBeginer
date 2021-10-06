package com.example.demo.api;

import com.example.demo.business.ProductBusiness;
import com.example.demo.exception.BaseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductApi {

    private final ProductBusiness product;

    public ProductApi(ProductBusiness product) {
        this.product = product;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getProductById(@PathVariable("id") String id) throws BaseException {
        String respnse = product.getProductById(id);
        return ResponseEntity.ok(respnse);
    }
}
