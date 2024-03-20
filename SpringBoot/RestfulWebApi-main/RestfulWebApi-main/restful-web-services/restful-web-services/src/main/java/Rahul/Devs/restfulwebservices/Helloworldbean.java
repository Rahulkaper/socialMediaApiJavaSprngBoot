package Rahul.Devs.restfulwebservices;


public class Helloworldbean {

    private String message;


    public Helloworldbean(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Helloworldbean []";
    }

    public void setMessage(String message) {
        this.message = message;
    }
     
    
    public String getMessage() {
        return message;
    }

}
