package com.example.feature1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.feature1.theme.AndroidJetpackComposeLoginFormTheme

class SignInFragment : Fragment() {

//    private val viewModel: FeatureViewModel by viewModels()
//    var strPassword: String = ""
//    var strUserName: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AndroidJetpackComposeLoginFormTheme {
                    Surface(color = MaterialTheme.colors.background) {
                        LoginForm()
                    }
                }
            }
        }
//        val viewModel = ViewModelProvider(this).get(FeatureViewModel::class.java)
    }

    @Composable
    fun LoginForm() {
        Box(contentAlignment = Alignment.TopCenter, modifier = Modifier.fillMaxSize()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                val modifier = Modifier.padding(vertical = 4.dp)

                Text(
                    "Login Form",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    modifier = modifier.then(
                        Modifier.background(
                            Color(android.graphics.Color.RED),
                            RectangleShape
                        )
                    )
                )

                val usernameState = remember { mutableStateOf(TextFieldValue()) }
                TextField(
                    value = usernameState.value,
                    onValueChange = {
                        usernameState.value = it
                    },
                    placeholder = { Text("Username") },
                    modifier = modifier
                )

                Text(text = "Password")
                val passwordState = remember { mutableStateOf(TextFieldValue()) }
                TextField(
                    value = passwordState.value,
                    onValueChange = {
                        passwordState.value = it
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    placeholder = { Text("Password") },
                    modifier = modifier
                )

                val textSubmitState =
                    remember { mutableStateOf("Your data that you submit will display here") }
                Button(onClick = {
                    val username = usernameState.value.text
                    val password = passwordState.value.text

                    textSubmitState.value = "your username: $username your password:$password"
                }) {
                    Text("Login")
                }

                Text(
                    text = textSubmitState.value
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        AndroidJetpackComposeLoginFormTheme {
            LoginForm()
        }
    }
}