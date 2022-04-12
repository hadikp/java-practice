package shop;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void inseertUser(String name, String email, String password) {
        jdbcTemplate.update("Insert into users(name, email, password) values (?,?,?)", name, email, password);
    }
}
