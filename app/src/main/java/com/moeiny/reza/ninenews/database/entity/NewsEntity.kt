package com.moeiny.reza.ninenews.database.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.moeiny.reza.ninenews.model.entity.Asset

@Entity (tableName = "News")
class NewsEntity (@PrimaryKey  var news_Id:Int,
                  @ColumnInfo var assetType: String,
                  @ColumnInfo var displayName: String,
                  @ColumnInfo var lastModified: Long,
                  @ColumnInfo var onTime: Long,
                  @ColumnInfo var sponsored: Boolean,
                  @ColumnInfo var timeStamp: Long,
                  @ColumnInfo var url: String)

