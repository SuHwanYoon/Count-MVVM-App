package yoon.tutorials.coutermvvm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

//Model의 데이터를 변환하여 View에 제공하는 ViewModel이 되도록 상속처리
//ViewModel에  repository를 Injection을 사용하지 않았음
//ViewModel은 매개변수를 허용하지 않기 때문에 만약 Injection을 사용하고싶다면
//ViewModel내부에 ViewModelProvider.Factory를 생성하여야한다
//일반적으로는
class CounterViewModel() : ViewModel() {
    //DI를 하는대신 repository를 직접생성
    private val _repository : CounterRepository = CounterRepository()
    //private 변수는 관습적으로 _로 시작
    //초기값 0 상태가 내부에서 상태를 관리하기 위한 변수
    // Model 부분
//    private val _count = mutableStateOf(0)
    //초기값 0 을 ViewModel에서 직접설정하는 대신 parameter로 받은 repository를 사용해서 접근 및 설정
    private val _count = mutableStateOf(_repository.getCounter().count)

    //count : MutableState<Int>는 public 변수로, View에서 data상태를 조회할 수 있도록 하는 변수, 하지만 직접 변경은 불가능
    // 외부에서 count를 통해 상태를 조회할 수 있지만, 직접 변경할 수는 없습니다.
    // View에서 상태를 조회하기 위한 property
//    val count : MutableState<Int> = _count

    // ViewModel 인스턴스에서 직접적으로 값을 변경할수 없도록
    // State<Int>로 노출하여 읽기 전용으로 만듦
    val count: State<Int> = _count



    //View에서 접근하는 ViewModel의 증가 함수
    fun increment() {
        //MutableState변수의 값은 .value로 접근한다
//        _count.value++
        //ViewModel에서  repository의 증가함수에 접근해서 Model data값을 증가시키기
        _repository.incrementCounter()
        //1.증가된 Model data값을 repository 접근함수를 사용해서 1차적으로 Model Instance에접근
        //2.Model Instance에 접근후 증가된 Instance의 property에 접근
        //3.증가된 Instance의 property 값을 ViewModel의 private State변수에 담기
        _count.value = _repository.getCounter().count
    }

    fun decrement() {
//        _count.value--
        _repository.decrementCounter()
        _count.value = _repository.getCounter().count
    }

}