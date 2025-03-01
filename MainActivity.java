package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.myapplication.R;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int randomNumber;
    private int guessCount;
    private EditText inputNumber;
    private TextView resultText, guessCountText;
    private Button guessButton, resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.inputNumber);
        resultText = findViewById(R.id.resultText);
        guessCountText = findViewById(R.id.guessCountText);
        guessButton = findViewById(R.id.guessButton);
        resetButton = findViewById(R.id.resetButton);

        startNewGame();

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGuess();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewGame();
            }
        });
    }

    private void startNewGame() {
        Random rand = new Random();
        randomNumber = rand.nextInt(100) + 1;
        guessCount = 0;
        resultText.setText("開始猜數字！");
        guessCountText.setText("猜測次數: 0");
        inputNumber.setText("");
    }

    private void checkGuess() {
        String userInput = inputNumber.getText().toString().trim();
        if (userInput.isEmpty()) {
            Toast.makeText(this, "請輸入數字！", Toast.LENGTH_SHORT).show();
            return;
        }

        int userGuess;
        try {
            userGuess = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "請輸入有效數字！", Toast.LENGTH_SHORT).show();
            return;
        }

        if (userGuess < 1 || userGuess > 100) {
            Toast.makeText(this, "請輸入 1 到 100 之間的數字！", Toast.LENGTH_SHORT).show();
            return;
        }

        guessCount++;
        guessCountText.setText("猜測次數: " + guessCount);

        if (userGuess < randomNumber) {
            resultText.setText("太小了！");
        } else if (userGuess > randomNumber) {
            resultText.setText("太大了！");
        } else {
            resultText.setText("恭喜答對！您共猜了 " + guessCount + " 次。");
        }
    }
}
