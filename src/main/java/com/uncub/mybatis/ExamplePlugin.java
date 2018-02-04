package com.uncub.mybatis;

import com.alibaba.druid.sql.visitor.functions.Trim;
import org.apache.commons.lang.StringUtils;
import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

public class ExamplePlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean clientSelectByExampleWithBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
//        String javaName = introspectedTable.getTableConfiguration().getDomainObjectName();
//        method.setName("query" + MybatisStringUtils.upperCaseFirstChar(javaName) + "ByConditions");
//        method.addJavaDocLine("/**");
//        method.addJavaDocLine("* 根据主键进行查找");
//        method.addJavaDocLine("* @Param " + MybatisStringUtils.lowerCaseFirstChar(javaName));
//        method.addJavaDocLine("* @auth tuwh");
//        method.addJavaDocLine("*/" );
        return false;
    }

    @Override
    public boolean clientSelectByExampleWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String javaName = introspectedTable.getTableConfiguration().getDomainObjectName();
        method.setName("query" + MybatisStringUtils.upperCaseFirstChar(javaName) + "ByConditions");
        method.addJavaDocLine("/**");
        method.addJavaDocLine("* 根据查询条件进行查找");
        method.addJavaDocLine("* @Param " + MybatisStringUtils.lowerCaseFirstChar(javaName));
        method.addJavaDocLine("* @auth tuwh");
        method.addJavaDocLine("*/" );
        return super.clientSelectByExampleWithBLOBsMethodGenerated(method, topLevelClass, introspectedTable);
    }

    @Override
    public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        String javaName = introspectedTable.getTableConfiguration().getDomainObjectName();
        //参数重命名
        Parameter parameter = new Parameter(method.getParameters().get(0).getType(), MybatisStringUtils.lowerCaseFirstChar(method.getParameters().get(0).getType().getShortName()));
        method.getParameters().remove(0);
        method.getParameters().add(parameter);
        method.setName("query" + MybatisStringUtils.upperCaseFirstChar(javaName) + "ByConditions");
        method.addJavaDocLine("/**");
        method.addJavaDocLine("* 根据查询条件进行查找");
        method.addJavaDocLine("* @Param " + MybatisStringUtils.lowerCaseFirstChar(javaName));
        method.addJavaDocLine("* @auth tuwh");
        method.addJavaDocLine("*/" );
        return super.clientSelectByExampleWithoutBLOBsMethodGenerated(method, interfaze, introspectedTable);
    }

    @Override
    public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String javaName = introspectedTable.getTableConfiguration().getDomainObjectName();
        method.setName("query" + MybatisStringUtils.upperCaseFirstChar(javaName) + "ByConditions");
        method.addJavaDocLine("/**");
        method.addJavaDocLine("* 根据查询条件进行查找");
        method.addJavaDocLine("* @Param " + MybatisStringUtils.lowerCaseFirstChar(javaName));
        method.addJavaDocLine("* @auth tuwh");
        method.addJavaDocLine("*/" );
        return super.clientSelectByExampleWithoutBLOBsMethodGenerated(method, topLevelClass, introspectedTable);
    }

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
    }

    @Override
    public boolean sqlMapExampleWhereClauseElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return super.sqlMapExampleWhereClauseElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String javaName = introspectedTable.getTableConfiguration().getDomainObjectName();
        String id = "query" + MybatisStringUtils.upperCaseFirstChar(javaName) + "ByConditions";
        Attribute attributeNew = new Attribute("id", id);
        element.getAttributes().remove(0);
        element.getAttributes().add(attributeNew);
        return super.sqlMapSelectByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        /*String javaName = introspectedTable.getTableConfiguration().getDomainObjectName();
        String id = "query" + MybatisStringUtils.upperCaseFirstChar(javaName) + "ByConditions";
        Attribute attributeNew = new Attribute("id", id);
        element.getAttributes().remove(0);
        element.getAttributes().add(attributeNew);*/
        return false;
    }

    @Override
    public void initialized(IntrospectedTable introspectedTable) {
        String packageName;
        if (StringUtils.isNotBlank(PropertiesUtils.get("conditionsPakage"))){
            packageName = PropertiesUtils.get("conditionsPakage");
        }
        else{
            packageName = introspectedTable.getContext().getJavaClientGeneratorConfiguration().getTargetPackage();
        }
        String newClassName = introspectedTable.getTableConfiguration().getDomainObjectName() + ".condition";
        if (StringUtils.isNotBlank(PropertiesUtils.get("conditionClassSuffix"))){
            newClassName = introspectedTable.getTableConfiguration().getDomainObjectName() + PropertiesUtils.get("conditionClassSuffix");
        }
        introspectedTable.setExampleType(packageName + "." + newClassName);
        super.initialized(introspectedTable);
    }
}
