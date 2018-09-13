package patterns;

import lombok.Getter;

@Getter
public class BasicResponse<TContent> {

    private Boolean success;
    private TContent content;
    private String exception;

    public BasicResponse(Boolean success){
        this.success = success;
    }

    public BasicResponse(TContent content){
        this.content = content;
        this.success = true;
    }

    public BasicResponse(Exception exception) {
        this.exception = exception.getMessage();
        this.success = false;
    }

}
