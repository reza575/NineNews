package com.moeiny.reza.ninenews.database.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "AssetAuthors")
class AssetAssetEntity (@PrimaryKey (autoGenerate = true) var Id:Int,
                        @ColumnInfo var asset1_Id: Int,
                        @ColumnInfo var asset2_Id: Int)

