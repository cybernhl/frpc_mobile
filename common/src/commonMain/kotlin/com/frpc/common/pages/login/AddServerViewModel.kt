package com.frpc.common.pages.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.frpc.common.bean.TunnelDataBean
import com.frpc.common.common.CommonSection
import com.frpc.common.common.LocalConfigManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class AddServerViewModel : ViewModel() {

//    private val _configFlow = MutableStateFlow<TunnelDataBean?>(null)
//    private val _commonSectionFlow = MutableStateFlow<CommonSection?>(null)
//
//    @Composable
//    fun sshConfigData() = _configFlow.collectAsState(null, viewModelScope.coroutineContext)
//
//    @Composable
//    fun commonConfigData() =
//        _commonSectionFlow.collectAsState(null, viewModelScope.coroutineContext)

    suspend fun initConfig() = LocalConfigManager.loadInitConfig()

}