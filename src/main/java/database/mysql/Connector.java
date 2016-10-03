package database.mysql;

import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import java.sql.*;

public class Connector {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:8081/clouderdb";
    private static final String USER = "root";
    private static final String PASS = "1234";
    private static ResultSet resultSet;
    private static Statement statement;
    private static Connection connection;
    private static final Logger LOGGER = Logger.getLogger(Connector.class.getName());
    private static PoolProperties poolProperties = new PoolProperties();
    private static DataSource datasource;


    private Connector(){}
    public static void execute(String sql) throws SQLException {
        connection = datasource.getConnection();
        connection.createStatement().execute(sql);
        close();
    }

    public static ResultSet getSet(String sql) throws SQLException {
        connection = datasource.getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    static {
        try {
            Class.forName(DRIVER);
            Connector.setPoolProperties();
            LOGGER.info("DB init successful");
        } catch (Exception exc){
            LOGGER.info("DB init fail:" + exc);
        }
    }

    public static void setPoolProperties(){
        poolProperties.setUrl(URL);
        poolProperties.setDriverClassName(DRIVER);
        poolProperties.setUsername(USER);
        poolProperties.setPassword(PASS);
        poolProperties.setJmxEnabled(true);
        poolProperties.setTestWhileIdle(false);
        poolProperties.setTestOnBorrow(true);
        poolProperties.setValidationQuery("SELECT 1");
        poolProperties.setTestOnReturn(false);
        poolProperties.setValidationInterval(30000);
        poolProperties.setTimeBetweenEvictionRunsMillis(30000);
        poolProperties.setMaxActive(25);
        poolProperties.setInitialSize(1);
        poolProperties.setMaxWait(10000);
        poolProperties.setRemoveAbandonedTimeout(60);
        poolProperties.setMinEvictableIdleTimeMillis(30000);
        poolProperties.setMinIdle(1);
        poolProperties.setMaxIdle(10);
        poolProperties.setLogAbandoned(true);
        poolProperties.setRemoveAbandoned(true);
        poolProperties.setJdbcInterceptors(
                "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
                        "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        datasource = new DataSource();
        datasource.setPoolProperties(poolProperties);
    }

    public static void close() {
        try {
            if(resultSet != null)
                resultSet.close();
            if(statement != null)
                statement.close();
            if(connection != null)
                connection.close();
        } catch (SQLException exc) {
            LOGGER.error("DB close error: " + exc);
        }
    }
}
