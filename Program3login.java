package ajiet.cse.androidworkshop2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Program3login extends AppCompatActivity {
    //Declaring objects of class EditText
    EditText username;
    EditText password;
    String requiredUsername;
    String requiredPassword;
    int buttonClickCount;
    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program3login);
        //Connecting components to objects
        username = findViewById(R.id.editTextLoginUsername);
        password = findViewById(R.id.editTextLoginPassword);
        signIn = findViewById(R.id.buttonSignIn);
        //Loading data from present activity into Bundle
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            requiredUsername = extras.getString("Username");
            requiredPassword = extras.getString("Password");
        }
        //Initialising counter to check number of incorrect logins
        buttonClickCount = 0;
    }

    public void login(View view) {
        //Checking if data entered in Registration page is the same as the data entered in Login page
        //If true, move to Home Page, else increment counter
        String entUn = username.getText().toString();
        if (requiredUsername.equals(username.getText().toString()) && requiredPassword.equals(password.getText().toString())) {
            Intent activePage = new Intent(this, Program3home.class);
            activePage.putExtra("Username", entUn);
            startActivity(activePage);
        } else {
            buttonClickCount++;
            //Display toast if counter of incorrect attempts > 1 and disable button
            if (buttonClickCount > 1) {
                signIn.setEnabled(false);
                Toast toastMsg = Toast.makeText(getApplicationContext(), "Better Luck next time!", Toast.LENGTH_LONG);
                toastMsg.show();
            } else {
                Toast toastMsg = Toast.makeText(getApplicationContext(), "Incorrect Username or Password, Please try again!", Toast.LENGTH_LONG);
                toastMsg.show();
            }
        }
    }
}