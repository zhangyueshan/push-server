package com.nirvana.xin.core.broker;

import com.nirvana.purist.core.message.Message;
import com.nirvana.purist.utils.tuple.Pair;

import java.util.Collection;

/**
 * Created by Nirvana on 2017/12/4.
 * A implement of MarkableMessageSource that messages stores in redis.
 */
public class RedisMessageSource implements MarkableMessageSource {

    @Override
    public Pair<Long, Object> consumer(long mark) {
        return null;
    }

    @Override
    public Pair<Long, Collection<Object>> consumer(long mark, int maxNum) {
        return null;
    }

    @Override
    public void putMessage(Message message) {

    }

    @Override
    public void putMessage(Collection<Message> messages) {

    }
}
