package com.moeiny.reza.ninenews.database.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.moeiny.reza.ninenews.model.entity.Asset
import com.moeiny.reza.ninenews.model.entity.RelatedImage

@Entity (tableName = "Authors")
class AuthorEntity (@PrimaryKey  var email:String,
                    @ColumnInfo var name: String,
                    @ColumnInfo var title: String)

