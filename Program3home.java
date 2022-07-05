package ajiet.cse.androidworkshop2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Program3home extends AppCompatActivity {
    String dispUn;
    TextView dispText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program3home);
        //Get data stored in Bundle from Login page
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            dispUn = extras.getString("Username");
        }
        //Display text with the name of the user
        dispText = findViewById(R.id.textView13);
        dispText.setText(String.format("Hello %s", dispUn));
    }
}