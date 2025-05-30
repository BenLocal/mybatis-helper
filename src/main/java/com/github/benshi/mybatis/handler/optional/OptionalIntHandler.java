package com.github.benshi.mybatis.handler.optional;

import org.apache.ibatis.type.IntegerTypeHandler;

/**
 * 
 * 
 * @date 2025年5月29日
 * @time 21:44:00
 * @description
 * 
 */
public class OptionalIntHandler extends DefaultOptionalHandler<Integer> {
    public OptionalIntHandler() {
        super(new IntegerTypeHandler());
    }
}
