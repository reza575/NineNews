package com.moeiny.reza.ninenews.database.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "RelatedImages")
class RelatedImageEntity (@PrimaryKey (autoGenerate = true) var Id:Int,
                          @ColumnInfo var asset_Id: Int,
                          @ColumnInfo var image_Id: Int,
                          @ColumnInfo var assetType: String,
                          @ColumnInfo var description: String,
                          @ColumnInfo var height: Int,
                          @ColumnInfo var large: String?,
                          @ColumnInfo var large2x: String?,
                          @ColumnInfo var lastModified: Long,
                          @ColumnInfo var photographer: String,
                          @ColumnInfo var sponsored: Boolean?,
                          @ColumnInfo var thumbnail: String?,
                          @ColumnInfo var thumbnail2x: String?,
                          @ColumnInfo var timeStamp: Long,
                          @ColumnInfo var type: String,
                          @ColumnInfo var url: String?,
                          @ColumnInfo var width: Int,
                          @ColumnInfo var xLarge: String?,
                          @ColumnInfo var xLarge2x: String?){
    constructor(asset_Id:Int,image_Id: Int,assetType: String,description: String,height: Int,large: String?,
                large2x:String?,lastModified:Long,photographer:String,sponsored: Boolean?,thumbnail: String?,
                thumbnail2x: String?,timeStamp: Long,type: String,url: String?,width: Int,xLarge: String?,xLarge2x: String?)
               :this(0,asset_Id,image_Id,assetType,description,height,large,large2x,lastModified,photographer,sponsored,
                      thumbnail,thumbnail2x,timeStamp,type,url,width,xLarge,xLarge2x)
}

