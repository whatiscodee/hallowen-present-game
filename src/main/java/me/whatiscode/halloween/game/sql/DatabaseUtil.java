package me.whatiscode.halloween.game.sql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtil {
        private static HikariDataSource src;

    public static void importDatabase() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:mysql://mysql.joinserver.xyz:3306/s151004_SolarCloud");
        hikariConfig.setUsername("u151004_mr98SsbQSS");
        hikariConfig.setPassword("SfAuhRax3LOpFn^up@Z^EI!Z");
        hikariConfig.addDataSourceProperty("cachePrepStmts", true);
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", 250);
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        src = new HikariDataSource(hikariConfig);
    }

    public static Connection getBdConnection() throws SQLException {
        return src.getConnection();
    }
}

