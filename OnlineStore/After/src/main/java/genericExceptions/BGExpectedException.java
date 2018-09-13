package genericExceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

@Getter
public abstract class BGExpectedException extends Exception {

    public BGExpectedException (String message){
        super(message);
    }

    public BGExpectedException (String message, Exception innerException){
        super(message, innerException);
    }

}


