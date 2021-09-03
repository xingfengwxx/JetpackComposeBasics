package com.wangxingxing.jetpackcomposebasics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wangxingxing.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme

/**
 * author : 王星星
 * date : 2021/8/25 20:52
 * email : 1099420259@qq.com
 * description :
 */
@Composable
fun LayoutStudy() {
    // 脚手架，只要去填坑
    Scaffold(
        // 顶部条目
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutStudy")
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                }
            )
        }
    ) {
        BodyContent(Modifier.padding(it))
    }
}

// 中间内容部分
@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        Text(text = "Hi there!")
        Text(text = "Thanks for going through the LayoutStudy")
    }
}

@Preview
@Composable
fun LayoutStudyPreview() {
    JetpackComposeBasicsTheme() {
        LayoutStudy()
    }
}