package com.github.benshi.mybatis.handler.optional;

/**
 * 
 * 
 * @date 2025年5月29日
 * @time 22:56:43
 * @author tangchuanyu
 * @description
 * 
 */
public class OptionalStringHandler extends DefaultOptionalHandler<String> {

    public OptionalStringHandler() {
        super(new org.apache.ibatis.type.StringTypeHandler());
    }
}
