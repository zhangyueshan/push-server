package com.nirvana.push.protocol;

/*
* 协议包。
*
* A. header:3byte
*
* +———————————————————————————————————————————————+
* |1 2 3 4 5 6 7 8|1 2 3 4 5 6 7 8|1 2 3 4 5 6 7 8|
* |  a  | b |  c  |               d               |
* +———————————————————————————————————————————————+
*
* a:3bit -->  消息类型：负载/心跳/响应
* b:2bit -->  消息等级：0-无检查/1-至少一次/2-恰好一次
* c:3bit -->  消息内容编码
* d:16bit-->  消息体长度，包括尾部特殊字节
*
*
* B. footer:1byte
*
* 0xff
*
* Created by Nirvana on 2017/8/1.
* */