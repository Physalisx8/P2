package com.example.qzizzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button aB;
    private Button bB;
    private Button cB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        aB=(Button)findViewById(R.id.aButton);
        bB=(Button)findViewById(R.id.bButton);
        cB=(Button)findViewById(R.id.cButton);
        //Start of Button Listener for Buttons
        aB.setOnClickListener(new View.OnClickListener(){
         @Override
            public void OnClick(View view){
             if(aB.)
         }
        })
    }


}
