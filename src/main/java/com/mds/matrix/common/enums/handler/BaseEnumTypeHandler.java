package com.mds.matrix.common.enums.handler;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author cmx
 * @Date 2019/4/30 23:07
 */

public class BaseEnumTypeHandler extends BaseTypeHandler<EnumInf> {

    private Class<EnumInf> type;

    public BaseEnumTypeHandler(){}

    public BaseEnumTypeHandler(Class<EnumInf> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, EnumInf parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    @Override
    public EnumInf getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return convert(rs.getInt(columnName));
    }

    @Override
    public EnumInf getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return convert(rs.getInt(columnIndex));
    }

    @Override
    public EnumInf getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return convert(cs.getInt(columnIndex));
    }

    private EnumInf convert(int status){
        EnumInf[] objs = type.getEnumConstants();
        for(EnumInf em: objs){
            if(em.getCode() == status){
                return  em;
            }
        }
        return null;
    }
}
