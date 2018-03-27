package sample.com.cleankotlin.presentation

import sample.com.domain.base.Contact

interface MainContract {
    interface View {
        fun loadContactList(contacts: List<Contact>)
    }

    interface Presenter {
        fun takeView(view: View)
        fun getContact()
        fun dropView(view: View)
    }
}