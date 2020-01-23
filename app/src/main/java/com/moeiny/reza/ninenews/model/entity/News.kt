package com.moeiny.reza.ninenews.model.entity

data class News(
    val assetType: String,
    val assets: List<Asset>,
    val authors: List<Author>,
    val categories: List<Category>,
    val displayName: String,
    val id: Int,
    val lastModified: Long,
    val onTime: Long,
    val relatedAssets: List<Asset>,
    val relatedImages: List<RelatedImage>,
    val sponsored: Boolean,
    val timeStamp: Long,
    val url: String
)