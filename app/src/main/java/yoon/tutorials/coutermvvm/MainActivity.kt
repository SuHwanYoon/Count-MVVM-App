package yoon.tutorials.coutermvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import yoon.tutorials.coutermvvm.ui.theme.CouterMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CouterMVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterApp()
                }
            }
        }
    }
}


@Composable
fun CounterApp() {

//    val count = remember { mutableIntStateOf(0) }
    // 화면 회전 시에도 count가 유지되도록 rememberSaveable 사용
    val count = rememberSaveable { mutableIntStateOf(0) }

    fun increment() {
        count.value++
    }

    fun decrement() {
        count.value--
    }

    // 숫자와 버튼이 표시될 컬럼 UI
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 숫자 표시
        Text(
            text = "Count: ${count.value}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        // 숫자와 버튼 사이에 간격 추가
        Spacer(modifier = Modifier.height(16.dp))

        // 버튼 UI
        Row {
            Button(onClick = { increment() }) {
                Text(text = "Increment")
            }

            // 두 버튼 사이에 간격을 추가
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { decrement() }) {
                Text(text = "Decrement")
            }
        }
    }
}



