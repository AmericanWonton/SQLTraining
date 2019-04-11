package com.example.funfact;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Factbook factBook = new Factbook(); //If we don't add a constructor, this will create one.
    private colorWheel colorWheel = new colorWheel();
    //Declare our View Variables
    private TextView mFactTextView;
    private Button mShowFactButton;
    private RelativeLayout relativeLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) { //onCreate makes an activity when created.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assing the views from the layout file to the corresponding variables.
        mFactTextView = (TextView) findViewById(R.id.factTextView); //Older Versions may need this "casted" as textview.
        mShowFactButton = findViewById(R.id.showFactButton); //Older Versions may need this "casted" as Button.
        relativeLayout = findViewById(R.id.relativeLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //The Button was clicked, so update the fact TextView with a new fact.
                //Randomly Select a fact.
                String fact = factBook.getFact();

                //Update screen with new fact.
                mFactTextView.setText(fact);

                int color = colorWheel.getColor();
                relativeLayout.setBackgroundColor(color);
                mShowFactButton.setTextColor(color);
            }
        };
        mShowFactButton.setOnClickListener(listener);

        //Toast.makeText(this, "Yay, our activity was created!", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "We're logging from the 'on create' mehtod.");
    }
}
