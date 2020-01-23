package com.moeiny.reza.ninenews.database.dao

import androidx.room.*
import com.moeiny.reza.ninenews.database.entitiy.RelatedImageEntity

@Dao
interface RelatedImageDao {

    @Query("SELECT * FROM RelatedImages")
    fun getAll(): List<RelatedImageEntity>

    @Query("SELECT * FROM RelatedImages WHERE image_Id = :id ")
    fun findById(id: Int): RelatedImageEntity

    @Query("SELECT * FROM RelatedImages WHERE asset_Id = :id ")
    fun findByAssetId(id: Int): List<RelatedImageEntity>

    @Query("DELETE FROM RelatedImages")
    fun deleteAll()

    @Insert
    fun insert(image: RelatedImageEntity)

    @Update
    fun update(image: RelatedImageEntity)

    @Delete
    fun delete(mage: RelatedImageEntity)
}




