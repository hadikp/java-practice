package zaropot.message;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class MessageRepository {

    private JdbcTemplate jdbcTemplate;

    public MessageRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertMessage(Long senderId, Long receiverId, String message) {
        jdbcTemplate.update("Insert into messages(sender_id, receiver_id, message) values(?,?,?)", senderId, receiverId, message);
    }

    public List<String> findMessagesBySenderId(Long senderId) {
        return jdbcTemplate.query("Select * from messages where sender_id = ?",(rs, rowNum)
                -> rs.getString("message"), senderId);
    }


}
