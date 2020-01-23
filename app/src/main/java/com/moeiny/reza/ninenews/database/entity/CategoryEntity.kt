package com.moeiny.reza.ninenews.database.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.moeiny.reza.ninenews.model.entity.Asset

@Entity (tableName = "Categories")
class CategoryEntity (@PrimaryKey  var orderNum:Int,
                      @ColumnInfo var name: String,
                      @ColumnInfo var sectionPath: String)

