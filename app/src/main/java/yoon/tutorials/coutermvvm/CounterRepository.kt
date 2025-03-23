package yoon.tutorials.coutermvvm

import javax.inject.Inject

//일반적으로 Model과 Repository는 별도의 class로 분리되어야 한다
//Repository layer는 일반적으로 데이터 접근 로직을 담는다
//Repository는 ViewModel과 Model 사이에서 데이터를 관리하고 전달하는 역할을 한다
// CounterRepository에 @Inject 어노테이션을 추가하여 Dagger Hilt에 의존성 주입을 요청
class CounterRepository @Inject constructor() {
    //Model 데이터를 담지만 counter instance에 접근이 불가한 private property
    //초기값은 0으로 설정
    private var _counter = CounterModel(0)

    //간접적으로 counter 변수에 접근하기위한 함수
    fun getCounter() = _counter

    //counter를 증가시키기 위한 함수
    fun incrementCounter(){
        _counter.count++
    }

    //counter를 감소시키기 위한 함수
    fun decrementCounter(){
        _counter.count--
    }
}