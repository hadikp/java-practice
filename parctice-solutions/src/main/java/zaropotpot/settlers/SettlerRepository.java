package zaropotpot.settlers;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class SettlerRepository {

    private JdbcTemplate jdbcTemplate;

    public SettlerRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public long saveNewSettler(Settler settler) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement("Insert into settlers(name_of_settler, amount_of_tobacco, expected_income) " +
                    "values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, settler.getNameOfSettler());
            ps.setLong(2, settler.getAmountOfTobacco());
            ps.setLong(3, settler.getExpectedIncome());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }

    public Settler findSettlerById(long id){
        return jdbcTemplate.queryForObject("Select * from settlers where id = ?", (rs, rowNum)
                -> new Settler(rs.getString("name_of_settler"), rs.getInt("amount_of_tobacco"),
                rs.getInt("expected_income")), id);
    }

    public void updateGrowthAndIncome(long id, int amount){
        jdbcTemplate.update("Update settlers set amount_of_tobacco = amount_of_tobacco - ?," +
                " expected_income = amount_of_tobacco * 500 where id = ?", amount, id);
    }


}
