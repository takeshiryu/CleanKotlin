package sample.com.data.local

import io.reactivex.Flowable
import sample.com.domain.base.Contact
import sample.com.domain.base.DataSource

class LocalDataSource : DataSource {

    private val contactList: Map<String, Contact>

    init {
        contactList = HashMap()
        contactList.put("3", Contact("3", "Mr. C", "1122 3333"))
        contactList.put("4", Contact("4", "Mr. D", "1122 4444"))
    }

    override fun getContactList(): Flowable<List<Contact>> {
        return Flowable.fromIterable(contactList.values)
                .toList()
                .toFlowable()
    }

}