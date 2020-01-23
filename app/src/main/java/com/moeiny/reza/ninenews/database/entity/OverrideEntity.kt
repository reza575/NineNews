package com.moeiny.reza.ninenews.database.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.moeiny.reza.ninenews.model.entity.Asset
import com.moeiny.reza.ninenews.model.entity.RelatedImage

@Entity (tableName = "Overrides")
class OverrideEntity (@PrimaryKey (autoGenerate = true) var Override_Id:Int,
                      @ColumnInfo var overrideAbstract: String,
                      @ColumnInfo var overrideHeadline: String)

