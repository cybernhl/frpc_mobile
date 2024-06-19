package com.frpc.common.pages.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.frpc.common.Router
import com.frpc.common.bean.ChatData
import com.frpc.common.bean.ServerInfoBean
import com.frpc.common.common.SpacerEx
import com.frpc.common.common.SshSection


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage() {
    var dataList = remember {
        mutableStateOf(
            arrayListOf(
                ServerInfoBean(
                    "test1", "8.8.8.8", 8888, SshSection(
                        "","TCP", "127.0.0.1", "3306", "3306"
                    )
                ).apply {
                    chatData = ChatData("https://www.baidu.com", false)
                    isSelect = true
                },
                ServerInfoBean(
                    "test2", "8.8.8.8", 8888, SshSection(
                        "","HTTP", "127.0.0.1", "3306", "3306"
                    )
                )
            )
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("添加", color = Color.Blue, modifier = Modifier.clickable {

                    })
                    SpacerEx(25)
                    Text("编辑", color = Color.Blue, modifier = Modifier.clickable {

                    })
                    Text("", modifier = Modifier.weight(1f))

                    Text("启动", color = Color.Black, modifier = Modifier.clickable {
                        val list = dataList.value
                        list.forEach {
                            if (it.isSelect) {
                                it.isStart = true
                            }
                        }
                        dataList.value = list
                    })
                    SpacerEx(5)
                    Text("停止", color = Color.Black, modifier = Modifier.clickable {
                        val list = dataList.value
                        list.forEach {
                            if (it.isSelect) {
                                it.isStart = false
                            }
                        }
                        dataList.value = list
                    })
                    SpacerEx(5)
                    Text("全部启动", color = Color.Black, modifier = Modifier.clickable {

                    })
                    SpacerEx(5)
                    Text("全部停止", color = Color.Black, modifier = Modifier.clickable {

                    })
                    SpacerEx(5)
                }

            }, navigationIcon = {
                IconButton(onClick = { Router.popback() }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                }
            })
        }
    ) {
        Column {
            val isEditMode = remember { mutableStateOf(false) }

            if (isEditMode.value) {
                // ?
            } else {
                val nestedScrollDispatcher = NestedScrollDispatcher()
                val nestedScrollConnection = object : NestedScrollConnection {}

                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                        .nestedScroll(nestedScrollConnection, nestedScrollDispatcher),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    items(dataList.value) {
                        ServerInfoItem(it)
                    }
                }
            }
        }
    }
}

