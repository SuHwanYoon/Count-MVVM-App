package yoon.tutorials.coutermvvm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

//Model의 데이터를 변환하여 View에 제공하는 ViewModel
class CounterViewModel : ViewModel() {
    //private 변수는 관습적으로 _로 시작
    //초기값 0 상태가 내부에서 상태를 관리하기 위한 변수
    private val _count = mutableStateOf(0)

    //count는 public 변수로, 외부에서 상태를 조회할 수 있도록 하는 변수, 하지만 직접 변경은 불가능
    // 하지만,  _count의 값을 단순히 노출시키기 위해 사용
    // 외부에서 count를 통해 상태를 조회할 수 있지만, 직접 변경할 수는 없습니다.
    val count : MutableState<Int> = _count



    fun increment() {
        _count.value++
    }

    fun decrement() {
        _count.value--
    }

}