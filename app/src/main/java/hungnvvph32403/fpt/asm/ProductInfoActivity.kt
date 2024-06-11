package hungnvvph32403.fpt.asm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

class ProductInfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductDetailsScreen()
        }
    }
}
@Preview (showBackground = true)
@Composable
fun ProductDetailsScreen(

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(370.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Absolute.Right
        ){
            Image(
                painter = painterResource(id = R.drawable.sp3),
                contentDescription = "Product Image",
                modifier = Modifier
                    .width(290.dp)
                    .height(370.dp)
                    .clip(RoundedCornerShape(10.dp))



            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 24.dp)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text(
                text = AnnotatedString("Product Name"),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 27.sp
                ),

                )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = AnnotatedString("99,999 VND"),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 30.sp
                ),
                fontWeight = FontWeight.Bold

            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = AnnotatedString("abcabc abcabc abcabcabcabc abcabc abcabc abcabc abcabc abcabc"),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 17.sp
                ),


                )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(370.dp)
                    .padding(bottom = 16.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Absolute.Right

            ){
                Button(
                    onClick = {},
                    modifier = Modifier
                        .width(200.dp)
                        .height(50.dp)
                        .clip(RoundedCornerShape(15.dp)),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text= AnnotatedString("Thêm vào giỏ hàng"))
                }
            }


        }

    }
}
