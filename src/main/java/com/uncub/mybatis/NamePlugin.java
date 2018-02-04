package com.uncub.mybatis;

import org.apache.commons.lang.StringUtils;
import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

public class NamePlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }



    @Override
    public boolean sqlMapSelectByPrimaryKeyElementGenerated(XmlElement element,
                                                            IntrospectedTable introspectedTable) {
        String javaName = introspectedTable.getTableConfiguration().getDomainObjectName();
        String primaryName = introspectedTable.getPrimaryKeyColumns().get(0).getJavaProperty();
        String id = "select" + MybatisStringUtils.upperCaseFirstChar(javaName) + "By" + MybatisStringUtils.upperCaseFirstChar(primaryName);
        Attribute attributeNew = new Attribute("id", id);
        element.getAttributes().remove(0);
        element.getAttributes().add(attributeNew);
        return true;
    }

    @Override
    public boolean clientInsertMethodGenerated(Method method, Interface interfaze,
                                               IntrospectedTable introspectedTable) {
        String javaName = introspectedTable.getTableConfiguration().getDomainObjectName();
        method.setName("inset");
        method.addJavaDocLine("/**");
        method.addJavaDocLine("* 根据主键进行新增,插入所有字段");
        method.addJavaDocLine("* @Param " + MybatisStringUtils.lowerCaseFirstChar(javaName));
        method.addJavaDocLine("*/" );
        Parameter parameter = method.getParameters().get(0);
        Parameter reNameParameter = new Parameter(parameter.getType(), MybatisStringUtils.lowerCaseFirstChar(javaName));
        method.getParameters().remove(0);
        method.getParameters().add(reNameParameter);
        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze,
                                   TopLevelClass topLevelClass,
                                   IntrospectedTable introspectedTable) {
        interfaze.addAnnotation("@MapperScan");
        FullyQualifiedJavaType fullyQualifiedJavaType = new FullyQualifiedJavaType("org.mybatis.spring.annotation.MapperScan");
        interfaze.addImportedType(fullyQualifiedJavaType);
        return true;
    }

    @Override
    public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        String javaName = introspectedTable.getTableConfiguration().getDomainObjectName();
        String primaryName = introspectedTable.getPrimaryKeyColumns().get(0).getJavaProperty();
        method.setName("delete" + MybatisStringUtils.upperCaseFirstChar(javaName) + "By" + MybatisStringUtils.upperCaseFirstChar(primaryName));
        method.addJavaDocLine("/**");
        method.addJavaDocLine("* 根据主键进行删除");
        method.addJavaDocLine("* @Param " + MybatisStringUtils.lowerCaseFirstChar(primaryName));
        method.addJavaDocLine("* @auth tuwh");
        method.addJavaDocLine("*/" );
        return super.clientDeleteByPrimaryKeyMethodGenerated(method, interfaze, introspectedTable);
    }

    @Override
    public boolean clientInsertMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String javaName = introspectedTable.getTableConfiguration().getDomainObjectName();
        method.setName("inset");
        method.addJavaDocLine("/**");
        method.addJavaDocLine("* 新增数据");
        method.addJavaDocLine("* @Param " + MybatisStringUtils.lowerCaseFirstChar(javaName));
        method.addJavaDocLine("*/" );
        Parameter parameter = method.getParameters().get(0);
        Parameter reNameParameter = new Parameter(parameter.getType(), MybatisStringUtils.lowerCaseFirstChar(javaName));
        method.getParameters().remove(0);
        method.getParameters().add(reNameParameter);
        return super.clientInsertMethodGenerated(method, topLevelClass, introspectedTable);
    }

    @Override
    /**
     * 修改生成的查询方法名称
     */
    public boolean clientSelectByPrimaryKeyMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        String javaName = introspectedTable.getTableConfiguration().getDomainObjectName();
        String primaryName = introspectedTable.getPrimaryKeyColumns().get(0).getJavaProperty();
        method.setName("select" + MybatisStringUtils.upperCaseFirstChar(javaName) + "By" + MybatisStringUtils.upperCaseFirstChar(primaryName));
        method.addJavaDocLine("/**");
        method.addJavaDocLine("* 根据主键进行查找");
        method.addJavaDocLine("* @Param " + MybatisStringUtils.lowerCaseFirstChar(javaName));
        method.addJavaDocLine("* @auth tuwh");
        method.addJavaDocLine("*/" );
        return super.clientSelectByPrimaryKeyMethodGenerated(method, interfaze, introspectedTable);
    }

    @Override
    /**
     * 不调用
     */
    public boolean clientSelectByPrimaryKeyMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String javaName = introspectedTable.getTableConfiguration().getDomainObjectName();
        String primaryName = introspectedTable.getPrimaryKeyColumns().get(0).getJavaProperty();
        return super.clientSelectByPrimaryKeyMethodGenerated(method, topLevelClass, introspectedTable);
    }



    @Override
    public boolean clientUpdateByPrimaryKeySelectiveMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        String javaName = introspectedTable.getTableConfiguration().getDomainObjectName();
        String primaryName = introspectedTable.getPrimaryKeyColumns().get(0).getJavaProperty();
        method.setName("update" + MybatisStringUtils.upperCaseFirstChar(javaName) + "By" + MybatisStringUtils.upperCaseFirstChar(primaryName) + "Selective");
        method.addJavaDocLine("/**");
        method.addJavaDocLine("* 根据主键进行更新，仅更新非主空字段");
        method.addJavaDocLine("* @Param " + MybatisStringUtils.lowerCaseFirstChar(javaName));
        method.addJavaDocLine("*/" );
        Parameter parameter = method.getParameters().get(0);
        Parameter reNameParameter = new Parameter(parameter.getType(), MybatisStringUtils.lowerCaseFirstChar(javaName));
        method.getParameters().remove(0);
        method.getParameters().add(reNameParameter);
        return super.clientUpdateByPrimaryKeySelectiveMethodGenerated(method, interfaze, introspectedTable);
    }

    @Override
    public boolean clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        return super.clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(method, interfaze, introspectedTable);
    }

    @Override
    public boolean clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return super.clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(method, topLevelClass, introspectedTable);
    }

    @Override
    public boolean clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        String javaName = introspectedTable.getTableConfiguration().getDomainObjectName();
        String primaryName = introspectedTable.getPrimaryKeyColumns().get(0).getJavaProperty();
        method.setName("update" + MybatisStringUtils.upperCaseFirstChar(javaName) + "By" + MybatisStringUtils.upperCaseFirstChar(primaryName));
        method.addJavaDocLine("/**");
        method.addJavaDocLine("* 根据主键进行更新，更新所有字段");
        method.addJavaDocLine("* @Param " + MybatisStringUtils.lowerCaseFirstChar(javaName));
        method.addJavaDocLine("*/" );
        Parameter parameter = method.getParameters().get(0);
        Parameter reNameParameter = new Parameter(parameter.getType(), MybatisStringUtils.lowerCaseFirstChar(javaName));
        method.getParameters().remove(0);
        method.getParameters().add(reNameParameter);
        return super.clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(method, interfaze, introspectedTable);
    }

    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        if (StringUtils.isNotBlank(introspectedColumn.getRemarks())){
            field.addAnnotation("/**");
            field.addAnnotation("* " + introspectedColumn.getRemarks());
            field.addAnnotation("*/");
        }
        return super.modelFieldGenerated(field, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return super.modelGetterMethodGenerated(method, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }

    @Override
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return super.modelPrimaryKeyClassGenerated(topLevelClass, introspectedTable);
    }

    @Override
    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return super.modelRecordWithBLOBsClassGenerated(topLevelClass, introspectedTable);
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return super.modelSetterMethodGenerated(method, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
                                                 IntrospectedTable introspectedTable) {
        if (StringUtils.isNotBlank(introspectedTable.getRemarks())){
            topLevelClass.addAnnotation("/**");
            topLevelClass.addAnnotation("* " + introspectedTable.getRemarks());
            topLevelClass.addAnnotation("/**");
        }
        return true;
    }

    @Override
    public boolean sqlMapResultMapWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return super.sqlMapResultMapWithoutBLOBsElementGenerated(element, introspectedTable);
    }



    @Override
    public boolean sqlMapDeleteByPrimaryKeyElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String javaName = introspectedTable.getTableConfiguration().getDomainObjectName();
        String primaryName = introspectedTable.getPrimaryKeyColumns().get(0).getJavaProperty();
        String id = "delete" + MybatisStringUtils.upperCaseFirstChar(javaName) + "By" + MybatisStringUtils.upperCaseFirstChar(primaryName);
        Attribute attributeNew = new Attribute("id", id);
        element.getAttributes().remove(0);
        element.getAttributes().add(attributeNew);
        return super.sqlMapDeleteByPrimaryKeyElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        return super.sqlMapGenerated(sqlMap, introspectedTable);
    }

    @Override
    public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return super.sqlMapInsertElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapResultMapWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return super.sqlMapResultMapWithBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapUpdateByPrimaryKeySelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String javaName = introspectedTable.getTableConfiguration().getDomainObjectName();
        String primaryName = introspectedTable.getPrimaryKeyColumns().get(0).getJavaProperty();
        String id = "update" + MybatisStringUtils.upperCaseFirstChar(javaName) + "By" + MybatisStringUtils.upperCaseFirstChar(primaryName) + "Selective";
        Attribute attributeNew = new Attribute("id", id);
        element.getAttributes().remove(0);
        element.getAttributes().add(attributeNew);
        return super.sqlMapUpdateByPrimaryKeySelectiveElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapUpdateByPrimaryKeyWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return super.sqlMapUpdateByPrimaryKeyWithBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String javaName = introspectedTable.getTableConfiguration().getDomainObjectName();
        String primaryName = introspectedTable.getPrimaryKeyColumns().get(0).getJavaProperty();
        String id = "update" + MybatisStringUtils.upperCaseFirstChar(javaName) + "By" + MybatisStringUtils.upperCaseFirstChar(primaryName);
        Attribute attributeNew = new Attribute("id", id);
        element.getAttributes().remove(0);
        element.getAttributes().add(attributeNew);
        return super.sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return super.sqlMapInsertSelectiveElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean clientInsertSelectiveMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        String javaName = introspectedTable.getTableConfiguration().getDomainObjectName();
        method.setName("insetSelective");
        method.addJavaDocLine("/**");
        method.addJavaDocLine("* 根据主键进行新增,插入非空字段");
        method.addJavaDocLine("* @Param " + MybatisStringUtils.lowerCaseFirstChar(javaName));
        method.addJavaDocLine("*/" );
        Parameter parameter = method.getParameters().get(0);
        Parameter reNameParameter = new Parameter(parameter.getType(), MybatisStringUtils.lowerCaseFirstChar(javaName));
        method.getParameters().remove(0);
        method.getParameters().add(reNameParameter);
        return super.clientInsertSelectiveMethodGenerated(method, interfaze, introspectedTable);
    }

    @Override
    public void initialized(IntrospectedTable introspectedTable) {
        super.initialized(introspectedTable);
    }

    @Override
    public boolean sqlMapBaseColumnListElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return super.sqlMapBaseColumnListElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapBlobColumnListElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return super.sqlMapBlobColumnListElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean clientSelectAllMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        return super.clientSelectAllMethodGenerated(method, interfaze, introspectedTable);
    }

    @Override
    public boolean clientSelectAllMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return super.clientSelectAllMethodGenerated(method, topLevelClass, introspectedTable);
    }

    @Override
    public boolean sqlMapSelectAllElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return super.sqlMapSelectAllElementGenerated(element, introspectedTable);
    }


}
