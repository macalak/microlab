package com.gopas.castleregistergtw.application.interceptor;

import java.util.Map;
import java.util.concurrent.Callable;

import org.springframework.stereotype.Component;

import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;

import com.gopas.castleregistergtw.application.util.ThreadContext;


@Component
public class CustomHystrixConcurrencyStrategy 
	extends HystrixConcurrencyStrategy {

    public CustomHystrixConcurrencyStrategy() {
        
    	HystrixPlugins.reset();
        HystrixPlugins.getInstance().registerConcurrencyStrategy(this);
    }

    @Override
    public <T> Callable<T> wrapCallable(Callable<T> callable) {
        return new HystrixContextWrapper<T>(callable);
    }

    public static class HystrixContextWrapper<V> implements Callable<V> {
    	Map<String, Object> threadData;
        private Callable<V> delegate;

        public HystrixContextWrapper(Callable<V> delegate) {
        	this.threadData = ThreadContext.getThreadData();
            this.delegate = delegate;
        }

        @Override
        public V call() throws Exception {
        	Map<String, Object> existingStateData = ThreadContext.getThreadData();

            try {
                ThreadContext.setThreadData(this.threadData);
                return this.delegate.call();
            } finally {
            	ThreadContext.setThreadData(existingStateData);
            }
        }
    }
}
