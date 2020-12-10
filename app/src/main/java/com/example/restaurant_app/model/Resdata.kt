package com.example.restaurant_app.model

data class Resdata (
    val current_page: Int,
    val per_page: Int,
    val restaurants: List<Post>,
    val total_entries: Int
)