package com.example.composetutorial.di

import com.example.composetutorial.data.DataSourceAdapter
import com.example.composetutorial.data.DataSourceContract
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindDataSource(
        dataSourceImp: DataSourceAdapter
    ): DataSourceContract

}
