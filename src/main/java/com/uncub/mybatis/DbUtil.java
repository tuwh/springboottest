package com.uncub.mybatis;

import org.mybatis.generator.api.ConnectionFactory;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.internal.JDBCConnectionFactory;
import org.mybatis.generator.internal.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owen on 6/12/16.
 */
public class DbUtil {

    private static final Logger _LOG = LoggerFactory.getLogger(DbUtil.class);
    private static final int DB_CONNECTION_TIMEOUTS_SECONDS = 1;

//    private static Map<DbType, Driver> drivers;

/*	static {
		drivers = new HashMap<>();
		List<String> driverJars = ConfigHelper.getAllJDBCDriverJarPaths();
		ClassLoader classloader = ClassloaderUtility.getCustomClassloader(driverJars);
		DbType[] dbTypes = DbType.values();
		for (DbType dbType : dbTypes) {
			try {
				Class clazz = Class.forName(dbType.getDriverClass(), true, classloader);
				Driver driver = (Driver) clazz.newInstance();
				_LOG.info("load driver class: {}", driver);
				drivers.put(dbType, driver);
			} catch (Exception e) {
				_LOG.error("load driver error");
			}
		}
	}*/

    /*public static Connection getConnection(DatabaseConfig config) throws ClassNotFoundException, SQLException {
        String url = getConnectionUrlWithSchema(config);
	    Properties props = new Properties();

	    props.setProperty("user", config.getUsername()); //$NON-NLS-1$
	    props.setProperty("password", config.getPassword()); //$NON-NLS-1$

		DriverManager.setLoginTimeout(DB_CONNECTION_TIMEOUTS_SECONDS);
	    Connection connection = drivers.get(DbType.valueOf(config.getDbType())).connect(url, props);
        _LOG.info("getConnection, connection url: {}", connection);
        return connection;
    }*/

	private static Connection getConnection(Context context) throws SQLException {
		ConnectionFactory connectionFactory;
		JDBCConnectionConfiguration jdbcConnectionConfiguration = context.getJdbcConnectionConfiguration();
		if (jdbcConnectionConfiguration != null) {
			connectionFactory = new JDBCConnectionFactory(jdbcConnectionConfiguration);
		} else {
			connectionFactory = ObjectFactory.createConnectionFactory(context);
		}
		return connectionFactory.getConnection();
	}

    public static List<String> getTableNames(Context context) throws Exception {
	    Connection connection = getConnection(context);
	    try {
		    List<String> tables = new ArrayList<>();
		    DatabaseMetaData md = connection.getMetaData();
		    ResultSet rs;
			String driverClass = context.getJdbcConnectionConfiguration().getDriverClass();
		    if (DbType.SQL_Server.getDriverClass().equals(driverClass)) {
			    String sql = "select name from sysobjects  where xtype='u' or xtype='v' ";
			    rs = connection.createStatement().executeQuery(sql);
			    while (rs.next()) {
				    tables.add(rs.getString("name"));
			    }
		    } else if (DbType.Oracle.getDriverClass().equals(driverClass)){
			    rs = md.getTables(null, context.getJdbcConnectionConfiguration().getUserId(), null, new String[] {"TABLE", "VIEW"});
				while (rs.next()) {
					tables.add(rs.getString("name"));
				}
		    } else if (DbType.Sqlite.getDriverClass().equals(driverClass)){
		    	String sql = "Select name from sqlite_master;";
			    rs = connection.createStatement().executeQuery(sql);
			    while (rs.next()) {
				    tables.add(rs.getString("name"));
			    }
		    }
		    /*else if (DbType.MySQL.getDriverClass().equals(driverClass)){
				String url = context.getJdbcConnectionConfiguration().getConnectionURL();
				String schema = getSchemeFromUrl(url);
				String sql = "select * from information_schema.tables where table_schema='testmysql' and table_type in('base table', 'view')";
				rs = connection.createStatement().executeQuery(sql);
			}*/
		    else {
			    // rs = md.getTables(null, config.getUsername().toUpperCase(), null, null);
				String url = context.getJdbcConnectionConfiguration().getConnectionURL();
				String schema = getSchemeFromUrl(url);
				rs = md.getTables(schema, null, "%", new String[] {"TABLE", "VIEW"});			//针对 postgresql 的左侧数据表显示
				while (rs.next()) {

					tables.add(rs.getString(3));
				}
		     }

		    return tables;
	    } finally {
	    	connection.close();
	    }
	}



    /*public static List<UITableColumnVO> getTableColumns(DatabaseConfig dbConfig, String tableName) throws Exception {
        String url = getConnectionUrlWithSchema(dbConfig);
        _LOG.info("getTableColumns, connection url: {}", url);
		Connection conn = getConnection(dbConfig);
		try {
			DatabaseMetaData md = conn.getMetaData();
			ResultSet rs = md.getColumns(null, null, tableName, null);
			List<UITableColumnVO> columns = new ArrayList<>();
			while (rs.next()) {
				UITableColumnVO columnVO = new UITableColumnVO();
				String columnName = rs.getString("COLUMN_NAME");
				columnVO.setColumnName(columnName);
				columnVO.setJdbcType(rs.getString("TYPE_NAME"));
				columns.add(columnVO);
			}
			return columns;
		} finally {
			conn.close();
		}
	}*/

    private static String getSchemeFromUrl(String url){
//		jdbc:mysql://192.168.126.128:3306/testmysql
    	String[] strs = url.replaceAll("//","").split("/");
		return strs[1];
	}


}
