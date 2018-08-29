package patterns.sample;

import lombok.Getter;
import patterns.BasicResponse;
import patterns.IAmCommand;

@Getter
public class ValidateUser implements  IAmCommand<BasicResponse<UserValidInformation>>  {
    private String userName;
    public ValidateUser(String userName){
        this.userName = userName;
    }
}
