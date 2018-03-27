package sample.com.cleankotlin

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

import sample.com.cleankotlin.injection.component.DaggerAppComponent

class Demo : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

}