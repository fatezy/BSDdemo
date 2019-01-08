package com.demo.observer;

/**
 * Created by 张亚飞 on 2019/1/8.
 */
public class LifecycleEvent {

    public LifecycleEvent(Lifecycle lifecycle, String type, Object data) {

        this.source = lifecycle;
        this.type = type;
        this.data = data;
    }

    private Object data = null;

    private Object source = null;

    private String type = null;

    public Object getData() {

        return (this.data);

    }

    public Object getSource() {
        return source;
    }

    public Lifecycle getLifecycle() {

        return (Lifecycle) getSource();

    }



    public String getType() {

        return (this.type);
    }
}

 