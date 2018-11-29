package galantowicz.kacper.math.uni.lodz.kalkulator;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Historia extends AppCompatActivity {

    private TextView wyniki;
    private Database database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia);

        wyniki = findViewById(R.id.zapisHistori);
        database = new Database(this);


        Cursor cursor = database.getData();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String wynik = cursor.getString(1);
            wyniki.setText(wyniki.getText()+"\n"+ id + ":" + " "  +wynik);

        }
    }
}
