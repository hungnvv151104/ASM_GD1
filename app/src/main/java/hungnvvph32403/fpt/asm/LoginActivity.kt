package hungnvvph32403.fpt.asm

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen(
                onForgotPasswordClicked = {
                    // Xử lý sự kiện quên mật khẩu
                },
                onLoginClicked = { username, password ->
                    intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                },
                onSignUpClicked = {
                    intent = Intent(this, SignInActivity::class.java)
                    startActivity(intent)
                }
            )
        }
    }
}

@Composable
fun LoginScreen(
    onForgotPasswordClicked: () -> Unit,
    onLoginClicked: (username: String, password: String) -> Unit,
    onSignUpClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon),
                contentDescription = "Logo",
                modifier = Modifier.width(90.dp).height(90.dp)

            )

            Text(
                text = AnnotatedString("Hello !"),
                style = TextStyle(
                    color = Color(0xFF606060),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                ),
                modifier = Modifier.align(Alignment.Start).padding(top = 30.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = AnnotatedString("WELCOME BACK"),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                ),
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(bottom = 20.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))

            var username by remember { mutableStateOf("") }
            TextField(
                value = username,
                onValueChange = { username = it },
                modifier =
                Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(5.dp)
                    .shadow(elevation = 2.dp, shape = RoundedCornerShape(8.dp))
                    .background(Color.White),
                label = { Text(
                    text = AnnotatedString("Email"),
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                ) },
            )
            Spacer(modifier = Modifier.height(1.dp))
            var password by remember { mutableStateOf("") }
            TextField(
                value = password,
                onValueChange = { password = it },
                modifier =
                Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(5.dp)
                    .shadow(elevation = 2.dp, shape = RoundedCornerShape(8.dp))
                    .background(Color.White),
                label = { Text(
                    text = AnnotatedString("Password"),
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                ) },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.eye),
                        contentDescription = "Password visibility",
                        modifier = Modifier.size(24.dp),
                        tint = Color.Gray
                    )
                }
            )


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .shadow(elevation = 2.dp, shape = RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextButton(
                        onClick = onForgotPasswordClicked,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp)
                    ) {
                        Text(
                            text = AnnotatedString("Forgot Password"),
                            color = Color.Black,
                            fontSize = 18.sp,)
                    }

                    Button(
                        onClick = { onLoginClicked(username, password) },
                        modifier = Modifier.width(160.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = AnnotatedString("Login"),
                            fontSize = 18.sp,)
                    }

                    TextButton(
                        onClick = onSignUpClicked,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 30.dp)
                    ) {
                        Text(
                            text = AnnotatedString("SIGN UP"),
                            color = Color.Black,
                            fontSize = 18.sp,)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        onForgotPasswordClicked = {},
        onLoginClicked = { username, password ->
            // Handle login click
        },
        onSignUpClicked = {
            // Handle sign up click
        }
    )
}