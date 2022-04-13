package shop;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {


    public static void main(String[] args) {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/shop?useUnicode=true");
            dataSource.setUser("shops");
            dataSource.setPassword("shops");
        } catch (SQLException sqe) {
            throw new IllegalStateException("Cannot reach DataBase!", sqe);
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        //flyway.clean();
        flyway.migrate();

        OrderDao orderDao = new OrderDao(dataSource);
        orderDao.insertOrder(11, LocalDate.of(2022, 02, 11));

    }
}
