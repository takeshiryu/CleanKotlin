package sample.com.cleankotlin.presentation

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.component_contact.view.*
import sample.com.cleankotlin.R
import sample.com.domain.base.Contact

class ContactAdapter(private val contacts: List<Contact>)
    : RecyclerView.Adapter<ContactAdapter.ContactHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        return ContactHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.component_contact, parent, false))
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder.bind(contacts[position])
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    class ContactHolder(v: View) : RecyclerView.ViewHolder(v) {

        fun bind(contact: Contact) {
            itemView.name.text = contact.name
            itemView.number.text = contact.number
        }
    }


}