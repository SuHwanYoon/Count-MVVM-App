package yoon.tutorials.coutermvvm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


//Application 클래스에 @HiltAndroidApp 어노테이션을 추가하여 Dagger Hilt를 사용할 수 있도록 설정
// Application 클래스는 앱의 전역 상태를 관리하는 클래스로, 앱이 실행되면 가장 먼저 Application 클래스가 생성됩니다.
@HiltAndroidApp
class CounterApplication : Application() {}