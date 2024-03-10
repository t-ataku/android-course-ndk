package com.example.myndkapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myndkapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'myndkapplication' library on application startup.
    static {
        System.loadLibrary("myndkapplication");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.textView;
        tv.setText(stringFromJNI());

        Button accept = (Button)findViewById(R.id.button);
        accept.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText et = (EditText) findViewById(R.id.editTextText);
                TextView tv = (TextView) findViewById(R.id.textView);
                String nowstr = notifyClock();
                tv.setText(nowstr);
            }
        });
    }

    /**
     * A native method that is implemented by the 'myndkapplication' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native void copyMessageToDisplay();
    public native String notifyClock();
}