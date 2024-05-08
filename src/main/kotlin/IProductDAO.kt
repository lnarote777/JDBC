package org.example

interface IProductDAO {
    fun createProduct(product: Product): Product?
}