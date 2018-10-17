package com.example.fingerpainter_016997;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BrushShapeWidthSelection extends AppCompatActivity {
    private Intent data = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brush_shape_width_selection);
    }

    public void selectRound(View view) {
        data.putExtra("brushShape", "ROUND");
    }

    public void selectSquare(View view) {
        data.putExtra("brushShape", "SQUARE");
    }

    public void select5px(View view) {
        data.putExtra("brushWidth", 5);
    }

    public void select10px(View view) {
        data.putExtra("brushWidth", 10);
    }

    public void select20px(View view) {
        data.putExtra("brushWidth", 20);
    }

    public void select40px(View view) {
        data.putExtra("brushWidth", 40);
    }

    public void returnBrushShapeWidth(View view) {
        setResult(RESULT_OK,data);
        finish();
    }
}
