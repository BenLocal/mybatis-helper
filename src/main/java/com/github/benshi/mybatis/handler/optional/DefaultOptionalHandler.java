package com.github.benshi.mybatis.handler.optional;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * 
 * 
 * @date 2025年5月29日
 * @time 21:59:20
 * @description
 * 
 */
public class DefaultOptionalHandler<E> implements TypeHandler<Optional<E>> {

    private final TypeHandler<E> delegate;

    public DefaultOptionalHandler(TypeHandler<E> delegate) {
        this.delegate = delegate;
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, Optional<E> parameter, JdbcType jdbcType)
            throws SQLException {
        if (parameter == null) {
            delegate.setParameter(ps, i, null, jdbcType);
            return;
        }
        if (parameter.isPresent()) {
            delegate.setParameter(ps, i, parameter.get(), jdbcType);
        } else {
            delegate.setParameter(ps, i, null, jdbcType);
        }
    }

    @Override
    public Optional<E> getResult(ResultSet rs, String columnName) throws SQLException {
        E result = delegate.getResult(rs, columnName);
        return Optional.ofNullable(result);
    }

    @Override
    public Optional<E> getResult(ResultSet rs, int columnIndex) throws SQLException {
        E result = delegate.getResult(rs, columnIndex);
        return Optional.ofNullable(result);
    }

    @Override
    public Optional<E> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        E result = delegate.getResult(cs, columnIndex);
        return Optional.ofNullable(result);
    }

}
