package com.moeiny.reza.ninenews.viewmodel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import com.moeiny.reza.ninenews.database.entitiy.AssetEntity
import com.moeiny.reza.ninenews.database.entitiy.RelatedImageEntity
import com.moeiny.reza.ninenews.database.repository.NineNewsRepository
import com.moeiny.reza.ninenews.model.entity.Asset
import com.moeiny.reza.ninenews.model.entity.News
import com.moeiny.reza.ninenews.presenter.NewsService
import com.moeiny.reza.ninenews.utils.NineNewsCallback
import com.moeiny.reza.ninenews.view.HomeActivity
import java.util.concurrent.CountDownLatch

class NineNewsViewModel(application: Application) : AndroidViewModel(application) {

    private  var nineNewsRepository: NineNewsRepository
    private  var allAssetData:List<AssetEntity>
    private  var allRelatedImageData:List<RelatedImageEntity>


    init {
        nineNewsRepository= NineNewsRepository(application)
        allAssetData=nineNewsRepository.getAllAsset()
        allRelatedImageData=nineNewsRepository.getAllRelatedImage()
    }


    fun insert(assetEntity: AssetEntity){
        nineNewsRepository.insertAsset(assetEntity)
    }

    fun update(assetEntity: AssetEntity){
        nineNewsRepository.updateAsset(assetEntity)
    }

    fun delete(assetEntity: AssetEntity){
        nineNewsRepository.deleteAsset(assetEntity)
    }

    fun deleteAllAsset(){
        nineNewsRepository.deleteAllAsset()
    }

    fun getAssetById(asset_Id: Int):AssetEntity{
        return nineNewsRepository.getAssetbyId(asset_Id)
    }

    fun getAssetbyType(asset_type: String):AssetEntity{
        return nineNewsRepository.getAssetbyType(asset_type )
    }

    fun getAllAsset():List<AssetEntity>{
        return allAssetData
    }

    //////////////////////////////////////////////////

    fun insert(relatedImageEntity: RelatedImageEntity) {
        nineNewsRepository.insertRelatedImage(relatedImageEntity)
    }

    fun update(relatedImageEntity: RelatedImageEntity){
        nineNewsRepository.updateRelatedImage(relatedImageEntity)
    }

    fun delete(relatedImageEntity: RelatedImageEntity){
        nineNewsRepository.deleteRelatedImage(relatedImageEntity)
    }

    fun deleteAllRelatedImage(){
        nineNewsRepository.deleteAllRelatedImage()
    }

    fun getRelatedImageById(image_Id: Int):RelatedImageEntity{
        return nineNewsRepository.getRelatedImagebyId(image_Id)
    }

    fun getRelatedImageByAssetId(asset_Id: Int):List<RelatedImageEntity>{
        return nineNewsRepository.getRelatedImagebyAssetId(asset_Id)
    }


    fun getAllRelatedImage():List<RelatedImageEntity>{
        return allRelatedImageData
    }

/////////////////////////////////////////////////////////////

fun getNewsInfo(){

       lateinit var assetList:ArrayList<Asset>
       lateinit var news:News
       val lock =  CountDownLatch(1)

    NewsService.getNewsInfo(object : NineNewsCallback<News, Throwable> {

            override fun onSuccess(result: News) {
                lock.countDown()
                assetList = ArrayList<Asset>()
                news = result
                assetList=news.assets as ArrayList<Asset>
                for(i in 0..assetList.size-1) {
                    var asset = AssetEntity(assetList[i].id, assetList[i].acceptComments, assetList[i].assetType,
                        assetList[i].byLine, assetList[i].headline, assetList[i].indexHeadline, assetList[i].lastModified,
                        assetList[i].legalStatus, assetList[i].numberOfComments, assetList[i].onTime, assetList[i].signPost,
                        assetList[i].sponsored, assetList[i].tabletHeadline, assetList[i].theAbstract, assetList[i].timeStamp,
                        assetList[i].url)

                    if (getAssetById(assetList[i].id) == null)
                        insert(asset)

                    var images=assetList[i].relatedImages
                    for (j in 0..images.size-1){
                        var image=RelatedImageEntity(assetList[i].id,images[j].id,images[j].assetType, images[0].description,
                            images[j].height, images[j].large, images[j].large2x, images[j].lastModified, images[j].photographer,
                            images[j].sponsored, images[j].thumbnail, images[j].thumbnail2x, images[j].timeStamp, images[j].type,
                            images[j].url, images[j].width, images[j].xLarge, images[j].xLarge2x)

                        if (getRelatedImageById(images[j].id)==null)
                            insert(image)

                    }
                }
            }

            override fun onError(error: Throwable?) {
                lock.countDown()
            }

            override fun onComplete() {
                lock.countDown()
                print("complete")
                var view= HomeActivity.getView()
                view.visibility= View.INVISIBLE
                HomeActivity.move()
            }
        })
    }

 }