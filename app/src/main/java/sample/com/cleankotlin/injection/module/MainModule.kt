package sample.com.cleankotlin.injection.module

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import sample.com.cleankotlin.injection.qualifier.IO
import sample.com.cleankotlin.injection.qualifier.Main
import sample.com.cleankotlin.injection.qualifier.Repository
import sample.com.cleankotlin.injection.scope.ActivityScope
import sample.com.cleankotlin.presentation.MainContract
import sample.com.cleankotlin.presentation.MainPresenter
import sample.com.domain.GetContacts
import sample.com.domain.base.DataSource

@Module
class MainModule {

    @Provides
    @ActivityScope
    fun getContacts(@Repository repository: DataSource,
                    @IO ioScheduler: Scheduler,
                    @Main mainScheduler: Scheduler): GetContacts {
        return GetContacts(repository, ioScheduler, mainScheduler)
    }

    @Provides
    @ActivityScope
    fun mainPresenter(getContacts: GetContacts) : MainContract.Presenter {
        return MainPresenter(getContacts)
    }
}