package example.dell.androidaccesscontentprovider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnServiceMusic;
    Button displayContent;
    Button addContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayContent = findViewById(R.id.dispaly_content);
        displayContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent disPlayIntent = new Intent(MainActivity.this, DisplayContentActivity.class);
                startActivity(disPlayIntent);
            }
        });

        addContact = findViewById(R.id.add_new_content);
        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent disPlayIntent = new Intent(MainActivity.this, AddContentActivity.class);
                startActivity(disPlayIntent);
            }
        });

        btnServiceMusic = findViewById(R.id.btn_service_music);
        btnServiceMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent disPlayIntent = new Intent(MainActivity.this, MusicActivity.class);
                startActivity(disPlayIntent);
            }
        });
    }
}
