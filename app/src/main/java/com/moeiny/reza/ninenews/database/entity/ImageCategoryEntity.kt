package com.moeiny.reza.ninenews.database.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.moeiny.reza.ninenews.model.entity.Asset
import com.moeiny.reza.ninenews.model.entity.RelatedImage

@Entity (tableName = "ImageCategories")
class ImageCategoryEntity (@PrimaryKey (autoGenerate = true) var Id:Int,
                           @ColumnInfo var image_Id: Int,
                           @ColumnInfo var category_Id: Int)

