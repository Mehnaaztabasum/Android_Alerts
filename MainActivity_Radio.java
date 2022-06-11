package com.example.andriod.lab81;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText e;
    String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.b1);

       String[] Array={"mehnaaz","Tabasum","Shaik","Sameena"};
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            @RequiresApi(api = Build.VERSION_CODES.O)
            public void onClick(View view) {

                AlertDialog.Builder a1 = new AlertDialog.Builder(MainActivity.this);
                a1.setIcon(getDrawable(R.drawable.box));
                a1.setTitle(" Read the Data: ");
                a1.setSingleChoiceItems(Array, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext()," "+Array[i],Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();

                    }
                });

                AlertDialog a12=a1.create();
                a12.show();

                a1.setPositiveButton("Set", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

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
