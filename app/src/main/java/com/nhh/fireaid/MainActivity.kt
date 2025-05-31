package com.nhh.fireaid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nhh.fireaid.ui.screens.LoginScreen
import com.nhh.fireaid.ui.theme.FireAidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge() cho phép ứng dụng mở rộng nội dung đến tận cạnh màn hình,
        // bao gồm cả vùng dưới thanh trạng thái và thanh điều hướng.
        // Điều này tạo ra trải nghiệm người dùng hiện đại và đẹp mắt hơn.
        enableEdgeToEdge()
        setContent {
            FireAidTheme {
                var isLoggedIn by remember { mutableStateOf(false) }
                
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    if (!isLoggedIn) {
                        LoginScreen(
                            onLoginSuccess = { isLoggedIn = true },
                            modifier = Modifier.padding(innerPadding)
                        )
                    } else {
                        // TODO: Show main content after login
                        Text(
                            text = "Welcome to FireAid!",
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FireAidTheme {
        Greeting("Android")
    }
}