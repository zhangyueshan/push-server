package com.nirvana.push.core;

import java.util.Collection;

/**
 * 消息大厅。可以发布消息的接口。
 * Created by Nirvana on 2017/8/3.
 */
public interface MessageHall {

    void putMessage(Message message);

    void putMessage(Collection<Message> messages);

}
