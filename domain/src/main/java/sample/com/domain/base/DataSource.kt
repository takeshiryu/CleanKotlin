package sample.com.domain.base

import io.reactivex.Flowable

interface DataSource {

    fun getContactList() : Flowable<List<Contact>>
}