package sample.com.domain

import io.reactivex.Observable
import io.reactivex.Scheduler
import sample.com.domain.base.Contact
import sample.com.domain.base.DataSource
import sample.com.domain.base.UseCase

class GetContacts
constructor(private val dataSource: DataSource,
            io: Scheduler,
            main: Scheduler) : UseCase<GetContacts.Request, GetContacts.Response>(io, main) {

    override fun run(request: Request): Observable<Response> {
        return dataSource.getContactList()
                .map { Response(contacts = it) }
                .toObservable()
    }

    class Request : UseCase.Request

    data class Response
    constructor(val contacts: List<Contact>) : UseCase.Response
}