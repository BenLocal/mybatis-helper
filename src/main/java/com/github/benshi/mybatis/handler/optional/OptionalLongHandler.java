package com.github.benshi.mybatis.handler.optional;

/**
 * 
 * 
 * @date 2025年5月29日
 * @time 22:57:53
 * @description
 * 
 */
public class OptionalLongHandler extends DefaultOptionalHandler<Long> {

    public OptionalLongHandler() {
        super(new org.apache.ibatis.type.LongTypeHandler());
    }
}
