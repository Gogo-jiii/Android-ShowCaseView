package com.example.showcaseview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.erkutaras.showcaseview.ShowcaseManager;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;
    int showCaseNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);

        btn1.setOnClickListener(v -> openShowCase1());
    }

    private void openShowCase1() {
        showCaseNumber = 1;

        ShowcaseManager.Builder builder = new ShowcaseManager.Builder();

        builder.context(MainActivity.this).key("Key").developerMode(true).view(btn1).descriptionTitle("This is title 1").descriptionText("This is description 1").buttonText("Done").buttonVisibility(true).cancelButtonColor(Color.RED).cancelButtonVisibility(true).add().build().show();
    }

    private void openShowCase2() {
        showCaseNumber = 2;

        ShowcaseManager.Builder builder = new ShowcaseManager.Builder();

        builder.context(MainActivity.this).key("Key").developerMode(true).view(btn2).descriptionTitle("This is title 2").descriptionText("This is description 2").buttonText("Done").buttonVisibility(true).cancelButtonColor(Color.RED).cancelButtonVisibility(true).add().build().show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ShowcaseManager.REQUEST_CODE_SHOWCASE && resultCode == Activity.RESULT_OK && showCaseNumber == 1
        ) {
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
            openShowCase2();
        } else if (requestCode == ShowcaseManager.REQUEST_CODE_SHOWCASE && resultCode == Activity.RESULT_OK && showCaseNumber == 2) {
            Toast.makeText(this, "Everything is done.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "DISMISS", Toast.LENGTH_SHORT).show();
        }
    }
}