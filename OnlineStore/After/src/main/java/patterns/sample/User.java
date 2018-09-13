package patterns.sample;

import lombok.Getter;

@Getter
public class User {
    private final String userName;
    private final String email;

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
