package sample.com.cleankotlin.injection.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import sample.com.cleankotlin.injection.scope.ActivityScope
import sample.com.cleankotlin.presentation.MainActivity

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun mainActivity(): MainActivity
}