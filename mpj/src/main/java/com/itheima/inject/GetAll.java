package com.itheima.inject;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.springframework.stereotype.Component;

@Component
public class GetAll extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sql = "select * from "+tableInfo.getTableName();
        SqlSource sqlSource = languageDriver.createSqlSource(configuration,sql,modelClass);
        return this.addSelectMappedStatementForTable(mapperClass, "getAll", sqlSource, tableInfo);
    }
}
