package org.example.product

import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
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

    @PostMapping
    fun createProduct(@RequestBody product: Product) {
        productService.createProduct(product)
    }

    @PutMapping
    fun updateProduct(@RequestBody product: Product) {
        productService.updateProduct(product)
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Long) {
        productService.deleteProduct(id)
    }
}
