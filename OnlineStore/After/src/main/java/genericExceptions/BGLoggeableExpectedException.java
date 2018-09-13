package genericExceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class BGLoggeableExpectedException extends BGExpectedException {
    protected Object Content;


    public BGLoggeableExpectedException(String message, Exception innerException, Object content)
    {
        super(message,innerException);
        Content = content;
    }

    public BGLoggeableExpectedException(String message, Object content) {
        super(message);
        Content = content;
    }

    public String contentToJSon() {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(Content);

        }
        catch (JsonProcessingException e){
            return "Error processing content ";
        }
    }
}