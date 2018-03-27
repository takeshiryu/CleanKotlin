package sample.com.data

import io.reactivex.Flowable
import sample.com.domain.base.Contact
import sample.com.domain.base.DataSource

class DataRepository
constructor(private val localDataSource: DataSource,
            private val remoteDataSource: DataSource)
    : DataSource {

    override fun getContactList(): Flowable<List<Contact>> {
        return Flowable.concat(localDataSource.getContactList(),
                remoteDataSource.getContactList())
    }
}