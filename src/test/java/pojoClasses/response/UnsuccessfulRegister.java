package pojoClasses.response;

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

    public void setError(String error) {
        this.error = error;
    }
}
