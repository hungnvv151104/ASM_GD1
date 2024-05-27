package hungnvvph32403.fpt.asm

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hungnvvph32403.fpt.asm.Model.UserModel


class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignInScreen(
                onSignInClicked = { name, email, password, confirmPassword ->

//                    if (name.isNotBlank() && password.isNotBlank() && password.isNotBlank() && confirmPassword.isNotBlank()) {
//                        if(password != confirmPassword){
//                            Toast.makeText(
//                                this,
//                                "Password and Confirm Password do not match",
//                                Toast.LENGTH_LONG
//                            ).show()
//                        }else{
//                            Toast.makeText(baseContext, "Sign Up successful",
//                                Toast.LENGTH_LONG).show()
//
//                            val user = UserModel(name, email, password, confirmPassword)
//                            intent.putExtra(KEY_DATA_USER, user)

                            intent = Intent(this, HomeActivity::class.java)

                            startActivity(intent)
//                        }

//                    } else {
//                        Toast.makeText(
//                            baseContext,
//
//                            "Please enter name and password",
//                            Toast.LENGTH_LONG
//
//                        ).show()
//                    }
                },
                onLoginClicked = {
                    intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }
            )
        }
    }
}

@Composable
fun SignInScreen(
    onSignInClicked: (name: String, email: String, password: String, confirmPassword: String) -> Unit,
    onLoginClicked: () -> Unit,
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
            val context = LocalContext.current
            Image(
                painter = painterResource(id = R.drawable.icon),
                contentDescription = "Logo",
                modifier = Modifier.width(90.dp)
                    .height(90.dp)
            )

            Text(
            text = AnnotatedString("WELCOME"),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(bottom = 20.dp).padding(top = 20.dp)
            )

            var name by remember { mutableStateOf("") }
            TextField(
                value = name,
                onValueChange = { name = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(5.dp)
                    .shadow(elevation = 2.dp, shape = RoundedCornerShape(8.dp))
                    .background(Color.White),
                label = {
                    Text(
                        text = AnnotatedString("Name"),
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            )

            var email by remember { mutableStateOf("") }
            TextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(5.dp)
                    .shadow(elevation = 2.dp, shape = RoundedCornerShape(8.dp))
                    .background(Color.White),
                label = {
                    Text(
                        text = AnnotatedString("Email"),
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            )

            var password by remember { mutableStateOf("") }
            TextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(5.dp)
                    .shadow(elevation = 2.dp, shape = RoundedCornerShape(8.dp))
                    .background(Color.White),
                label = {
                    Text(
                        text = AnnotatedString("Password"),
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.eye),
                        contentDescription = "Toggle password visibility",
                        modifier = Modifier.clickable {
                            // Add logic to toggle password visibility
                        }.width(20.dp).height(20.dp)
                    )
                }
            )

            var confirmPassword by remember { mutableStateOf("") }
            TextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(5.dp)
                    .shadow(elevation = 2.dp, shape = RoundedCornerShape(8.dp))
                    .background(Color.White),
                label = {
                    Text(
                        text = AnnotatedString("Confirm Password"),
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.eye),
                        contentDescription = "Toggle password visibility",
                        modifier = Modifier.clickable {
                            // Add logic to toggle password visibility
                        }.width(20.dp).height(20.dp)
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
                    val context = LocalContext.current
                    Button(
                        onClick = { onSignInClicked(name, email, password, confirmPassword)},
                        modifier = Modifier.width(160.dp).padding(top = 30.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = AnnotatedString("Sign Up"),
                            fontSize = 18.sp
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = AnnotatedString("Already have an account?"),
                            color = Color.Gray,
                            fontSize = 16.sp
                        )
                        TextButton(
                            onClick = onLoginClicked,

                        ) {
                            Text(
                                text = AnnotatedString("Login"),
                                color = Color.Black,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }
    }
}
    @Preview(showBackground = true)
    @Composable
    fun SignInScreenPreview() {
        SignInScreen(
            onSignInClicked = { name, email, password, confirmPassword ->
                // Handle sign in logic here
            },
            onLoginClicked = {}
        )
    }


