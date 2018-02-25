package c4q.nyc.dogbreeds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    // private fields:
    private Button submitButton;
    private EditText userNameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        // instantiates + creates all views:
        instantiateViews();
    }

    /**
     * instantiateViews():
     */
    public void instantiateViews(){

        submitButton = ( Button )findViewById(R.id.btn_submit);
        userNameEditText = ( EditText ) findViewById(R.id.et_username);
        passwordEditText =  ( EditText ) findViewById(R.id.et_password);

    } // ends instantiate views:

    /**
     * submitOnClick():
     */
}
