package com.example.andriod.lab82;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText e;
    String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e = findViewById(R.id.e1);
        b1 = findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            @RequiresApi(api = Build.VERSION_CODES.O)
            public void onClick(View view) {

                AlertDialog.Builder a1 = new AlertDialog.Builder(MainActivity.this);
                a1.setIcon(getDrawable(R.drawable.img));
                a1.setTitle("Time");
                a1.setMessage("Pick Time");
                TimePicker t = new TimePicker(getApplicationContext());
                a1.setView(t);

                t.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener( ) {
                    @Override
                    public void onTimeChanged(TimePicker timePicker, int i, int i1) {

                        time = " Time  "+ String.valueOf(i) + " : " + String.valueOf(i1);
                    }

                } );
                a1.setPositiveButton("Set", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        e.setText(time);
                    }
                });
                a1.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        a1.setCancelable(true);
                    }
                });
                a1.create().show();
            }
        });


    }
}

