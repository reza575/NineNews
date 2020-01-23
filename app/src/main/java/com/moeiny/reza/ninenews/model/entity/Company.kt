package com.moeiny.reza.ninenews.model.entity

data class Company(
    val id: Int,
    val companyCode: String,
    val companyName: String,
    val abbreviatedName: String,
    val exchange: String,
    val companyNumber: Int
)

