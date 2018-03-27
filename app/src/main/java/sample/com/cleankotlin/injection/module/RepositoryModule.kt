package sample.com.cleankotlin.injection.module

import dagger.Module
import dagger.Provides
import sample.com.cleankotlin.injection.qualifier.Local
import sample.com.cleankotlin.injection.qualifier.Remote
import sample.com.cleankotlin.injection.qualifier.Repository
import sample.com.data.DataRepository
import sample.com.data.local.LocalDataSource
import sample.com.data.remote.RemoteDataSource
import sample.com.domain.base.DataSource
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    @Repository
    fun getDataRepository(@Local localDataSource: DataSource,
                           @Remote remoteDataSource: DataSource): DataSource {
        return DataRepository(localDataSource, remoteDataSource)
    }

    @Provides
    @Singleton
    @Remote
    fun getRemoteDataSource(): DataSource {
        return RemoteDataSource()
    }

    @Provides
    @Singleton
    @Local
    fun getLocalDataSource(): DataSource {
        return LocalDataSource()
    }
}