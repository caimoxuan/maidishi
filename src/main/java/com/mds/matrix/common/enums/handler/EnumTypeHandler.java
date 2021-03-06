package com.mds.matrix.common.enums.handler;

import com.mds.matrix.common.enums.CarStatus;
import com.mds.matrix.common.enums.MarkType;
import com.mds.matrix.common.enums.UserType;
import org.apache.ibatis.type.MappedTypes;

/**
 * @author cmx
 * @Date 2019/4/30 23:19
 */

@MappedTypes(value = {UserType.class, MarkType.class, CarStatus.class})
public class EnumTypeHandler extends BaseEnumTypeHandler {
    public EnumTypeHandler(Class<EnumInf> type) {
        super(type);
    }
}