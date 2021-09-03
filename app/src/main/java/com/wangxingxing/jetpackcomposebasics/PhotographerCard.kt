package com.wangxingxing.jetpackcomposebasics

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wangxingxing.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme

/**
 * author : 王星星
 * date : 2021/8/25 20:32
 * email : 1099420259@qq.com
 * description :
 */
@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Row(
        modifier
            .clip(RoundedCornerShape(4.dp))
            .background(color = MaterialTheme.colors.surface)
            .padding(16.dp)
            .clickable(onClick = {})
    ) {
        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.beauty),
                contentDescription = null
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text(text = "Alfred Sisley", fontWeight = FontWeight.Bold)
            Text(text = "3 minutes ago", style = MaterialTheme.typography.body2)
        }
    }
}

@Preview
@Composable
fun PhotographerCardPreview() {
    JetpackComposeBasicsTheme {
        PhotographerCard()
    }
}