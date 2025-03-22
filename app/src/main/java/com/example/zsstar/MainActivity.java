package com.example.zsstar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText get_name;
    private DatePicker datePicker;
    private Button start_ce;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        get_name = findViewById(R.id.input_name);
        datePicker = findViewById(R.id.date_picker);
        start_ce = findViewById(R.id.start_ce);
        start_ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String name = get_name.getText().toString();
                intent.putExtra("name", name);
                intent.putExtra("year", datePicker.getYear());
                intent.putExtra("month", datePicker.getMonth());
                intent.putExtra("day", datePicker.getDayOfMonth());
                startActivity(intent);
            }
        });
        
    }
}
