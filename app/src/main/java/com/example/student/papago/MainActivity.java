package com.example.student.papago;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


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
                Log.d("RCMsg", "이상무");
                sendMsg = editText.getText().toString();

                Log.d("RCMsg", "이상무");
                Toast.makeText(getApplicationContext(),sendMsg,Toast.LENGTH_SHORT).show();
                Log.d("RCMsg", "이상무");
                Toast.makeText(getApplicationContext(),translate.Tanslatego(),Toast.LENGTH_SHORT).show();

               textView.setText(translate.Tanslatego());
            }
        });


    }


}

