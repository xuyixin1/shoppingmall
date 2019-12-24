package com.vicmob.shoppingmall.global;


import com.vicmob.shoppingmall.constant.BaseEnum;
import com.vicmob.shoppingmall.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class EnumValueTypeHandler<E extends BaseEnum> extends BaseTypeHandler<E> {

    private Class<E> type;

    private final E[] enums;

    public EnumValueTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
        this.enums = type.getEnumConstants();
        if (this.enums == null) {
            log.error(type.getSimpleName() + " does not represent an enum type.");
            throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum type.");
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter.getMybatisValue());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Object o = rs.getObject(columnName);
        if (o == null) {
            return null;
        } else {
            try {
                return getEnumByValue(o);
            } catch (Exception ex) {
                log.error(ex.getMessage(),ex);
                throw new IllegalArgumentException(
                        "Cannot convert " + o + " to " + type.getSimpleName() + " by ordinal value.", ex);
            }
        }
    }

    /**
     * 通过枚举类型的int值，获取到对应的枚举类型
     * @author xyx
     * @param o
     */
    protected E getEnumByValue(Object o) {
        for (E e : enums) {
            if (e.getMybatisValue() == o) {
                return e;
            }
        }
        return null;
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Object o = rs.getObject(columnIndex);
        if (o == null) {
            return null;
        } else {
            try {
                return getEnumByValue(o);
            } catch (Exception ex) {
                log.error(ex.getMessage(),ex);
                throw new IllegalArgumentException(
                        "Cannot convert " + o + " to " + type.getSimpleName() + " by ordinal value.", ex);
            }
        }
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Object o = cs.getObject(columnIndex);
        if (o == null) {
            return null;
        } else {
            try {
                return getEnumByValue(o);
            } catch (Exception ex) {
                log.error(ex.getMessage(),ex);
                throw new IllegalArgumentException(
                        "Cannot convert " + o + " to " + type.getSimpleName() + " by ordinal value.", ex);
            }
        }
    }

}