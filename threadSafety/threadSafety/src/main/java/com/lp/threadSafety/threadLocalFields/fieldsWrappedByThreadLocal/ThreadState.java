package com.lp.threadSafety.threadLocalFields.fieldsWrappedByThreadLocal;

public class ThreadState {

    public static final ThreadLocal<StateHolder> statePerThread = new ThreadLocal<>() {
        @Override
        protected StateHolder initialValue() {
            return new StateHolder("active");
        }
    };

    public static StateHolder getState() {
        return statePerThread.get();
    }
}
