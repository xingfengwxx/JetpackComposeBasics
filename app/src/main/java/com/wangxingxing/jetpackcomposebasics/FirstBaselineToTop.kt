package com.wangxingxing.jetpackcomposebasics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.wangxingxing.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme

/**
 * author : 王星星
 * date : 2021/8/26 9:51
 * email : 1099420259@qq.com
 * description :
 */
fun Modifier.firstBaseLineToTop(
    firstBaselineToTop: Dp
) = this.then(
    layout { measurable, constraints ->
        // 测量元素
        val placeable = measurable.measure(constraints)
        // 获取元素的基线值
        check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
        val firstBaseline = placeable[FirstBaseline]
        // 元素新的Y坐标 = firstBaselineToTop - firstBaseline
        val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
        // 布局的高度
        val height = placeable.height + placeableY
        // 指定布局的宽高
        layout(placeable.width, height) {
            // 设置元素的位置
            placeable.placeRelative(0, placeableY)
        }
    }
)

@Preview
@Composable
fun TextWidthPaddingToBaselinePreview() {
    JetpackComposeBasicsTheme {
        Text(
            text = "Hi there!",
            Modifier
                .firstBaseLineToTop(24.dp)
                .background(Color.Red)
        )
    }
}

@Preview
@Composable
fun TextWithNormalPaddingPreview() {
    JetpackComposeBasicsTheme {
        Text(text = "Hi there!", Modifier.padding(top = 24.dp)
            .background(Color.Green))
    }
}