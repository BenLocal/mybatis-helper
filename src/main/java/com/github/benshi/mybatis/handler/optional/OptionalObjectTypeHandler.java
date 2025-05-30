package com.github.benshi.mybatis.handler.optional;

import org.apache.ibatis.type.ObjectTypeHandler;

public class OptionalObjectTypeHandler extends DefaultOptionalHandler<Object> {

    public OptionalObjectTypeHandler() {
        super(new ObjectTypeHandler());
    }

}
