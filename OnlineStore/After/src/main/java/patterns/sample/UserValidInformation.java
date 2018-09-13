package patterns.sample;

import lombok.Getter;

@Getter
public class UserValidInformation {
    private String token;
    private String userAccount;
    public UserValidInformation(String token, String userAccount){
        this.token = token;
        this.userAccount = userAccount;
    }
}
