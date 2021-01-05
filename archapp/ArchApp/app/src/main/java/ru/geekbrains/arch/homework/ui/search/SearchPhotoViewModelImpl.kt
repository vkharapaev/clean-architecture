package ru.geekbrains.arch.homework.ui.search

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import ru.geekbrains.arch.homework.domain.Photo
import ru.geekbrains.arch.homework.interactor.search.SearchInteractor
import javax.inject.Inject

class SearchPhotoViewModelImpl @Inject constructor(private val searchInteractor: SearchInteractor) :
    SearchPhotoViewModel {

    private val photos: PublishSubject<List<Photo>> = PublishSubject.create()
    private val compositeDisposable = CompositeDisposable()

    override fun onSearchQueryUpdated(query: String) {
        compositeDisposable.clear()
        searchInteractor.getPhotos(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<Photo>> {
                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onNext(newPhotos: List<Photo>) {
                    photos.onNext(newPhotos)
                }

                override fun onError(e: Throwable) {
                }

                override fun onComplete() {
                }
            })
    }

    override fun getPhotos(): Observable<List<Photo>> {
        return photos
    }

    override fun onStart() {

    }

    override fun onStop() {
        compositeDisposable.clear()
    }
}
