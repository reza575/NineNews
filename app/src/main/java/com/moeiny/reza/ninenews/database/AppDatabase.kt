package com.moeiny.reza.ninenews.database

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.moeiny.reza.ninenews.database.dao.AssetDao
import com.moeiny.reza.ninenews.database.dao.RelatedImageDao
import com.moeiny.reza.ninenews.database.entitiy.AssetEntity
import com.moeiny.reza.ninenews.database.entitiy.RelatedImageEntity

@Database(entities = [(AssetEntity::class), (RelatedImageEntity::class)], version = 1, exportSchema = false)

public abstract class AppDatabase : RoomDatabase() {

    abstract fun AssetDao(): AssetDao
    abstract fun RelatedImageDao(): RelatedImageDao


    companion object {

        private var instance: AppDatabase? = null
        public var DB_NAME = "NineNews"

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room
                        .databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return instance!!
        }
    }

    private val roomCallback = object : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            PopulateDbAsyncTask(instance)
                    .execute()
        }
    }

}

    class PopulateDbAsyncTask(db: AppDatabase?) : AsyncTask<Unit, Unit, Unit>() {
    private val assetDao = db?.AssetDao()

    override fun doInBackground(vararg p0: Unit?) {
       // assetDao?.insert(AssetDaoEntity("", ""))

      }
    }

