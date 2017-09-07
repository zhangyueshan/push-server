package com.nirvana.push.core.agent;

import com.nirvana.push.core.DestroyFailedException;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认的会话实现。
 * Created by Nirvana on 2017/9/6.
 */
public class DefaultSession implements Session {

    private volatile DestroyStatus destroyStatus = DestroyStatus.NOT_DESTROY;

    private long createTime = System.currentTimeMillis();

    private long lastTime = System.currentTimeMillis();

    private Map<String, Object> attributes = new HashMap<>();

    private SessionAgent agent;

    public DefaultSession(SessionAgent agent) {
        this.agent = agent;
    }

    @Override
    public long getCreationTime() {
        return createTime;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public long getLastAccessedTime() {
        return lastTime;
    }

    @Override
    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    @Override
    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    @Override
    public void removeAttribute(String name) {
        attributes.remove(name);
    }

    @Override
    public void invalidate() {
    }

    @Override
    public void destroy() throws DestroyFailedException {
        destroyStatus = DestroyStatus.DESTROYING;
        if (agent.destroyStatus() != DestroyStatus.NOT_DESTROY) {
            agent.destroy();
        }
        destroyStatus = DestroyStatus.DESTROYED;
    }

    @Override
    public DestroyStatus destroyStatus() {
        return destroyStatus;
    }
}