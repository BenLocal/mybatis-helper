package com.github.benshi.mybatis.handler.optional;

/**
 * 
 * 
 * @date 2025年5月29日
 * @time 22:59:14
 * @author tangchuanyu
 * @description
 * 
 */
public class OptionalLocalDateTimeHandler extends DefaultOptionalHandler<java.time.LocalDateTime> {

    public OptionalLocalDateTimeHandler() {
        super(new org.apache.ibatis.type.LocalDateTimeTypeHandler());
    }
}
