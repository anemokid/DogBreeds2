package c4q.nyc.dogbreeds.backend;

import c4q.nyc.dogbreeds.model.DogImage;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by c4q on 2/25/18.
 */

public interface DogBreedService {

    @GET("api/breed/terrier/images/random ")
    Call<DogImage> getTerrierMessage();


    @GET("api/breed/spaniel/images/random ")
    Call<DogImage> getSpanielMessage();

    @GET("api/breed/retriever/images/random ")
    Call<DogImage> getRetrieverMessage();

    @GET("api/breed/poodle/images/random ")
    Call<DogImage> getPoodleMessage();








}
