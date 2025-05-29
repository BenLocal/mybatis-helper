package com.github.benshi.mybatis.handler;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.type.ObjectTypeHandler;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
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
    private static volatile OptionalTypeHandlerFactory instance;
    private final Map<Class<?>, Class<? extends TypeHandler<?>>> allTypeHandlersMap = new HashMap<>();
    // private final TypeHandlerRegistry typeHandlerRegistry = new
    // TypeHandlerRegistry();

    private final Class<? extends TypeHandler<?>> defTypeHandler;

    private OptionalTypeHandlerFactory() {
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

    public Class<? extends TypeHandler<?>> getTypeHandlerClazz(String type) {
        try {
            return getTypeHandlerClazz(Class.forName(type));
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("No TypeHandler found for type: " + type);
        }
    }

    public Class<? extends TypeHandler<?>> getTypeHandlerClazz(Class<?> type) {
        Class<? extends TypeHandler<?>> typeHandler = allTypeHandlersMap.get(type);
        // if (typeHandler == null) {
        // typeHandler = typeHandlerRegistry.getTypeHandler(type);
        // }
        if (typeHandler == null) {
            return defTypeHandler;
        }
        return typeHandler;
    }
}
