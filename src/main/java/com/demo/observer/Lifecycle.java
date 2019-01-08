package com.demo.observer;

/**
 * Created by 张亚飞 on 2019/1/8.
 */
public interface Lifecycle {

    public static final String BEFORE_INIT_EVENT = "before_init";

    public static final String AFTER_INIT_EVENT = "after_init";

    public static final String START_EVENT = "start";

    public static final String BEFORE_START_EVENT = "before_start";

    public static final String AFTER_START_EVENT = "after_start";

    public static final String STOP_EVENT = "stop";


    public static final String BEFORE_STOP_EVENT = "before_stop";

    public static final String AFTER_STOP_EVENT = "after_stop";

    public void addLifecycleListener(LifecycleListener listener);
    public LifecycleListener[] findLifecycleListeners();
    public void removeLifecycleListener(LifecycleListener listener);

}

 