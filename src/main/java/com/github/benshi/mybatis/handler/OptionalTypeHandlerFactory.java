package com.github.benshi.mybatis.handler;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import com.github.benshi.mybatis.handler.optional.OptionalBooleanHandler;
import com.github.benshi.mybatis.handler.optional.OptionalIntHandler;

/**
 * 
 * 
 * @date 2025年5月29日
 * @time 21:42:51
 * @description
 * 
 */
public class OptionalTypeHandlerFactory {
    private static volatile OptionalTypeHandlerFactory instance;
    private final Map<Class<?>, TypeHandler<?>> allTypeHandlersMap = new HashMap<>();

    private OptionalTypeHandlerFactory() {
        allTypeHandlersMap.put(Boolean.class, new OptionalBooleanHandler());
        allTypeHandlersMap.put(boolean.class, new OptionalBooleanHandler());
        allTypeHandlersMap.put(Integer.class, new OptionalIntHandler());
        allTypeHandlersMap.put(int.class, new OptionalIntHandler());
    }

    public static OptionalTypeHandlerFactory getInstance() {
        if (instance == null) {
            synchronized (OptionalTypeHandlerFactory.class) {
                if (instance == null) {
                    instance = new OptionalTypeHandlerFactory();
                }
            }
        }
        return instance;
    }
}
