package com.ahmed.pizzaoven.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmed.pizzaoven.R

@Composable
fun CartButton(
    addToCart: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = addToCart,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF3D312E),
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .padding(8.dp)
            .width(150.dp)
            .height(45.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.cart),
                contentDescription = "Cart Icon",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )

            Text(
                text = "Add to Cart",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CartButtonPreview() {
    CartButton(
        addToCart = {}
    )
}


