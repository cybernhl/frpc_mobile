package com.frpc.common.bean

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TunnelDataBean(
    @SerialName("type")
    var type: String,
    @SerialName("compress")
    var isCompress : Boolean,
    @SerialName("encrypt")
    var isEncrypt : Boolean,

    @SerialName("tunnelName")
    var tunnelName : String,
    @SerialName("localAddress")
    var localAddress : String,
    @SerialName("localPort")
    var localPort : Int,
    @SerialName("remotePort")
    var remotePort : Int,
)