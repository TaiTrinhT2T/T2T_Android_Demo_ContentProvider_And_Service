package example.dell.androidaccesscontentprovider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MusicActivity extends AppCompatActivity {

    Button btnPlay;
    Button btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        btnPlay = findViewById(R.id.button_play);
        btnStop = findViewById(R.id.button_stop);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSong(view);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopSong(view);
            }
        });
    }

    // Method này được gọi khi người dùng Click vào nút Start.
    public void playSong(View view)  {
        // Tạo ra một đối tượng Intent cho một dịch vụ (PlaySongService).
        Intent myIntent = new Intent(MusicActivity.this, PlaySongService.class);
        // Gọi phương thức startService (Truyền vào đối tượng Intent)
        this.startService(myIntent);
    }

    // Method này được gọi khi người dùng Click vào nút Stop.
    public void stopSong(View view)  {
        // Tạo ra một đối tượng Intent.
        Intent myIntent = new Intent(MusicActivity.this, PlaySongService.class);
        this.stopService(myIntent);
    }
}
