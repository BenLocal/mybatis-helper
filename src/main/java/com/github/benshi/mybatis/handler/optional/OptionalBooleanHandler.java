package com.github.benshi.mybatis.handler.optional;

import org.apache.ibatis.type.BooleanTypeHandler;

/**
 * 
 * 
 * @date 2025年5月29日
 * @time 22:24:56
 * @description
 * 
 */
public class OptionalBooleanHandler extends DefaultOptionalHandler<Boolean> {
    public OptionalBooleanHandler() {
        super(new BooleanTypeHandler());
    }
}
