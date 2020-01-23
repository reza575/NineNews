package com.moeiny.reza.ninenews.database.repository

import android.app.Application
import android.os.AsyncTask
import com.moeiny.reza.ninenews.database.entitiy.*
import com.moeiny.reza.ninenews.database.AppDatabase
import com.moeiny.reza.ninenews.database.dao.AssetDao
import com.moeiny.reza.ninenews.database.dao.RelatedImageDao


class NineNewsRepository(application: Application){

    private  var assetDao: AssetDao
    private  var relatedImageDao: RelatedImageDao


    private  var allAssetData:List<AssetEntity>
    private  var allRelatedImageData:List<RelatedImageEntity>


    init {
        val db: AppDatabase = AppDatabase.getInstance(
                application.applicationContext )!!

        assetDao = db.AssetDao()
        relatedImageDao = db.RelatedImageDao()

        allAssetData = assetDao.getAll()
        allRelatedImageData = relatedImageDao.getAll()

    }

    ////////////////////////////////Asset////////////////////////////

    fun insertAsset(assetEntity: AssetEntity){
        AssetInsert(assetDao).execute(assetEntity)
    }

    fun updateAsset(assetEntity: AssetEntity){
        AssetUpdate(assetDao).execute(assetEntity)
    }

    fun deleteAsset(assetEntity: AssetEntity){
        AssetDelete(assetDao).execute(assetEntity)
    }

    fun deleteAllAsset(){
        assetDao.deleteAll()
    }

    fun getAllAsset():List<AssetEntity>{
        return allAssetData
    }

    fun getAssetbyId(asset_id:Int):AssetEntity{
        return assetDao.findById(asset_id)
    }

    fun getAssetbyType(asset_type:String):AssetEntity{
        return assetDao.findByType(asset_type)
    }

    private class AssetInsert(assetDao: AssetDao): AsyncTask<AssetEntity, Void, Void>(){

        private var assetDao: AssetDao
        init{
            this.assetDao=assetDao
        }

        override fun doInBackground(vararg p0: AssetEntity): Void? {
            assetDao.insert(p0[0])
            return null
        }

    }

    private class AssetUpdate(assetDao: AssetDao): AsyncTask<AssetEntity, Void, Void>(){

        private var assetDao:AssetDao
        init{
            this.assetDao=assetDao
        }

        override fun doInBackground(vararg p0: AssetEntity): Void? {
            assetDao.update(p0[0])
            return null
        }
    }

    private class AssetDelete(assetDao: AssetDao): AsyncTask<AssetEntity, Void, Void>(){

        private var assetDao:AssetDao
        init{
            this.assetDao=assetDao
        }

        override fun doInBackground(vararg p0: AssetEntity): Void? {
            assetDao.delete(p0[0])
            return null
        }
    }

    //////////////////////////////////////////

    fun insertRelatedImage(image: RelatedImageEntity){
        RelatedImageInsert(relatedImageDao).execute(image)
    }

    fun updateRelatedImage(image: RelatedImageEntity){
        RelatedImageUpdate(relatedImageDao).execute(image)
    }

    fun deleteRelatedImage(image: RelatedImageEntity){
        RelatedImageDelete(relatedImageDao).execute(image)
    }

    fun deleteAllRelatedImage(){
        relatedImageDao.deleteAll()
    }

    fun getAllRelatedImage():List<RelatedImageEntity>{
        return allRelatedImageData
    }

    fun getRelatedImagebyId(image_id:Int):RelatedImageEntity{
        return relatedImageDao.findById(image_id)
    }

    fun getRelatedImagebyAssetId(asset_id:Int):List<RelatedImageEntity>{
        return relatedImageDao.findByAssetId(asset_id)
    }

    private class RelatedImageInsert(relatedImageDao: RelatedImageDao): AsyncTask<RelatedImageEntity, Void, Void>(){

        private var relatedImageDao: RelatedImageDao
        init{
            this.relatedImageDao=relatedImageDao
        }

        override fun doInBackground(vararg p0: RelatedImageEntity): Void? {
            relatedImageDao.insert(p0[0])
            return null
        }

    }

    private class RelatedImageUpdate(relatedImageDao: RelatedImageDao): AsyncTask<RelatedImageEntity, Void, Void>(){

        private var relatedImageDao:RelatedImageDao
        init{
            this.relatedImageDao=relatedImageDao
        }

        override fun doInBackground(vararg p0: RelatedImageEntity): Void? {
            relatedImageDao.update(p0[0])
            return null
        }
    }

    private class RelatedImageDelete(relatedImageDao: RelatedImageDao): AsyncTask<RelatedImageEntity, Void, Void>(){

        private var relatedImageDao:RelatedImageDao
        init{
            this.relatedImageDao=relatedImageDao
        }

        override fun doInBackground(vararg p0: RelatedImageEntity): Void? {
            relatedImageDao.delete(p0[0])
            return null
        }
    }

}




