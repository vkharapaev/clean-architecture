package ru.geekbrains.arch.homework.di

import ru.geekbrains.arch.homework.interactor.search.SearchInteractor
import ru.geekbrains.arch.homework.interactor.search.SearchInteractorImpl
import ru.geekbrains.arch.homework.ui.search.SearchPhotoViewModel
import ru.geekbrains.arch.homework.ui.search.SearchPhotoViewModelImpl
import toothpick.config.Module

class SearchModule: Module() {
    init {
        bind(SearchInteractor::class.java).to(SearchInteractorImpl::class.java).singleton()
        bind(SearchPhotoViewModel::class.java).to(SearchPhotoViewModelImpl::class.java).singleton()
    }
}
