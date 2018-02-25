package c4q.nyc.dogbreeds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DogsActivity extends AppCompatActivity {

    // private fields:
    private String dogBreed;
    private TextView dogBreedTextView;


    // shared preferences to access the dog name:

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // textview: show the name of the bread the user is looking at:
        dogBreedTextView =  findViewById(R.id.tv_dog_breed);

        // retrieve the breed name passes to this activity from BreedsActitivity
        // display it above recycler view

    }// ends onCreate()
} // ends dogsactivity
