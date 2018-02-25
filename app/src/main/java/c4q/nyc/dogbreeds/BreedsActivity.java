package c4q.nyc.dogbreeds;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import c4q.nyc.dogbreeds.backend.DogBreedService;
import c4q.nyc.dogbreeds.model.DogImage;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BreedsActivity extends AppCompatActivity {

    // private fields:
    private TextView welcomeTextView;

    private SharedPreferences loginInfo;
    private SharedPreferences dogBreedInfo;

    // cardviews:
    private CardView terrierCardView;
    private CardView spanielCardView;
    private CardView retrieverCardView;
    private CardView poodleCardView;

    // image views:
    private ImageView terrierImageView;
    private ImageView spanielImageView;
    private ImageView retrieverImageView;
    private ImageView poodleImageView;

    // private keys for terrier, spaniel , retriever, and poodle:
    private static final String terrier = "terrier";
    private static final String spaniel = "spaniel";
    private static final String retriever = "retriever";
    private static final String poodle = "poodle";

    private static final String TAG = "BreedActivity: ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breeds);

        // instantiate views:
        instantiateViews();

        // create an intent to get the user name:
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        // retrieve the username value from the shared preferences:

        loginInfo = getApplicationContext().getSharedPreferences(intent.getStringExtra("username"), MODE_PRIVATE );

        // set text view to user name:
        welcomeTextView.setText("What kind of dog would you like to see, " + username);
        //loginInfo = getApplicationContext().get


        setImages();
    }

    /**
     * instantiateViews:
     */
    public void instantiateViews(){
        welcomeTextView = (TextView)findViewById(R.id.tv_welcome);

        // card views:
        terrierCardView = (CardView)findViewById(R.id.cv_terrier);
        spanielCardView = (CardView)findViewById(R.id.cv_spaniel);
        retrieverCardView = (CardView)findViewById(R.id.cv_retriever);
        poodleCardView = (CardView)findViewById(R.id.cv_poodle);

        // image views:
        terrierImageView = (ImageView) findViewById(R.id.iv_terrier);
        spanielImageView = (ImageView) findViewById(R.id.iv_spaniel);
        retrieverImageView = (ImageView) findViewById(R.id.iv_retriever);
        poodleImageView = (ImageView) findViewById(R.id.iv_poodle);

    }

    /**
     * setImages:
     */
    public void setImages(){

        //   pass the image url to piccasso
        Picasso.with(BreedsActivity.this)
                .load("https://dog.ceo/api/img/terrier-tibetan/n02097474_3147.jpg")
                .into(terrierImageView);


        Picasso.with(BreedsActivity.this)
                .load("https://dog.ceo/api/img/spaniel-welsh/n02102177_47.jpg")
                .into(spanielImageView);

        Picasso.with(BreedsActivity.this)
                .load("https://dog.ceo/api/img/retriever-flatcoated/n02099267_1942.jpg")
                .into(retrieverImageView);

        Picasso.with(BreedsActivity.this)
                .load("https://dog.ceo/api/img/poodle-standard/n02113799_273.jpg")
                .into(poodleImageView);

    }
    /**
     *  - listeners for card click:
     *    - when user taps anywhere in a CardView launch DogsActivity
     *    - and pass alogn the selected breed to that activity
     * @param view
     */
    public void cardViewListener(View view) {

        Intent startDogActivity = new Intent( BreedsActivity.this, DogsActivity.class);

        // start dogactivity + pass the selected breed to it

        SharedPreferences.Editor editor = dogBreedInfo.edit();


        switch(view.getId()){
            case R.id.cv_terrier:
                startDogActivity.putExtra(terrier, "terrier");
                startActivity(startDogActivity);
                editor.putString(terrier, "terrier");
                editor.apply();
                break;
            case R.id.cv_spaniel:
                startDogActivity.putExtra(spaniel, "spaniel");
                startActivity(startDogActivity);
                editor.putString(spaniel,"spaniel");
                editor.apply();
                break;
            case R.id.cv_retriever:
                startDogActivity.putExtra(retriever, "retriever");
                startActivity(startDogActivity);
                editor.putString(retriever,"retriever");
                editor.apply();
                break;
            case R.id.cv_poodle:
                startDogActivity.putExtra(poodle, "poodle");
                startActivity(startDogActivity);
                editor.putString(poodle,"poodle");
                editor.apply();
                break;
        } // ends switch
    } // ends view

    /**
     * - make an http get request for each breed option
     * - url: https://dog.ceo/api/breed/terrier/images/random
     * - insert the breed ( terrier, spaniel, retriever or poodle )
     *   into the url where it stays { breed - name }
    public void makeHTTPRequest(){

        // each request will return a json response containting one url
        // for a random photo from the specified breed.
        // parse json responses to get url


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dog.ceo/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create a service:
        DogBreedService dogBreedService = retrofit.create(DogBreedService.class);

        // store each retrofit call in a string:
        //String terrierImageJson = dogBreedService.getTerrierMessage();

        // create calls to get each dog infor:
        Call<DogImage> terrierImageCall = dogBreedService.getTerrierMessage();
        Call<DogImage> spanielImageCall = dogBreedService.getSpanielMessage();
        Call<DogImage> retrieverImageCall = dogBreedService.getRetrieverMessage();
        Call<DogImage> poodleImageCall = dogBreedService.getPoodleMessage();



        terrierImageCall.enqueue(new retrofit2.Callback<DogImage>() {


            @Override
            public void onResponse(Call<DogImage> call, retrofit2.Response<DogImage> response) {


                Log.d(TAG, call.toString() );
                Log.d(TAG, response.body().getMessage());

                //String terrierJSON = response.body().getMessage();

                 //   String terrierURL = doSomeJsonWork(terrierJSON);


            }

            @Override
            public void onFailure(Call<DogImage> call, Throwable t) {
              t.printStackTrace();
            }

        });

        // display the image located at each URL in the corresponding image view
    }

    *//**
     * returns a dog w the url:
     *//*
    public String doSomeJsonWork(String jsonString){

      String url = "";
        try{
            // create a json object from the data :

            JSONObject dogJson = new JSONObject(jsonString);


             url =  dogJson.getString("message");


        } catch ( JSONException e ){
            e.printStackTrace();
        }

        return url;

    }*/
} // ends breeds activity
