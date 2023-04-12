package pojoClasses.response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UnsuccessfulRegister {
    private String error;


    public UnsuccessfulRegister(){

    }

    public UnsuccessfulRegister(String error){
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
