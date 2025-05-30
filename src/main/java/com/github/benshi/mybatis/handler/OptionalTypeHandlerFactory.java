package com.github.benshi.mybatis.handler;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.type.ObjectTypeHandler;
import org.apache.ibatis.type.TypeHandler;

import com.github.benshi.mybatis.handler.optional.OptionalBooleanHandler;
import com.github.benshi.mybatis.handler.optional.OptionalIntHandler;
import com.github.benshi.mybatis.handler.optional.OptionalLocalDateTimeHandler;
import com.github.benshi.mybatis.handler.optional.OptionalLongHandler;
import com.github.benshi.mybatis.handler.optional.OptionalStringHandler;

/**
 * 
 * 
 * @date 2025年5月29日
 * @time 21:42:51
 * @description
 * 
 */
public class OptionalTypeHandlerFactory {
    private static final Map<Class<?>, Class<? extends TypeHandler<?>>> allTypeHandlersMap = new HashMap<>();
    private static final Class<? extends TypeHandler<?>> defTypeHandler;

    static {
        // Default type handler for unsupported types
        defTypeHandler = ObjectTypeHandler.class;

        allTypeHandlersMap.put(Boolean.class, OptionalBooleanHandler.class);
        allTypeHandlersMap.put(boolean.class, OptionalBooleanHandler.class);
        allTypeHandlersMap.put(Integer.class, OptionalIntHandler.class);
        allTypeHandlersMap.put(int.class, OptionalIntHandler.class);
        allTypeHandlersMap.put(Long.class, OptionalLongHandler.class);
        allTypeHandlersMap.put(long.class, OptionalLongHandler.class);
        allTypeHandlersMap.put(String.class, OptionalStringHandler.class);
        allTypeHandlersMap.put(java.time.LocalDateTime.class,
                OptionalLocalDateTimeHandler.class);
    }

    // Private constructor to prevent instantiation
    private OptionalTypeHandlerFactory() {
        // No instantiation allowed
    }

    public Class<? extends TypeHandler<?>> getTypeHandlerClazz(String type) {
        try {
            return getTypeHandlerClazz(Class.forName(type));
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("No TypeHandler found for type: " + type);
        }
    }

    public static Class<? extends TypeHandler<?>> getTypeHandlerClazz(Class<?> type) {
        Class<? extends TypeHandler<?>> typeHandler = allTypeHandlersMap.get(type);
        if (typeHandler == null) {
            return defTypeHandler;
        }
        return typeHandler;
    }
}
