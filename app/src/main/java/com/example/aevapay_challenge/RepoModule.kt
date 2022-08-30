package com.example.aevapay_challenge

import android.content.Context
import androidx.room.Room
import com.example.aevapay_challenge.data.Repository
import com.example.aevapay_challenge.data.local.LocalDataSource
import com.example.aevapay_challenge.data.local.LocalDataSourceContract
import com.example.aevapay_challenge.data.local.RepoDao
import com.example.aevapay_challenge.data.local.ReposDatabase
import com.example.aevapay_challenge.data.remote.NetworkDataSource
import com.example.aevapay_challenge.data.remote.NetworkDataSourceContract
import com.example.aevapay_challenge.data.remote.RetrofitBuilder
import com.example.aevapay_challenge.data.remote.RetrofitServiceConnection
import com.example.aevapay_challenge.domain.RepositoryContract
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class RepoModule {

    @Singleton
    @Provides
    fun provideRepository(localDataSource: LocalDataSource, networkDataSource: NetworkDataSource):RepositoryContract{
        return Repository(networkDataSource,localDataSource)
    }

    @Singleton
    @Provides
    fun provideNetworkDataSource(retrofitServiceConnection: RetrofitServiceConnection): NetworkDataSourceContract {
        return NetworkDataSource(retrofitServiceConnection)
    }


    @Singleton
    @Provides
    fun provideRetrofitServiceConnection():RetrofitServiceConnection{
        return RetrofitBuilder().build()
    }




    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): ReposDatabase {
        return Room.databaseBuilder(
            appContext, ReposDatabase::class.java,
            "database")
            .fallbackToDestructiveMigrationFrom(1,4)
            .build()
    }

    @Singleton
    @Provides
    fun provideRoomDao(repoDB: ReposDatabase): RepoDao {
        return repoDB.getReposDao()
    }


    @Singleton
    @Provides
    fun provideLocalDataSource(repoDao: RepoDao): LocalDataSourceContract {
        return LocalDataSource(repoDao)
    }

}