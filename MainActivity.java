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
        setContentView(R.layout.activity_main); // 設定畫面為 activity_main.xml

        // 綁定 UI 元件
        EditText editTextCelsius = findViewById(R.id.editTextCelsius); // 攝氏輸入框
        Button buttonConvert = findViewById(R.id.buttonConvert); // 轉換按鈕
        TextView textViewResult = findViewById(R.id.textViewResult); // 顯示結果的文字框

        // 設定按鈕的點擊事件監聽器
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 取得使用者輸入的攝氏溫度，並去除空白
                String input = editTextCelsius.getText().toString().trim();

                // 檢查是否有輸入數值
                if (!input.isEmpty()) {
                    try {
                        double celsius = Double.parseDouble(input); // 轉換成浮點數
                        double fahrenheit = (celsius * 9 / 5) + 32; // 攝氏轉華氏公式
                        textViewResult.setText("華氏溫度: " + String.format("%.1f", fahrenheit));
                    } catch (NumberFormatException e) {
                        textViewResult.setText("請輸入有效的數字!"); // 防止輸入非數字
                    }
                } else {
                    textViewResult.setText("請輸入攝氏溫度!"); // 提示使用者輸入
                }
            }
        });
    }
}
