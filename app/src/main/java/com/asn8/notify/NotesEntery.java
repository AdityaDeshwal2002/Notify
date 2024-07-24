package com.asn8.notify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class NotesEntery extends AppCompatActivity {
    TextView heading_ne , text_ish_ne;
    DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_entery);
        heading_ne = findViewById(R.id.heading_NE);
        text_ish_ne = findViewById(R.id.text_ish_NE);

        dataBaseHelper = new DataBaseHelper(this);

    }

    @Override
    public void onBackPressed() {
        String headingTXT = heading_ne.getText().toString();
        String textTXT = text_ish_ne.getText().toString();
        dataBaseHelper.addOne(headingTXT,textTXT);
        Toast.makeText(this, "DATA entered", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(NotesEntery.this,MainActivity.class));
        super.onBackPressed();
    }
}