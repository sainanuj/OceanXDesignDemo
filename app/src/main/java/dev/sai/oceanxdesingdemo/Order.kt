package dev.sai.oceanxdesingdemo

data class Order(
    val id: String,
    val vehicleType: String,
    val date: String,
    val pickup: String,
    val drop: String,
    val price: Double,
    val status: String
)