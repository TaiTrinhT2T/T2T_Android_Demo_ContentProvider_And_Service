package example.dell.androidaccesscontentprovider;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContentActivity extends AppCompatActivity {

    private EditText wordInput, meaningInput;
    Button btnAdd;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_content);
        wordInput = findViewById(R.id.enter_word);
        meaningInput = findViewById(R.id.enter_meaning);
        btnAdd = findViewById(R.id.add_content);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word = wordInput.getText().toString();
                String mean = meaningInput.getText().toString();

                if(TextUtils.isEmpty(word) || TextUtils.isEmpty(mean)) {
                    Toast.makeText(AddContentActivity.this, "Null word or mean", Toast.LENGTH_SHORT).show();
                } else {
                    String AUTHORITY = "com.inducesmile.androidcontentprovider.Dictionary";
                    String PATH  = "/words";
                    Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + PATH);
                    ContentValues values = new ContentValues();
                    values.put("word", word);
                    values.put("meaning", mean);
                    Uri mUri = getContentResolver().insert(CONTENT_URI, values);
                    if(mUri != null){
                        Toast.makeText(AddContentActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
