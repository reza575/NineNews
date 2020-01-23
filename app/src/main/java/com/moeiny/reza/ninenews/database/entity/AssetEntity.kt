package com.moeiny.reza.ninenews.database.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.moeiny.reza.ninenews.model.entity.*

@Entity (tableName = "Assets")
class AssetEntity (@PrimaryKey  var asset_Id:Int,
                   @ColumnInfo var acceptComments: Boolean,
                   @ColumnInfo var assetType: String,
                   @ColumnInfo var byLine: String,
                   @ColumnInfo var headline: String,
                   @ColumnInfo var indexHeadline: String,
                   @ColumnInfo var lastModified: Long,
                   @ColumnInfo var legalStatus: String,
                   @ColumnInfo var numberOfComments: Int,
                   @ColumnInfo var onTime: Long,
                   @ColumnInfo var signPost: String?,
                   @ColumnInfo var sponsored: Boolean,
                   @ColumnInfo var tabletHeadline: String?,
                   @ColumnInfo var theAbstract: String,
                   @ColumnInfo var timeStamp: Long,
                   @ColumnInfo var url: String)

