package com.wangxingxing.jetpackcomposebasics

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wangxingxing.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme

/**
 * author : 王星星
 * date : 2021/8/25 20:07
 * email : 1099420259@qq.com
 * description :
 */

@Composable
fun MyOwnColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measureables, constraints ->
        val placeables = measureables.map { measurable ->
            measurable.measure(constraints)
        }
        var yPosition = 0
        // 设置布局（MyOwnColumn）的大小
        layout(constraints.maxWidth, constraints.maxHeight) {
            // 设置MyOwnColumn中元素的位置
            placeables.forEach { placeable ->
                placeable.placeRelative(x = 0, y = yPosition)
                yPosition += placeable.height
            }
        }
    }
}

@Preview
@Composable
fun MyOwnColumnPreview() {
    JetpackComposeBasicsTheme {
        Surface(Modifier.padding(8.dp)) {
            MyOwnColumn {
                Text("MyOwnColumn")
                Text("places items")
                Text("vertically.")
                Text("We've done it by hand!")
            }
        }
    }
}