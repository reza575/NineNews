package com.moeiny.reza.ninenews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moeiny.reza.ninenews.adapter.NewsAdapter
import com.moeiny.reza.ninenews.database.entitiy.AssetEntity
import com.moeiny.reza.ninenews.database.entitiy.RelatedImageEntity
import com.moeiny.reza.ninenews.viewmodel.ShowAsset
import com.moeiny.reza.ninenews.viewmodel.NineNewsViewModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var assetList:ArrayList<AssetEntity>
    lateinit var showList:ArrayList<ShowAsset>
    lateinit var recyclerView: RecyclerView

    lateinit var viewModel: NineNewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpView()
        assetList=viewModel.getAllAsset() as ArrayList<AssetEntity>

        //Pushing Data from DataBase to View Model and send them to recyclerview
        loadData()
    }

    fun loadData(){
        showList.clear()
        for ( i in 0..assetList.size-1){
            var imageLiast=viewModel.getRelatedImageByAssetId(assetList[i].asset_Id)
             var image:RelatedImageEntity?

            var url:String?=""
            if (imageLiast.size!=0) {
                image = viewModel.getRelatedImageById(imageLiast[0].image_Id)
                url = image.url
            }

            //Creating ShowAsset Instance Model
            var show= ShowAsset(assetList[i].asset_Id, assetList[i].assetType, assetList[i].byLine, assetList[i].headline,
                url!!, assetList[i].theAbstract, getDate(assetList[i].timeStamp), assetList[i].url)

            showList.add(show)
        }

        setDataOnRecycler(showList)
    }

    fun setDataOnRecycler(showList:List<ShowAsset>) {
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = NewsAdapter(this,showList)
    }

    //Initializing Widget and Component
    fun setUpView() {
        assetList = ArrayList<AssetEntity>()
        showList = ArrayList<ShowAsset>()
        viewModel = ViewModelProviders.of(this).get(NineNewsViewModel::class.java)
        recyclerView = findViewById(R.id.rv_main_lastnews)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    //changing timestamp to date /time
    private fun getDate(time: Long): String {
        val date = Date(time )
        val sdf = SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss") // the format of your date
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+10"))

        return sdf.format(date)
    }
}
