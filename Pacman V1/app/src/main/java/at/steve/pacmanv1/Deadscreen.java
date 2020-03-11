package at.steve.pacmanv1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.transition.Explode;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Deadscreen extends AppCompatActivity implements View.OnClickListener {

    private Button quitGame;
    private Button restartGame;
    private int coins;
    private int highest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setExitTransition(new Explode());
        setContentView(R.layout.activity_deadscreen);
        orientationAndToolbar();


        restartGame = findViewById(R.id.restartBtn);
        quitGame = findViewById(R.id.quitBtn);

        Intent intent = getIntent();
        coins = intent.getIntExtra("coinAmount",0);
        highest = intent.getIntExtra("highScore",0);

        System.out.println("Coins: "+coins);
        setFinalScore((TextView)findViewById(R.id.scoreViewDead));
        setHighest((TextView)findViewById(R.id.highscoreViewDeath));


        restartGame.setOnClickListener(this);
        quitGame.setOnClickListener(this);

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

        final Intent intent = new Intent(Deadscreen.this, MainActivity.class);

        switch (v.getId()){
            case R.id.restartBtn:
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                finish();
                break;

            case R.id.quitBtn:
                finish();
                System.exit(0);
                break;
        }

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
