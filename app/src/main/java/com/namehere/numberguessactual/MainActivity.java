package com.namehere.numberguessactual;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener {

    int numberToGuess = 0;
    EditText e;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberToGuess = initNumberToGuess();

        e = (EditText) findViewById(R.id.editTextText);
        t = (TextView) findViewById(R.id.textView);

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int userNumber = Integer.parseInt(e.getText().toString()); // e.getText() does NOT return a String...it returns an anEditable type, so we need to convert it to String first

        if (userNumber == numberToGuess) {
            t.setText(userNumber + " is the right number.\nCongratulations!");
        } else if (userNumber > numberToGuess) {
            t.setText("Your guess is too high.");
        } else if (userNumber < numberToGuess) {
            t.setText("Your guess is too low.");
        }
    }

    int initNumberToGuess() {
        Random r = new Random();
        numberToGuess = r.nextInt(150);
        return numberToGuess;
    }
}