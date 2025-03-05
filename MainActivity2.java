package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 綁定元件
        EditText editTextName = findViewById(R.id.editTextName);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        TextView textViewResult = findViewById(R.id.textViewResult);

        // 按鈕點擊事件
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 取得 EditText 的內容
                String name = editTextName.getText().toString().trim();

                // 顯示結果
                if (!name.isEmpty()) {
                    textViewResult.setText("你好! " + name);
                } else {
                    textViewResult.setText("請輸入姓名!");
                }
            }
        });
    }
}
