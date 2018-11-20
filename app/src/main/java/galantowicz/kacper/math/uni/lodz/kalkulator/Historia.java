package galantowicz.kacper.math.uni.lodz.kalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Historia extends AppCompatActivity {

    private TextView wyniki;
    private ArrayList<String> listaHistori;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia);

        wyniki = findViewById(R.id.zapisHistori);
        listaHistori = new ArrayList<String>();
        listaHistori = (ArrayList<String>) getIntent().getSerializableExtra("LISTA");
        StringBuilder builder = new StringBuilder();
        for(String wartosci : listaHistori)
        {
            builder.append(wartosci + "\n");
        }
        wyniki.setText(builder.toString());
    }
}
