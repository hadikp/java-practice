package zaropot.message;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

public class MessageService {

    private UserRepository userRepository;
    private MessageRepository messageRepository;

    public MessageService(UserRepository userRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    public void registerUser(String username) {
        Optional<User> user = userRepository.findUserByName(username);
        if(!user.isEmpty()) {
            throw new IllegalArgumentException("Username is already taken: " + username);
        }
        userRepository.insertUser(username);
    }

    public void sendMessage(User sender, User receiver, String message) {
        Optional<User> s = userRepository.findUserByName(sender.getUserName());
        Optional<User> r = userRepository.findUserByName(receiver.getUserName());

        if(s.isPresent() && r.isPresent()) {
            messageRepository.insertMessage(s.get().getId(), r.get().getId(), message);
        } else {
            throw new IllegalArgumentException("Sender or receiver not found!");
        }
    }
}
