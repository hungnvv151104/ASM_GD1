package hungnvvph32403.fpt.asm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class PaymentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaymentScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentScreen(

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // "Thông tin thanh toán" text ở trên cùng
        Text(
            text = AnnotatedString("Thông tin thanh toán"),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // "Địa chỉ giao hàng" text nằm ở start
        Text(
            text = AnnotatedString("Địa chỉ giao hàng"),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.align(Alignment.Start)
        )

        // Box chứa 2 textfield tên người nhận và địa chỉ
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
                .shadow(elevation = 4.dp, shape = RoundedCornerShape(16.dp))
                .background(color = Color.White)
        ) {
            Column(

            ) {
                TextField(
                    value = "", // Bind this to your state
                    onValueChange = { /* Handle name change */ },
                    label = { Text(text = AnnotatedString("Tên người nhận")) },
                    modifier = Modifier.fillMaxWidth()
                )
                TextField(
                    value = "", // Bind this to your state
                    onValueChange = { /* Handle address change */ },
                    label = { Text(text = AnnotatedString("Địa chỉ")) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Text(
            text = AnnotatedString("Phương thức thanh toán"),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.align(Alignment.Start)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
                .shadow(elevation = 4.dp, shape = RoundedCornerShape(16.dp))
                .background(color = Color.White)
        ){
            TextField(
                value = "", // Bind this to your state
                onValueChange = { /* Handle name change */ },
                label = { Text(text = AnnotatedString("")) },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Text(
            text = AnnotatedString("Phương thức giao hàng"),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.align(Alignment.Start)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
                .shadow(elevation = 4.dp, shape = RoundedCornerShape(16.dp))
                .background(color = Color.White)
        ){
            TextField(
                value = "", // Bind this to your state
                onValueChange = { /* Handle name change */ },
                label = { Text(text = AnnotatedString("")) },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
                .shadow(elevation = 4.dp, shape = RoundedCornerShape(16.dp))
                .background(color = Color.White)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = AnnotatedString("Đơn hàng"))
                    Text(text = AnnotatedString("99.000 ₫"))
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = AnnotatedString("Phí vận chuyển"))
                    Text(text = AnnotatedString("20.000 ₫"))
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = AnnotatedString("Tổng"))
                    Text(text = AnnotatedString("119.000 ₫"))
                }
            }
        }

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .padding(top = 30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = AnnotatedString("Xác Nhận"),
                fontSize = 18.sp
            )
        }
    }
}