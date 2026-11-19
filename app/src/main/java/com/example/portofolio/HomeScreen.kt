package com.example.portofolio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Badge
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.WorkOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController? = null,
    name: String = "Agustinus Denny Tjandra",
    role: String = "IT Engineer",
    onMenuClick: () -> Unit = {},
    onContactClick: () -> Unit = {},
    onWorkClick: () -> Unit = {},
    onAboutClick: () -> Unit = {navController?.navigate("About")},
    onLocationClick: () -> Unit = {}
) {
//    Gradient color
    val backgroundBrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF0061FF), // Soft Blue
            Color(0xFF30A8FF), // Soft transition
            Color(0xFF60EFFF)  // Light pastel blue
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundBrush)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(top = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 12.dp)
            ) {
                // Custom 2-bar menu icon
                Column(
                    modifier = Modifier
                        .clickable(onClick = onMenuClick)
                        .padding(vertical = 4.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(20.dp)
                            .height(3.dp)
                            .background(Color.White, RoundedCornerShape(2.dp))
                    )
                    Box(
                        modifier = Modifier
                            .width(13.dp)
                            .height(3.dp)
                            .background(Color.White, RoundedCornerShape(2.dp))
                    )
                }

                Spacer(modifier = Modifier.height(28.dp))

                Text(
                    text = name,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = role,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
            }

            // Character Avatar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    painter = painterResource(id = R.drawable.charimage),
                    contentDescription = "Character Avatar",
                    modifier = Modifier
                        .fillMaxWidth(0.92f)
                        .fillMaxHeight()
                        .offset(y = 28.dp),
                    alignment = Alignment.BottomCenter,
                    contentScale = ContentScale.FillWidth
                )
            }

            // Bottom White Card
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                color = Color.White,
                shadowElevation = 10.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, bottom = 32.dp)
                ) {
                    // Top row
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "Can I help you?",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color(0xFF94A3B8)
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "Let's work?",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF1E293B)
                            )
                        }

                        Button(
                            onClick = onContactClick,
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFF4BE38)
                            ),
                            contentPadding = PaddingValues(horizontal = 22.dp, vertical = 11.dp)
                        ) {
                            Text(
                                text = "Contact me",
                                color = Color.White,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(22.dp))

                    // Row of Action Cards
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState())
                            .padding(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        ActionCard(
                            backgroundColor = Color(0xFFF70063),
                            icon = Icons.Outlined.WorkOutline,
                            title = "know my work",
                            onClick = onWorkClick
                        )

                        ActionCard(
                            backgroundColor = Color(0xFF56C4CF),
                            icon = Icons.Outlined.Badge,
                            title = "aboutme",
                            onClick = onAboutClick
                        )

                        ActionCard(
                            backgroundColor = Color(0xFF91A0F8),
                            icon = Icons.Outlined.LocationOn,
                            title = "where i am",
                            onClick = onLocationClick
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ActionCard(
    backgroundColor: Color,
    icon: ImageVector,
    title: String,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .size(width = 124.dp, height = 124.dp)
            .clip(RoundedCornerShape(22.dp))
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(18.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = Color.White,
                modifier = Modifier.size(26.dp)
            )

            Text(
                text = title,
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 19.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
