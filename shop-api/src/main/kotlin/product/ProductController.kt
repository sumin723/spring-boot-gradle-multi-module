package org.example.product

import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
class ProductController(private val productService: ProductService) {
    @GetMapping
    fun getAllProducts(): List<Product> {
        return productService.getAllProducts()
    }
}
