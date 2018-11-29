package galantowicz.kacper.math.uni.lodz.kalkulator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.udojava.evalex.Expression;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button dodac;
    private Button odjac;
    private Button pomnozyc;
    private Button podzelic;
    private Button cofnij;
    private Button rowna;
    private Button historia;
    private BigDecimal wynik = null;
    private ArrayList<String> listaHistoriiWynikow;
    private Database database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listaHistoriiWynikow = new ArrayList<String>();
        editText = findViewById(R.id.editText);
        dodac = findViewById(R.id.dodac);
        odjac = findViewById(R.id.odjac);
        pomnozyc = findViewById(R.id.pomnozyc);
        podzelic = findViewById(R.id.podzelic);
        cofnij = findViewById(R.id.cofnij);
        rowna = findViewById(R.id.suma);
        historia = findViewById(R.id.historia);
        database = new Database(this);

        ButtonDodac();
        ButtonOdjac();
        ButtonPodzelic();
        ButtonPomnozyc();
        ButtonBack();
        ButtonWynik();
        ButtonHistoria();

    }


    private void ButtonDodac(){
        dodac.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"+");

            }
        });
    }

    private void  ButtonOdjac(){
        odjac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"-");
            }
        });
    }

    private void ButtonPomnozyc(){
        pomnozyc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"*");
            }
        });
    }
    private void ButtonPodzelic(){
        podzelic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"/");
            }
        });
    }

    private void ButtonBack(){
        cofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if(text.length()!=0)
                editText.setText(text.substring(0, text.length()-1));
            }
        });
    }

    private void  ButtonWynik(){
        rowna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wynik = new Expression(editText.getText().toString()).eval();
                String newDane = editText.getText().toString() + " = " + wynik.toPlainString();
                AddData(newDane);
                listaHistoriiWynikow.add(editText.getText().toString() + " = " + wynik.toPlainString());
                editText.setText(wynik.toPlainString());
            }
        });
    }

    private void ButtonHistoria(){
        historia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Historia.class);
                intent.putExtra("LISTA", listaHistoriiWynikow);
                startActivity(intent);
            }
        });
    }

    public void AddData(String newDane)
    {
        boolean checkData = database.addData(newDane);
        if(checkData) {
            Toast.makeText(this, "Data dodana", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Nie pobrano daty", Toast.LENGTH_SHORT).show();
        }
    }



}
