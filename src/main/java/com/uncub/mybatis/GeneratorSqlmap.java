package com.uncub.mybatis;

import ch.qos.logback.core.db.dialect.DBUtil;
import org.apache.commons.lang.StringUtils;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.codegen.ibatis2.IntrospectedTableIbatis2Java2Impl;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.PluginConfiguration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.BeanUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneratorSqlmap {
    String prefix = "T_";

    public void generator() throws Exception{

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //指向逆向工程配置文件
        File configFile = new File("D:\\ideaworkspace\\springboottest\\src\\main\\resources\\generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        Context context = config.getContexts().get(0);
        if (DbType.MySQL.getDriverClass().equals(context.getJdbcConnectionConfiguration().getDriverClass())) {
            PluginConfiguration pluginConfiguration = new PluginConfiguration();
            pluginConfiguration.addProperty("type", "com.uncub.mybatis.NamePlugin");
            pluginConfiguration.setConfigurationType("com.uncub.mybatis.NamePlugin");
            context.addPluginConfiguration(pluginConfiguration);

            pluginConfiguration = new PluginConfiguration();
            pluginConfiguration.addProperty("type", "com.uncub.mybatis.MethodPlugin");
            pluginConfiguration.setConfigurationType("com.uncub.mybatis.MethodPlugin");
            context.addPluginConfiguration(pluginConfiguration);

            pluginConfiguration = new PluginConfiguration();
            pluginConfiguration.addProperty("type", "com.uncub.mybatis.ExamplePlugin");
            pluginConfiguration.setConfigurationType("com.uncub.mybatis.ExamplePlugin");
            context.addPluginConfiguration(pluginConfiguration);


        }
        TableConfiguration tableConfiguration = null;
//        context.getTableConfigurations().add(tableConfiguration);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        TableConfiguration firstTableConfiguration = context.getTableConfigurations().get(0);
        firstTableConfiguration.addProperty("selectAllOrderByClause", "id desc");
        List<String> tables = DbUtil.getTableNames(context);
//        context.setTargetRuntime(MybatisIntrospectedTableMyBatis3Impl.class.getName());

        initAllTableConfigration(tables, firstTableConfiguration, context);
        myBatisGenerator.generate(null);

    }

    private void initAllTableConfigration(List<String> tables, TableConfiguration firstTableConfiguration, Context context) {
        List<TableConfiguration> tableConfigurations = new ArrayList<TableConfiguration>();
        for (final String tableName : tables){
            TableConfiguration tableConfiguration = new TableConfiguration(context);
            BeanUtils.copyProperties(firstTableConfiguration, tableConfiguration,"domainObjectName", "alias");

            String javaName = TableUtil.transTableName(tableName);
            tableConfiguration.setTableName(tableName);
            tableConfiguration.setDomainObjectName(javaName);
            if (tableName.startsWith("vw")){
                tableConfiguration.setCountByExampleStatementEnabled(false);
                tableConfiguration.setDeleteByExampleStatementEnabled(false);
                tableConfiguration.setDeleteByPrimaryKeyStatementEnabled(false);
                tableConfiguration.setUpdateByExampleStatementEnabled(false);
                tableConfiguration.setUpdateByPrimaryKeyStatementEnabled(false);
                tableConfiguration.setInsertStatementEnabled(false);
                tableConfiguration.setSelectByPrimaryKeyStatementEnabled(true);
                tableConfiguration.setSelectByExampleStatementEnabled(true);
            }
            if (!tableName.equals(firstTableConfiguration.getTableName()))
                context.addTableConfiguration(tableConfiguration);
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
            generatorSqlmap.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}