package ajiet.cse.androidworkshop2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program3signup extends AppCompatActivity {
    //Declaring objects of class EditText
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program3signup);
        //Connecting components to objects
        username = findViewById(R.id.editTextSignUpUsername);
        password = findViewById(R.id.editTextSignUpPassword);
    }

    //Class to validate if inputted password follows constraints
    public void signUp(View view) {
        String requiredUsername = username.getText().toString();
        String requiredPassword = password.getText().toString();
        //Constraints to accept password
        if (
                Pattern.matches(".+", requiredUsername) &&
                        Pattern.matches(".*[A-Z].*", requiredPassword) &&
                        Pattern.matches(".*[a-z].*", requiredPassword) &&
                        Pattern.matches(".*[0-9].*", requiredPassword) &&
                        Pattern.matches(".{8}.*", requiredPassword) &&
                        Pattern.matches(".*[^A-Za-z0-9].*", requiredPassword)
        ) {
            //Creating Intent for next activity and assigning data to be used in Bundle
            Intent activePage = new Intent(this, Program3login.class);
            activePage.putExtra("Username", requiredUsername);
            activePage.putExtra("Password", requiredPassword);
            startActivity(activePage);
        }
        else{
            Toast invdPwd = Toast.makeText(getApplicationContext(), "Password type invalid", Toast.LENGTH_LONG);
            invdPwd.show();
        }

    }
}