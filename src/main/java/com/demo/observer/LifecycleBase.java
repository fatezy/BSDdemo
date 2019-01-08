package com.demo.observer;

/**
 * Created by 张亚飞 on 2019/1/8.
 */
public class LifecycleBase implements Lifecycle{
    // 为当前类添加生命周期监听器封装类
    private LifecycleSupport lifecycle = new LifecycleSupport(this);
    private volatile LifecycleState state = LifecycleState.NEW;


    @Override
    public void addLifecycleListener(LifecycleListener listener) {
        lifecycle.addLifecycleListener(listener);
    }

    @Override
    public LifecycleListener[] findLifecycleListeners() {
        return lifecycle.findLifecycleListeners();
    }

    @Override
    public void removeLifecycleListener(LifecycleListener listener) {
        lifecycle.removeLifecycleListener(listener);
    }

    protected void fireLifecycleEvent(String type, Object data) {
        lifecycle.fireLifecycleEvent(type, data);
    }



}

 