package ru.geekbranins.arch.homework.ui.main

interface MainPresenter {
    interface View {
        fun showRateProposal()
    }

    fun onStart()
    fun onStop()
    fun onRatePositive()
    fun onRateNegative()
}