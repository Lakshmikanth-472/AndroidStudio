package ajiet.cse.androidworkshop2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Program4 extends AppCompatActivity {
    int counter;
    TextView tvCounter;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program4);
        Handler handler = new Handler();
        counter = 1;
        tvCounter = findViewById(R.id.counter);
        Button btnStart = findViewById(R.id.Start);
        Button btnStop = findViewById(R.id.Stop);
        btnStart.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.postDelayed(updateThread, 0);
            }
        });
        btnStop.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeCallbacks(updateThread);
            }
        });
    }
    private final Runnable updateThread = new Runnable() {
        @Override
        public void run() {
            tvCounter.setText(""+ counter);
            handler.postDelayed(this,1000);
            counter++;
        }
    };

}