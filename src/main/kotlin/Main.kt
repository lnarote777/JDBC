package org.example

import org.example.dataSource.DataSourceFactory


fun main() {

    val dataSource = DataSourceFactory.getDS(DataSourceFactory.DataSourceType.HIKARI)

    val product = Product(1, "Smartphone", 999.99f, "The latest smartphone model", "Apple", "Electronics")

    val productId = ProductDAO(dataSource).createProduct(product)

    println("Product ID: $productId")

}