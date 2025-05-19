package org.example.product

import jakarta.transaction.Transactional
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class ProductService(private val productRepository: ProductRepository) {

    fun getAllProducts(): List<Product> {
        return productRepository.findAll()
    }

    fun createProduct(product: Product): Product {
        return productRepository.save(product)
    }

    fun updateProduct(product: Product): Product {
        if (!productRepository.existsById(product.id)) {
            throw IllegalArgumentException("해당 상품이 존재하지 않습니다.")
        }
        return productRepository.save(product)
    }

    fun deleteProduct(id: Long) {
        productRepository.deleteById(id)
    }
}
