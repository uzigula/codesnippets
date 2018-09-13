package patterns.sample;

import lombok.Getter;
import patterns.BasicResponse;
import patterns.IAmCommand;

@Getter
public class CreateUser implements IAmCommand<BasicResponse<User>> {
    private final String userName;
    private final String email;

    public CreateUser(String username, String email) {
        this.userName = username;
        this.email = email;

    }
}
