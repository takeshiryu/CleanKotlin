package sample.com.cleankotlin.injection.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import sample.com.cleankotlin.injection.qualifier.IO
import sample.com.cleankotlin.injection.qualifier.Main
import javax.inject.Singleton

@Module
abstract class ApplicationModule {

    @Binds
    abstract fun context(application: Application): Context

    @Module
    companion object {
        @Provides
        @Singleton
        @IO
        @JvmStatic
        fun ioScheduler(): Scheduler {
            return Schedulers.io()
        }

        @Provides
        @Singleton
        @Main
        @JvmStatic
        fun mainSchedule(): Scheduler {
            return AndroidSchedulers.mainThread()
        }
    }

}