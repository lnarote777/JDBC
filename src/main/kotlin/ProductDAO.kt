package org.example

import java.sql.SQLException
import javax.sql.DataSource

class ProductDAO(private val dataSource: DataSource): IProductDAO {

    override fun createProduct(product: Product): Product?{
        val sql = "INSERT INTO products (id, name, price, description, brand, category) VALUES (?, ?, ?, ?, ?, ?)"
        return try {
            dataSource.connection.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setInt(1, product.id)
                    stmt.setString(2, product.name)
                    stmt.setFloat(3, product.price)
                    stmt.setString(4, product.description)
                    stmt.setString(5, product.brand)
                    stmt.setString(6, product.category)
                    val rs = stmt.executeUpdate()
                    if (rs == 1){
                        product
                    }else{
                        println("Error - Insert query failed! ($rs records inserted)")
                        null
                    }
                }
            }
        }catch (e: SQLException){
            println("Error - Insert query failed! (${e.message})")
            null
        }
    }
}