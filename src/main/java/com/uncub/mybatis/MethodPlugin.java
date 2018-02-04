package com.uncub.mybatis;

import com.uncub.mybatis.generator.GeneratorHelp;
import org.apache.commons.lang.StringUtils;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Document;

import java.util.List;

public class MethodPlugin extends PluginAdapter {
    /**
     * This method is called after all the setXXX methods are called, but before
     * any other method is called. This allows the plugin to determine whether
     * it can run or not. For example, if the plugin requires certain properties
     * to be set, and the properties are not set, then the plugin is invalid and
     * will not run.
     *
     * @param warnings add strings to this list to specify warnings. For example, if
     *                 the plugin is invalid, you should specify why. Warnings are
     *                 reported to users after the completion of the run.
     * @return true if the plugin is in a valid state. Invalid plugins will not
     * be called
     */
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        document.getRootElement().addElement(GeneratorHelp.generatorQueryPagination(introspectedTable));
        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        if("1".equals(PropertiesUtils.get("isPagination")) && StringUtils.isNotBlank(PropertiesUtils.get("paginationClass"))){
            FullyQualifiedJavaType fullyQualifiedJavaType = new FullyQualifiedJavaType(PropertiesUtils.get("paginationClass"));
            interfaze.addImportedType(fullyQualifiedJavaType);
            Method method = GeneratorHelp.generatorQueryPaginationMthod(introspectedTable);
            interfaze.addMethod(method);
        }
        if("1".equals(PropertiesUtils.get("isQuery"))){
            Method method = GeneratorHelp.generatorQueryMthod(introspectedTable);
            interfaze.addMethod(method);
        }
        if (introspectedTable.getTableConfiguration().isSelectByExampleStatementEnabled()){
            //导入条件类
            FullyQualifiedJavaType fullyQualifiedJavaType = new FullyQualifiedJavaType(introspectedTable.getExampleType());
            interfaze.addImportedType(fullyQualifiedJavaType);
            Method method = GeneratorHelp.generatorQueryByConditonsPaginationMthod(introspectedTable);
            interfaze.addMethod(method);

        }
        return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
    }


}
