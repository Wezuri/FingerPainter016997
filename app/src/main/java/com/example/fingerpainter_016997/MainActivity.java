package com.example.fingerpainter_016997;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_BRUSH_COLOUR = 1;
    private static final int REQUEST_BRUSH_SHAPE_WIDTH = 2;

    //Reference to fingerpainter view
    FingerPainterView fpv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fpv = findViewById(R.id.fingerPainterView);
        //Loads the image for implicit intents
        fpv.load(getIntent().getData());
    }

    //Function to save the settings when the activity gets destroyed
    //Only saves the brush colour, brush type, brush width. The drawing is saved in FingerPainter
    @Override
    protected void onSaveInstanceState (Bundle bundle) {
        super.onSaveInstanceState(bundle);
        //Saving brush colour
        bundle.putInt("brushColour", fpv.getColour());
        //Saving brush shape
        bundle.putString("brushShape", fpv.getBrush().name());
        //Saving brush width
        bundle.putInt("brushWidth", fpv.getBrushWidth());
    }

    //Function to restore the state of the activity to before it was destroyed
    //Only saves the brush colour, brush type, brush width. The drawing is saved in FingerPainter
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //Restoring brush colour
        fpv.setColour(savedInstanceState.getInt("brushColour"));
        //Restoring brush shape
        String shape = savedInstanceState.getString("brushShape");
        if(shape.equals("ROUND")){
            fpv.setBrush(Paint.Cap.ROUND);
        }
        else {
            fpv.setBrush(Paint.Cap.SQUARE);
        }
        //Restoring brush width
        fpv.setBrushWidth(savedInstanceState.getInt("brushWidth"));
    }

    //Function to call BrushColourSelection activity
    public void chooseColour(View v) {
        Intent i = new Intent(MainActivity.this, BrushColourSelection.class);
        startActivityForResult(i, REQUEST_BRUSH_COLOUR);
    }

    //Function to call BrushShapeWidthSelection
    public void chooseShapeWidth(View v) {
        Intent i = new Intent(MainActivity.this, BrushShapeWidthSelection.class);
        startActivityForResult(i,REQUEST_BRUSH_SHAPE_WIDTH);
    }

    //Function that receives the intent that contains the colour/width/shape
    //from BrushColourSelection and BrushSelection
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Changing the colour of the brush
        if((requestCode== REQUEST_BRUSH_COLOUR) && (resultCode==RESULT_OK)) {
            Bundle extras = data.getExtras();
            if(extras==null) return;
            int colour = extras.getInt("brushColour");
            fpv.setColour(colour);
        }
        //Changing the brush width/shape
        else if((requestCode== REQUEST_BRUSH_SHAPE_WIDTH) && (resultCode==RESULT_OK)) {
            Bundle extras = data.getExtras();
            if(extras==null) return;
            String shape = extras.getString("brushShape");
            if(shape!=null) {
                if (shape.equals("ROUND")) {
                    fpv.setBrush(Paint.Cap.ROUND);
                } else if (shape.equals("SQUARE")) {
                    fpv.setBrush(Paint.Cap.SQUARE);
                }
            }
            int width = extras.getInt("brushWidth");
            if(width!=0) fpv.setBrushWidth(width);
        }
    }

    public void clearScreen(View view) {
        fpv.clear();
    }
}
