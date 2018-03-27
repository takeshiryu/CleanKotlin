package sample.com.cleankotlin.presentation

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import sample.com.cleankotlin.R
import sample.com.domain.base.Contact
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.getContact()
    }

    override fun onResume() {
        super.onResume()
        presenter.takeView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dropView(this)
    }

    override fun loadContactList(contacts: List<Contact>) {
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = ContactAdapter(contacts)
    }
}
