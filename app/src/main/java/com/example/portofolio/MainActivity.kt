package com.example.portofolio
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme{
                PortofolioAppNavigation()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PortofolioAppNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController , startDestination = "welcome") {
        composable("welcome") {
            WelcomeScreen(navController)
        }
        composable("Home"){
            HomeScreen(navController)
        }
        composable("About"){
            AboutScreen(navController)
        }
    }

}

@Composable
fun WelcomeScreen(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2391FF))
            .clickable { navController.navigate("Home") }
            .padding(top = 24.dp , bottom = 24.dp)
    ){
        //Text
        Text(
            text = "Welcome",
            color = Color.White,
            fontSize = 194.sp,
            fontWeight = FontWeight.Bold,
            softWrap = false,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .verticalTextFromBottom()
                .padding(bottom = 12.dp)
        )
        // Image
        Image(
            painter = painterResource(R.drawable.charimage),
            contentDescription = "Avatar",
            modifier = Modifier
                .fillMaxHeight(1f)
                .align(Alignment.BottomEnd)
                .graphicsLayer(
                    scaleX = 2.5f,
                    scaleY = 2.5f
                )
                .offset(x = 75.dp , y = 20.dp)
        )
    }
}

fun Modifier.verticalTextFromBottom() = this.layout { measurable, constraints ->
    val placeable = measurable.measure(
        constraints.copy(
            minWidth = constraints.minHeight,
            maxWidth = constraints.maxHeight,
            minHeight = constraints.minWidth,
            maxHeight = constraints.maxWidth
        )
    )
    layout(placeable.height, placeable.width){
        placeable.placeWithLayer(
            x = -(placeable.width - placeable.height)/2,
            y = (placeable.width - placeable.height)/2
        )
    }
}.rotate(-90f)