package com.ph45308.assignment_ph45308.APIServices

import com.ph45308.assignment_ph45308.Model.Cart
import com.ph45308.assignment_ph45308.Model.Category
import com.ph45308.assignment_ph45308.Model.LoginResponse
import com.ph45308.assignment_ph45308.Model.Order
import com.ph45308.assignment_ph45308.Model.Product
import com.ph45308.assignment_ph45308.Model.User
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("products/getProduct")
    suspend fun getProducts(): List<Product>

    @POST("products/addProduct")
    suspend fun addProduct(@Body product: Product): Product

    @PUT("products/editProduct/{id}")
    suspend fun editProduct(@Path("id") id: String, @Body product: Product): Product

    @DELETE("products/deleteProduct/{id}")
    suspend fun deleteProduct(@Path("id") id: String): Unit

    @GET("products/getProductDetail/{productId}")
    suspend fun getProductDetail(@Path("productId") productId: String): Product

    // Search API
    @GET("products/search")
    suspend fun searchProducts(@Query("q") query: String): List<Product>

    //    Category
    //Get Cate
    @GET("products/getCategory")
    suspend fun getCategories(): List<Category>

    //Add Cate
    @POST("products/addCategory")
    suspend fun addCategory(@Body category: Category): Category

    @PUT("products/editCategory/{id}")
    suspend fun editCategory(@Path("id") id: String, @Body category: Category): Category

    @DELETE("products/deleteCategory/{id}")
    suspend fun deleteCategory(@Path("id") id: String): Unit

    //Cart API
    @POST("products/addToCart")
    suspend fun addToCart(
        @Header("Authorization") token: String,
        @Body cart: Cart
    ): Response<ResponseBody>

    @GET("products/getCart")
    suspend fun getCart(
        @Header("Authorization") token: String,
    ): List<Cart>

    @DELETE("products/clearCart")
    suspend fun clearCart(
        @Header("Authorization") token: String
    ): Response<Unit>

    //Checkout
    @POST("products/checkout")
    suspend fun checkout(
        @Header("Authorization") token: String,
        @Body order: Order,
    ): Response<ResponseBody>

    // Get order history
    @GET("products/getOrder")
    suspend fun getOrder(
        @Header("Authorization") token: String,
    ): List<Order>

    // User API===============================
    @POST("users/register")
    suspend fun registerUser(@Body user: User): User

    @POST("users/login")
    suspend fun login(@Body user: User): LoginResponse

    @GET("users/getUserInfo")
    suspend fun getUserInfo(
        @Header("Authorization") token: String,
    ): User

    @PUT("users/updateUser")
    suspend fun updateUser(
        @Header("Authorization") token: String,
        @Body user: User,
    ): User

    @PUT("users/updateAvatar")
    suspend fun updateAvatar(
        @Header("Authorization") token: String,
        @Part avatar: MultipartBody.Part,
    ): Response<ResponseBody>


}