package com.example.fingerpainter_016997;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BrushColourSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour_selection);
    }

    public void selectRed(View v) {
        Intent data = new Intent();
        data.putExtra("brushColour", Color.RED);
        setResult(RESULT_OK, data);
        finish();
    }

    public void selectOrange(View v) {
        Intent data = new Intent();
        data.putExtra("brushColour", Color.parseColor("#f58231"));
        setResult(RESULT_OK, data);
        finish();
    }

    public void selectYellow(View v) {
        Intent data = new Intent();
        data.putExtra("brushColour", Color.YELLOW);
        setResult(RESULT_OK, data);
        finish();
    }

    public void selectGreen(View v) {
        Intent data = new Intent();
        data.putExtra("brushColour", Color.GREEN);
        setResult(RESULT_OK, data);
        finish();
    }

    public void selectBlue(View v) {
        Intent data = new Intent();
        data.putExtra("brushColour", Color.BLUE);
        setResult(RESULT_OK, data);
        finish();
    }

    public void selectIndigo(View v) {
        Intent data = new Intent();
        data.putExtra("brushColour", Color.parseColor("#4b0082"));
        setResult(RESULT_OK, data);
        finish();
    }

    public void selectViolet(View v) {
        Intent data = new Intent();
        data.putExtra("brushColour", Color.parseColor("#7F00FF"));
        setResult(RESULT_OK, data);
        finish();
    }

    public void selectBlack(View v) {
        Intent data = new Intent();
        data.putExtra("brushColour", Color.BLACK);
        setResult(RESULT_OK, data);
        finish();
    }
}
