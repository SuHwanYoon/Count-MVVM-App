package yoon.tutorials.coutermvvm

//파라미터를 의무적으로 가져야하는 Data Model class
//비즈니스 로직을 가진다
//domain layer
//paramater는 data키워드가 자동으로 함수를 생성해줘서 public하게 접근이 가능함
data class CounterModel(var count : Int) {}

//일반적으로 Model과 Repository는 별도의 class로 분리되어야 한다
//Repository layer는 일반적으로 데이터 접근 로직을 담는다
class CounterRepository{
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