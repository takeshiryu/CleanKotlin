package sample.com.data.remote

import io.reactivex.Flowable
import sample.com.domain.base.Contact
import sample.com.domain.base.DataSource
import java.util.concurrent.TimeUnit


class RemoteDataSource : DataSource {

    private val contactList: MutableMap<String, Contact>

    init {
        contactList = HashMap()
        contactList.put("1", Contact("1", "Mr. A", "0011 1111"))
        contactList.put("2", Contact("2", "Mr. B", "0011 2222"))
    }

    override fun getContactList(): Flowable<List<Contact>> {
        return Flowable.fromIterable(contactList.values)
                .delay(3, TimeUnit.SECONDS)
                .toList()
                .toFlowable()
    }
}