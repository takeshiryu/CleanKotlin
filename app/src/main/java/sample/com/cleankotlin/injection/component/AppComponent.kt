package sample.com.cleankotlin.injection.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import sample.com.cleankotlin.Demo
import sample.com.cleankotlin.injection.module.ActivityModule
import sample.com.cleankotlin.injection.module.ApplicationModule
import sample.com.cleankotlin.injection.module.RepositoryModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        ActivityModule::class,
        RepositoryModule::class,
        AndroidSupportInjectionModule::class
))
interface AppComponent : AndroidInjector<Demo> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}