package hungnvvph32403.fpt.asm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        

        setContent {
            HomeTopBar()
            HomeContent()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreen(){
    HomeContent()
}




@Composable
fun HomeContent() {


            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                HomeTopBar()
                CategoryList()
                ProductList()
                BottomNavigation()
            }
    }

@Composable
fun HomeTopBar() {
    Row(
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(id = R.drawable.search),
            contentDescription = "Search",
            modifier = androidx.compose.ui.Modifier
                .clickable {
                    // Add logic to toggle password visibility
                }
                .width(24.dp)
                .height(24.dp),
            tint = Color.Black
        )
        Column(

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = AnnotatedString("MAKE HOME"),
                color = Color.LightGray,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = AnnotatedString("BEAUTIFUL"),
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.cart),
            contentDescription = "Cart",
            modifier = androidx.compose.ui.Modifier
                .clickable {
                }
                .width(24.dp)
                .height(24.dp),
            tint = Color.Black
        )
    }
}


@Composable
fun CategoryList() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 26.dp),
        horizontalArrangement = Arrangement.spacedBy(36.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Hardcoded category items for demonstration
        CategoryItem("Furniture")
        CategoryItem("Decor")
        CategoryItem("Lighting")
        CategoryItem("Appliances")
    }
}

@Composable
fun CategoryItem(
    name: String
) {
    Column(
        modifier = Modifier
            .clickable { /* Handle category click */ }
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = R.drawable.star),
            contentDescription = "Category",
            modifier = Modifier.size(32.dp),
            tint = Color.Gray
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = name,
            color = Color.Gray,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}



@Composable
fun ProductList(
) {
    val products = listOf(
        Product(
            id = 1,
            name = "Product 1",
            price = 9.99,
            imageRes = R.drawable.sp2,
            isAddedToCart = false
        ),
        Product(
            id = 2,
            name = "Product 2",
            price = 14.99,
            imageRes = R.drawable.sp3,
            isAddedToCart = true
        ),
        Product(
            id = 3,
            name = "Product 3",
            price = 19.99,
            imageRes = R.drawable.sp2,
            isAddedToCart = false
        ),
        Product(
            id = 4,
            name = "Product 4",
            price = 24.99,
            imageRes = R.drawable.sp3,
            isAddedToCart = true
        )
    )

    LazyColumn(
        modifier = Modifier.fillMaxWidth().height(450.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(products.chunked(2)) { productPair ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ProductCard(
                    product = productPair[0],
                )
                if (productPair.size > 1) {
                    ProductCard(
                        product = productPair[1],
                    )

                }
            }
        }
    }
}

@Composable
fun ProductCard(product: Product) {
    Box(
        modifier = Modifier
            .width(170.dp)
            .height(300.dp)
            .background(color = Color.White).clickable {

            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = product.name,
            modifier = Modifier
                .width(140.dp)
                .height(200.dp)
                .clip(RoundedCornerShape(4.dp))
                .padding(bottom = 10.dp),
            Alignment.TopCenter,

        )

        Column(
            modifier = Modifier.padding(30.dp)
        ){
            Text(
                text = product.name,
                style = androidx.compose.ui.text.TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(top = 200.dp),

            )
            Text(
                text = "$ ${product.price}",
                style = androidx.compose.ui.text.TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 120.dp)
                .padding(8.dp)
                .clickable {
                    // Xử lý khi người dùng nhấn vào biểu tượng "Thêm vào giỏ hàng"
                }
        ) {
            Image(
                painter = painterResource(id = if (product.isAddedToCart) R.drawable.addtocart else R.drawable.addtocart),
                contentDescription = "Add to cart",
                modifier = Modifier
                    .size(24.dp)
            )



        }
    }

}
@Preview (showBackground = true)
@Composable
fun BottomNavigation() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavigationItem(
                icon = painterResource(id = R.drawable.homeselected),
                label = "Home",
                isSelected = true,
                onItemClick = { /* Handle home click */ }
            )
            BottomNavigationItem(
                icon = painterResource(id = R.drawable.banner),
                label = "History",
                isSelected = false,
                onItemClick = { /* Handle search click */ }
            )
            BottomNavigationItem(
                icon = painterResource(id = R.drawable.bell),
                label = "Notify",
                isSelected = false,
                onItemClick = { /* Handle cart click */ }
            )
            BottomNavigationItem(
                icon = painterResource(id = R.drawable.person),
                label = "Profile",
                isSelected = false,
                onItemClick = { /* Handle profile click */ }
            )
        }
    }
}

@Composable
fun BottomNavigationItem(
    icon: Painter,
    label: String,
    isSelected: Boolean,
    onItemClick: () -> Unit
) {
    Column(
        modifier = Modifier.clickable { onItemClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = icon,
            contentDescription = label,
            modifier = Modifier.size(24.dp),
            tint = if (isSelected) Color.Blue else Color.Gray
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            color = if (isSelected) Color.Blue else Color.Gray,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium
        )
    }
}


data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    @DrawableRes val imageRes: Int,
    val isAddedToCart: Boolean
)