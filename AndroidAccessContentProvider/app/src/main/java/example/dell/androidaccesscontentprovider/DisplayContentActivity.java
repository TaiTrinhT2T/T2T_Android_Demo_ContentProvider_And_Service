package example.dell.androidaccesscontentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DisplayContentActivity extends AppCompatActivity {

    public static final String AUTHORITY = "com.inducesmile.androidcontentprovider.Dictionary";
    public static final String PATH = "/words";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + PATH);
    RecyclerView recyclerView;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState  ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_content);

        recyclerView = findViewById(R.id.list_dictionary);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        Cursor mCursor = getContentResolver().query(CONTENT_URI, null, null, null, null, null);
        List<ModelWords> words = new ArrayList<>();
        if(mCursor.moveToFirst()){
            do{
                ModelWords item = new ModelWords();
                item.setWord(mCursor.getString(1)) ;
                item.setMean(mCursor.getString(2));
                words.add(item);
            } while (mCursor.moveToNext());

            DictionaryAdapter mAdapter = new DictionaryAdapter(DisplayContentActivity.this, words);
            recyclerView.setAdapter(mAdapter);
        } else {
            Toast.makeText(DisplayContentActivity.this, "Nothing is inside the cursor", Toast.LENGTH_LONG).show();
        }
        mCursor.close();
    }
}
