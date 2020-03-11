package at.steve.pacmanv1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class win extends AppCompatActivity implements View.OnClickListener {

    private Button confirm;
    private int coins;
    private int highest;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        orientationAndToolbar();

        Intent intent = getIntent();
        coins = intent.getIntExtra("coinAmount",0);
        highest = intent.getIntExtra("highScore",0);

        System.out.println("Coins: "+coins);
        setFinalScore((TextView)findViewById(R.id.scoreViewWin));
        setHighest((TextView)findViewById(R.id.highscoreViewWin));

        confirm = findViewById(R.id.confirm);

        confirm.setOnClickListener(this);
    }

    @SuppressLint("SourceLockedOrientationActivity")
    public void orientationAndToolbar() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);         //Fixes the orientation to horizontal
        //requestWindowFeature(Window.FEATURE_NO_TITLE);          //removes the notification bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);           //sets the screen on fullscreen
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        Log.d("debug", "Orientation, Fullscreen and Toolbar gone");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(win.this,MainActivity.class);

        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(win.this).toBundle());
    }

    public void setFinalScore(TextView tV){
        String strCoin = String.valueOf(coins);
        tV.setText("Score: "+strCoin);
    }

    private void setHighest(TextView tV){
        String strHighest = String.valueOf(highest);
        tV.setText("Highscore: "+strHighest);
    }
}
