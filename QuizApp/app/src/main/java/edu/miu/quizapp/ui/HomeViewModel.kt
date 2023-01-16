package edu.miu.quizapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private var scoreLiveData= MutableLiveData<Int>()
    private var curIndex= MutableLiveData<Int>()
    init {
        scoreLiveData.value = 0
        curIndex.value = 0
    }
    fun getInitialScore(): MutableLiveData<Int> {
        scoreLiveData.value = 0
        return  scoreLiveData
    }
    fun getCurrentScore(){
        scoreLiveData.value= scoreLiveData.value?.plus(1)
    }
    fun getFinalScore(): MutableLiveData<Int>{
        return scoreLiveData
    }

    fun getInitialIndex(): MutableLiveData<Int> {
        curIndex.value = 0
        return  curIndex
    }
    fun getCurrentIndex(){
        curIndex.value= curIndex.value?.plus(1)
    }
    fun getFinalIndex(): MutableLiveData<Int>{
        return curIndex
    }
}
