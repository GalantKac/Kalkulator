package galantowicz.kacper.math.uni.lodz.kalkulator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private Database database;
    private Button buttonResult;
    private Button buttonClear;
    private Button buttonStory;
    private Button buttonAdd;
    private Button buttonComma;
    private Button buttonZeroZero;
    private Button buttonZero;
    private Button buttonSubstract;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonMultiply;
    private Button buttonDivide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        buttonClear();
        buttonComma();
        buttonResult();
        buttonStory();
    }


    private void buttonComma() {
        buttonComma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textViewResult.getText() != "")
                    textViewResult.setText(textViewResult.getText() + ".");
            }
        });
    }

    private void buttonClear() {
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = textViewResult.getText().toString();
                if (text.length() != 0)
                    textViewResult.setText(text.substring(0, text.length() - 1));
            }
        });
    }

    private void buttonResult() {
        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textViewResult.getText() != "") {
                    try {
                        net.objecthunter.exp4j.Expression expression = new ExpressionBuilder(textViewResult.getText().toString()).build();
                        double calculations = expression.evaluate();
                        String newData = textViewResult.getText().toString() + " = " + calculations;
                        addData(newData);
                        textViewResult.setText(String.valueOf(calculations));
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Error in data", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void buttonStory() {
        buttonStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addData(String newDane) {
        boolean checkData = database.addData(newDane);
        if (checkData) {
            Toast.makeText(this, "Data dodana", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Nie pobrano daty", Toast.LENGTH_SHORT).show();
        }
    }

    private void init() {
        database = new Database(this);
        button1 = findViewById(R.id.ButtonOne);
        button2 = findViewById(R.id.ButtonTwo);
        button3 = findViewById(R.id.ButtonThree);
        button4 = findViewById(R.id.ButtonFour);
        button5 = findViewById(R.id.ButtonFive);
        button6 = findViewById(R.id.ButtonSix);
        button7 = findViewById(R.id.ButtonSeven);
        button8 = findViewById(R.id.ButtonEight);
        button9 = findViewById(R.id.ButtonNine);
        buttonAdd = findViewById(R.id.ButtonAdd);
        buttonStory = findViewById(R.id.ButtonStory);
        buttonSubstract = findViewById(R.id.ButtonSubtract);
        buttonMultiply = findViewById(R.id.ButtonMultiply);
        buttonDivide = findViewById(R.id.ButtonDivide);
        buttonComma = findViewById(R.id.ButtonComma);
        buttonZero = findViewById(R.id.ButtonZero);
        buttonZeroZero = findViewById(R.id.ButtonZeroZero);
        buttonClear = findViewById(R.id.ButtonClear);
        buttonResult = findViewById(R.id.ButtonResult);
        textViewResult = findViewById(R.id.ViewResult);
    }

    public void onClickOtherButtons(View view) {
        Button buttonPressed = (Button) view;
        String valueFromTheButton = buttonPressed.getText().toString();
        textViewResult.setText(textViewResult.getText() + valueFromTheButton);
    }

}
