package com.moeiny.reza.ninenews.database.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.moeiny.reza.ninenews.model.entity.Asset
import com.moeiny.reza.ninenews.model.entity.RelatedImage

@Entity (tableName = "AssetRelatedImages")
class AssetRelatedImageEntity (@PrimaryKey (autoGenerate = true) var Id:Int,
                               @ColumnInfo var asset_Id: Int,
                               @ColumnInfo var image_Id: Int){
    constructor(asset_Id:Int,image_Id: Int): this(0,asset_Id,image_Id)
}

