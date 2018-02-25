package c4q.nyc.dogbreeds.model;

/**
 * Created by c4q on 2/25/18.
 */

public class DogImage {

    // private fields:
    private String status;
    private String message;

    // constructors:

    public DogImage(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public DogImage(){

    }

    // getters + setters for image :
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
