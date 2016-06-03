package com.tis.googleprimer;

import android.content.ClipData;
import android.content.ClipDescription;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView mCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCard = (CardView) findViewById(R.id.card);

        mCard.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(mCard);

                    mCard.startDrag(data, shadowBuilder, mCard, 0);
//                    mCard.setVisibility(View.INVISIBLE);
                    return true;
                }
                else
                {
                    return false;
                }
            }
        });

        mCard.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                int action = event.getAction();
                switch (action)
                {
                    case DragEvent.ACTION_DRAG_STARTED:
                        Log.d("DRAG EVENT", "Started");
                        break;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        Log.d("DRAG EVENT", "Entered");
                        break;

                    case DragEvent.ACTION_DRAG_EXITED:
                        Log.d("DRAG EVENT", "Exited");
                        break;

                    case DragEvent.ACTION_DROP:
                        Log.d("DRAG EVENT", "Dropped");
                        break;

                    case DragEvent.ACTION_DRAG_ENDED:
                        Log.d("DRAG EVENT", "Ended");
                        break;

                    default:
                        break;
                }
                return true;
            }
        });

    }
}
