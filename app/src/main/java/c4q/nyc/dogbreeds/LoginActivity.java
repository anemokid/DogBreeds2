package c4q.nyc.dogbreeds;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    // private fields:
    private Button submitButton;
    private EditText userNameEditText;
    private EditText passwordEditText;
    private TextView userNameTextView;
    private TextView passwordTextView;
    private CheckBox checkBox; // will allow us to store instance state


    // tag:
    private static final String SHARED_PREFS_KEY = "sharedPrefsTesting: ";

    // shared preferences:
    private SharedPreferences login;

    // toast:
    private Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        // instantiates + creates all views:
        instantiateViews();

        setSubmitButton();

        // this gives us access to shared preferences using the keys:
        login = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);


    }

    /**
     * instantiateViews():
     * - this creates all views:
     */
    public void instantiateViews(){

        submitButton = ( Button )findViewById(R.id.btn_submit);
        userNameEditText = ( EditText ) findViewById(R.id.et_username);
        userNameTextView = (TextView) findViewById(R.id.tv_username);
        passwordTextView = (TextView)findViewById(R.id.tv_password);
        passwordEditText =  ( EditText ) findViewById(R.id.et_password);
        checkBox = (CheckBox)findViewById(R.id.remember_me_checkbox);


    } // ends instantiate views:

    /**
     * setSubmitButton():
     * - this method will create the intent to open the breeds activity:
     */
    public void setSubmitButton() {

        // we want to store username + password entered into EditTxts for future use only if the checkbox has been ticked. ( next to remember me )
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               SharedPreferences.Editor editor = login.edit();

                if (checkBox.isChecked()) {
                    // to store the values into the editor : we use putString() just like w maps
                    editor.putString("username", userNameEditText.getText().toString());
                    editor.putString("password", passwordEditText.getText().toString());
                    editor.putBoolean("isChecked", checkBox.isChecked());


                    editor.commit(); // pattern for design; stores these values immediately.
                } else {
                    editor.putBoolean("isChecked", checkBox.isChecked());
                    editor.commit();

                }
                String checkUser = "user" + userNameEditText.getText().toString();
                String checkPassword = "password" + passwordEditText.getText().toString();



                if (userNameEditText.getText().toString().equalsIgnoreCase(login.getString(checkUser, null))
                        && passwordEditText.getText().toString().equals(login.getString(checkPassword, null))) {

                    Toast.makeText(getApplicationContext(), "Authentication Successful!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LoginActivity.this, BreedsActivity.class);
                    intent.putExtra("currentUser", userNameEditText.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Authentication Unsuccesful .. Please ee-enter username and password", Toast.LENGTH_SHORT).show();

                    // to get to the second activity with an intent:
                    Intent sendUserIntent = new Intent(LoginActivity.this, BreedsActivity.class);
                    sendUserIntent.putExtra("username", userNameEditText.getText().toString());
                    startActivity(sendUserIntent);
                }


            } // ends onCLick method()
        }); // ends submitButton onClickListener()

    } // ends submit button



} // ends LoginActivity


