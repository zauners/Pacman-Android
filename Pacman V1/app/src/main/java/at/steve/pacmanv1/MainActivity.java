package at.steve.pacmanv1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.transition.Explode;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

    public static boolean startedGame = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setExitTransition(new Explode());
        orientationAndToolbar();
        setContentView(R.layout.activity_main);
        Board gameBoard = new Board();

        gameBoard.debugPrintGrid();

        startGame();
    }

    private void startGame() {
        final View view = findViewById(R.id.IntroView);

        final Intent intent = new Intent(MainActivity.this, GameView.class);

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //debugFunc("I'm in the case!");
                        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
                        //debugFunc("Activity was created");
                        startedGame = true;
                        //System.out.println(startedGame);
                        finish();
                        break;
                }
                return false;
            }
        });
    }

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

    /*public void debugFunc(String debugMessage){
        Log.d("debug",">> Message: "+debugMessage+
                "\n>> Line: "+new Exception().getStackTrace()[0].getLineNumber()+
                "\n>> Classname: "+new Exception().getStackTrace()[0].getClassName()+
                "\n>> Methodname: "+new Exception().getStackTrace()[0].getMethodName());
    }*/

}
