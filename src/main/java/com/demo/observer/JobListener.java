package com.demo.observer;

/**
 * Created by 张亚飞 on 2019/1/8.
 */
public class JobListener implements LifecycleListener {
    protected Job job = null;
    @Override
    public void lifecycleEvent(LifecycleEvent event) {
        job = (Job) event.getLifecycle();
        if (event.getType().equals(Lifecycle.BEFORE_START_EVENT)) {
            beforeStart();
        }else if (event.getType().equals(Lifecycle.AFTER_START_EVENT)) {
            afterStart();
        }
    }

    protected synchronized void beforeStart() {
       // 执行功能
    }

    protected synchronized void afterStart() {
        // 执行功能
    }

}

 