package com.example.slip17q2;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private EditText inputNumber;
    private TextView resultText;
    private int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputNumber = findViewById(R.id.inputNumber);
        resultText = findViewById(R.id.resultText);
        registerForContextMenu(resultText);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose Action");
        menu.add(0, v.getId(), 0, "Calculate Factorial");
        menu.add(0, v.getId(), 0, "Calculate Sum of Digits");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String input = inputNumber.getText().toString();
        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            return true;
        }
        number = Integer.parseInt(input);
        if (item.getTitle().equals("Calculate Factorial")) {
            long factorial = calculateFactorial(number);
            resultText.setText("Factorial: " + factorial);
            return true;
        } else if (item.getTitle().equals("Calculate Sum of Digits")) {
            int sum = calculateSumOfDigits(number);
            resultText.setText("Sum of Digits: " + sum);
            return true;
        } else {
            return false;
        }
    }
    private long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    private int calculateSumOfDigits(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
