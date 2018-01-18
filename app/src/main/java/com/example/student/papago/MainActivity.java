package com.example.student.papago;

import android.support.annotation.IntRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;


//echMKoKhU_Ch1NR3Ea1v
//Mu0puZi05V
public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    EditText editText;
    String sendMsg,receiveMsg;
    Translate translate = new Translate();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edittext);
        textView = (TextView) findViewById(R.id.textview);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMsg = editText.getText().toString();
                try {
                    receiveMsg = new TranslateTask().execute().get();
                }
               catch (InterruptedException e){
                    e.printStackTrace();
               }
               catch (ExecutionException e){
                   e.printStackTrace();
               }

               textView.setText(translate.Tanslatego());
            }
        });


    }


}

