package galantowicz.kacper.math.uni.lodz.kalkulator;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private ListView databaseResults;
    private Database database;
    private ArrayAdapter<String> listAdapter;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia);

        databaseResults = findViewById(R.id.DatabaseListView);
        database = new Database(this);
        arrayList = new ArrayList<String>();
        Cursor cursor = database.getData();
        while (cursor.moveToNext()) {
            String result = cursor.getString(1);
            arrayList.add(result);
        }
        listAdapter = new ArrayAdapter<String>(this, R.layout.list_item, arrayList);
        databaseResults.setAdapter(listAdapter);

    }
}
