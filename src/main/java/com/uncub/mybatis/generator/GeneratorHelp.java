package com.uncub.mybatis.generator;

import com.uncub.mybatis.MybatisStringUtils;
import com.uncub.mybatis.PropertiesUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class GeneratorHelp {

    public static XmlElement generatorQueryPagination(IntrospectedTable introspectedTable){
        XmlElement queryByPageElement = new XmlElement("select");
        queryByPageElement.addAttribute(new Attribute("id", getQueryPaginationName(introspectedTable)));
        queryByPageElement.addAttribute(new Attribute("resultMap", "BaseResultMap"));
        queryByPageElement.addAttribute(new Attribute("parameterType", introspectedTable.getContext().getJavaModelGeneratorConfiguration().getTargetPackage() + "." + introspectedTable.getTableConfiguration().getDomainObjectName()));
        queryByPageElement.addElement(new TextElement("select"));
        //引入查询内容
        XmlElement coloumnXmlElement = new XmlElement("include");
        coloumnXmlElement.addAttribute(new Attribute("refid", "Base_Column_List"));
        queryByPageElement.addElement(coloumnXmlElement);
        queryByPageElement.addElement(new TextElement("from " + introspectedTable.getTableConfiguration().getTableName()));

        XmlElement whereXmlElement = new XmlElement("trim");
        whereXmlElement.addAttribute(new Attribute("prefix", "where"));
        whereXmlElement.addAttribute(new Attribute("suffixOverrides", "and | or"));
        whereXmlElement.addElement(new TextElement("1 = 1 and"));
        for (IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()){
            XmlElement andElement = new XmlElement("if");
            if ("String".equals(introspectedColumn.getFullyQualifiedJavaType().getShortName()) &&
                    "java.lang".equals(introspectedColumn.getFullyQualifiedJavaType().getPackageName())
                    ){
                andElement.addAttribute(new Attribute("test", introspectedColumn.getJavaProperty() + " != null and " + introspectedColumn.getJavaProperty() + " != ''"));
            }
            else{
                andElement.addAttribute(new Attribute("test", introspectedColumn.getJavaProperty() + " != null "));
            }
            andElement.addElement(new TextElement(introspectedColumn.getActualColumnName() + " =#{" + introspectedColumn.getJavaProperty() + "} and"));
            whereXmlElement.addElement(andElement);
        }
        queryByPageElement.addElement(whereXmlElement);
        return  queryByPageElement;
    }

    public static XmlElement generatorQueryPaginationCount(IntrospectedTable introspectedTable){
        XmlElement queryByPageElement = new XmlElement("select");
        queryByPageElement.addAttribute(new Attribute("id", getQueryPaginationName(introspectedTable) + "COUNT"));
        queryByPageElement.addAttribute(new Attribute("resultType", "java.lang.Integer"));
        queryByPageElement.addAttribute(new Attribute("parameterType", introspectedTable.getContext().getJavaModelGeneratorConfiguration().getTargetPackage() + "." + introspectedTable.getTableConfiguration().getDomainObjectName()));
        queryByPageElement.addElement(new TextElement("select count(1)"));
        queryByPageElement.addElement(new TextElement("from " + introspectedTable.getTableConfiguration().getTableName()));

        XmlElement whereXmlElement = new XmlElement("trim");
        whereXmlElement.addAttribute(new Attribute("prefix", "where"));
        whereXmlElement.addAttribute(new Attribute("suffixOverrides", "and | or"));
        whereXmlElement.addElement(new TextElement("1 = 1 and"));
        for (IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()){
            XmlElement andElement = new XmlElement("if");
            if ("String".equals(introspectedColumn.getFullyQualifiedJavaType().getShortName()) &&
                    "java.lang".equals(introspectedColumn.getFullyQualifiedJavaType().getPackageName())
                    ){
                andElement.addAttribute(new Attribute("test", introspectedColumn.getJavaProperty() + " != null and " + introspectedColumn.getJavaProperty() + " != ''"));
            }
            else{
                andElement.addAttribute(new Attribute("test", introspectedColumn.getJavaProperty() + " != null "));
            }
            andElement.addElement(new TextElement(introspectedColumn.getActualColumnName() + " =#{" + introspectedColumn.getJavaProperty() + "} and"));
            whereXmlElement.addElement(andElement);
        }
        queryByPageElement.addElement(whereXmlElement);


        return  queryByPageElement;
    }

    public static void generatorQueryPaginationMethod(){

    }

    public static Method generatorQueryMthod(IntrospectedTable introspectedTable) {
        Method method = new Method();
        method.setName("query" + introspectedTable.getTableConfiguration().getDomainObjectName());
        FullyQualifiedJavaType fullyQualifiedJavaTypeReturn = new FullyQualifiedJavaType("java.util.List<" + introspectedTable.getTableConfiguration().getDomainObjectName() + ">");
        method.setReturnType(fullyQualifiedJavaTypeReturn);
        FullyQualifiedJavaType pramFullyQualifiedJavaType = new FullyQualifiedJavaType(introspectedTable.getTableConfiguration().getDomainObjectName());
        method.addParameter(new Parameter(pramFullyQualifiedJavaType, MybatisStringUtils.lowerCaseFirstChar(introspectedTable.getTableConfiguration().getDomainObjectName())));
        method.addJavaDocLine("/**");
        method.addJavaDocLine("* 根据所有不为空条件进行查询，不分页");
        method.addJavaDocLine("*/");
        return method;
    }

    public static Method generatorQueryPaginationMthod(IntrospectedTable introspectedTable) {
        Method method = new Method();
        method.setName("query" + introspectedTable.getTableConfiguration().getDomainObjectName());
        FullyQualifiedJavaType fullyQualifiedJavaTypeReturn = new FullyQualifiedJavaType("java.util.List<" + introspectedTable.getTableConfiguration().getDomainObjectName() + ">");
        method.setReturnType(fullyQualifiedJavaTypeReturn);
        FullyQualifiedJavaType pramFullyQualifiedJavaType = new FullyQualifiedJavaType(introspectedTable.getTableConfiguration().getDomainObjectName());
        method.addParameter(new Parameter(pramFullyQualifiedJavaType, MybatisStringUtils.lowerCaseFirstChar(introspectedTable.getTableConfiguration().getDomainObjectName())));
        FullyQualifiedJavaType pageinationFullyQualifiedJavaType = new FullyQualifiedJavaType(PropertiesUtils.get("paginationClass"));
        method.addParameter(new Parameter(pageinationFullyQualifiedJavaType, "pagination"));
        method.addJavaDocLine("/**");
        method.addJavaDocLine("* 根据所有不为空条件进行查询，分页。结果将传入@Param pagination 参数中");
        method.addJavaDocLine("*/");
        return method;
    }

    public static Method generatorQueryByConditonsPaginationMthod(IntrospectedTable introspectedTable) {
        Method method = new Method();
        method.setName("query" + introspectedTable.getTableConfiguration().getDomainObjectName() + "ByConditions");
        FullyQualifiedJavaType fullyQualifiedJavaTypeReturn = new FullyQualifiedJavaType("java.util.List<" + introspectedTable.getTableConfiguration().getDomainObjectName() + ">");
        method.setReturnType(fullyQualifiedJavaTypeReturn);
        FullyQualifiedJavaType pramFullyQualifiedJavaType = new FullyQualifiedJavaType(introspectedTable.getExampleType());
        method.addParameter(new Parameter(pramFullyQualifiedJavaType, MybatisStringUtils.lowerCaseFirstChar(pramFullyQualifiedJavaType.getShortName())));
        FullyQualifiedJavaType pageinationFullyQualifiedJavaType = new FullyQualifiedJavaType(PropertiesUtils.get("paginationClass"));
        method.addParameter(new Parameter(pageinationFullyQualifiedJavaType, "pagination"));
        method.addJavaDocLine("/**");
        method.addJavaDocLine("* 根据所有不为空条件进行查询，分页。结果将传入@Param pagination 参数中");
        method.addJavaDocLine("*/");
        return method;
    }





    private static String getQueryPaginationName(IntrospectedTable introspectedTable){
        return new StringBuffer("query") + MybatisStringUtils.upperCaseFirstChar(introspectedTable.getTableConfiguration().getDomainObjectName());
    }
}
