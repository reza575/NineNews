package com.moeiny.reza.ninenews.database.dao

import androidx.room.*
import com.moeiny.reza.ninenews.database.entitiy.AssetEntity

@Dao
interface AssetDao {

    @Query("SELECT * FROM Assets ORDER BY timeStamp DESC")
    fun getAll(): List<AssetEntity>

    @Query("SELECT * FROM Assets WHERE assetType = :type")
    fun findByType(type: String): AssetEntity

    @Query("SELECT * FROM Assets WHERE asset_Id = :id ")
    fun findById(id: Int): AssetEntity

    @Query("DELETE FROM Assets")
    fun deleteAll()

    @Insert
    fun insert(asset: AssetEntity)

    @Update
    fun update(asset: AssetEntity)

    @Delete
    fun delete(asset: AssetEntity)
}




