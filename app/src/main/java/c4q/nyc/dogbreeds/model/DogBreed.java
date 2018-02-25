package c4q.nyc.dogbreeds.model;

/**
 * Created by c4q on 2/25/18.
 */

/**
 * model class for a dogbreed object
 */
public class DogBreed {

    // private fields:
    private String name;
    private String imageUrl;

    // constructor to set all fields:
    public DogBreed(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    // default:
    public DogBreed(){

    }

    // getters + setters for all fields:

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

} // ends dog class
