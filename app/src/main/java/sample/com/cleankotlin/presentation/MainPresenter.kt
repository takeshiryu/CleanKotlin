package sample.com.cleankotlin.presentation

import sample.com.domain.GetContacts

class MainPresenter
constructor(private val getContacts: GetContacts)
    : MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun takeView(view: MainContract.View) {
        this.view = view
    }

    override fun getContact() {
        getContacts.execute(GetContacts.Request())
                .subscribe({ view?.loadContactList(it.contacts) })
    }

    override fun dropView(view: MainContract.View) {
        this.view = null
    }
}