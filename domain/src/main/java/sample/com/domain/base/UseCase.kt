package sample.com.domain.base

import io.reactivex.Observable
import io.reactivex.Scheduler

abstract class UseCase<in Q : UseCase.Request, P : UseCase.Response>
constructor(private val io: Scheduler,
            private val main: Scheduler) {

    fun execute(request: Q) : Observable<P> {
        return run(request)
                .subscribeOn(io)
                .observeOn(main)
    }

    abstract fun run(request: Q) : Observable<P>

    interface Request
    interface Response
}