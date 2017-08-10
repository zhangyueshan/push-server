package com.nirvana.push.protocol;

/*
* 协议包。
*
* +———————————————+
* |1 2 3 4 5 6 7 8|
* |———————————————|
* |   A   |B| C |D|
* +———————————————+
*
* +———————————————————————————————————————————————————————————————+
* |1 2 3 4 5 6 7 8|1 2 3 4 5 6 7 8|1 2 3 4 5 6 7 8|1 2 3 4 5 6 7 8|
* |———————————————————————————————————————————————————————————————|
* |       E       |      ...      |      ...      |      ...      |
* +———————————————————————————————————————————————————————————————+
*
* +———————————————————————————————————————————————————————————————————————————————————————————————+
* |1 2 3 4 5 6 7 8|1 2 3 4 5 6 7 8|1 2 3 4 5 6 7 8|1 2 3 4 5 6 7 8|1 2 3 4 5 6 7 8|1 2 3 4 5 6 7 8|
* |———————————————————————————————————————————————————————————————————————————————————————————————|
* |       F       |      ...      |      ...      |      ...      |      ...      |      ...      |
* +———————————————————————————————————————————————————————————————————————————————————————————————+
*
* +———————————————————————————————+
* |1 2 3 4 5 6 7 8|1 2 3 4 5 6 7 8|
* |———————————————————————————————|
* |               G               |
* +———————————————————————————————+
*
*
* [A] : 4bit -->  消息类型：负载/心跳/响应
* [B] : 1bit -->  消息是否包含消息唯一序列号：0-不包含/1-包含
* [C] : 2bit -->  消息服务质量：1-不保证/2-至少一次/3-有且仅一次
* [D] : 1bit -->  消息是否在服务端保存，如果有新的订阅者出现，就把这消息推送给它：0-不保存/1-保存
* [E] : 1-4byte -->  消息剩余长度。每个字节低7位有效位用于编码数据，最高有效位用于指示是否有更多的字节。最大4个字节。
* [F] : 1-6byte -->  如果[B]标志置1，则会有此消息序列号部分。可以为全局唯一消息序列号，也可以为session内部唯一序列号。由具体业务实现语义。编码方式同[E]。
* [G] : 2byte -->  固定两字节的包尾填充数据。值固定为0x0FFFF.
*
*
* Created by Nirvana on 2017/8/1.
* */