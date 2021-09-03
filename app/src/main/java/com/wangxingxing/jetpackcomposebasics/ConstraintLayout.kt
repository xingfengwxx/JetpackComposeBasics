package com.wangxingxing.jetpackcomposebasics

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.wangxingxing.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme

/**
 * author : 王星星
 * date : 2021/9/1 20:29
 * email : 1099420259@qq.com
 * description :
 */

@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout {
        // 通过createRefs创建引用，ConstraintLayout中的每个元素都需要关联一个引用
        val (button, text) = createRefs()
        Button(
            onClick = { /*TODO*/ },
            // 使用Modifier.constrainAs来提供约束，引用作为它的第一个参数
            // 在lambda表达式中指定约束规则
        modifier = Modifier.constrainAs(button) {
            // 使用linkTo指定约束，parent是ConstraintLayout的引用
            top.linkTo(parent.top, margin = 16.dp)
        }
        ) {
            // 按钮上显示的文字
            Text(text = "Button")
        }

        Text(text = "Text", Modifier.constrainAs(text) {
            top.linkTo(button.bottom, margin = 16.dp)
            // 在ConstraintLayout中水平居中
            centerHorizontallyTo(parent)
        })
    }
}

@Composable
fun ConstraintLayoutContent2() {
    ConstraintLayout {
        val (button1, button2, text) = createRefs()
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(button1) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text(text = "Button 1")
        }
        Text(text = "Text", Modifier.constrainAs(text) {
            top.linkTo(button1.bottom, margin = 16.dp)
            centerAround(button1.end)
        })

        val barrier = createEndBarrier(button1, text)
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(button2) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(barrier)
            }
        ) {
            Text(text = "Button 2")
        }
    }
}

@Preview
@Composable
fun ConstraintLayoutContentPreview() {
    JetpackComposeBasicsTheme {
        ConstraintLayoutContent()
    }
}

@Preview
@Composable
fun ConstraintLayoutContent2Preview() {
    JetpackComposeBasicsTheme {
        ConstraintLayoutContent2()
    }
}