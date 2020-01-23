package com.moeiny.reza.ninenews.database.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.moeiny.reza.ninenews.model.entity.Asset

@Entity (tableName = "Companies")
class CompanyEntity (@PrimaryKey (autoGenerate = true) var campany_Id:Int,
                     @ColumnInfo var name: String)

