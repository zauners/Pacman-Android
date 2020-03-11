package at.steve.pacmanv1;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;

public class Pacman extends GestureDetector.SimpleOnGestureListener {

    //Color
    int color;

    private void setColor(int pacmanColor){
        this.color = pacmanColor;
    }

    /*private GameView activity = null;

    public GameView getActivity(){
        return activity;
    }

    public void setActivity(GameView activity){
        this.activity = activity;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        int MIN_SWIPE_DISTANCE_X = 100;
        int MIN_SWIPE_DISTANCE_Y = 100;

        int MAX_SWIPE_DISTANCE_X = 1000;
        int MAX_SWIPE_DISTANCE_Y = 1000;

        float deltaX = e1.getX()-e2.getX();

        float deltaY = e1.getY()-e2.getY();

        float deltaXAbs = Math.abs(deltaX);
        float deltaYAbs = Math.abs(deltaY);

        if ((deltaXAbs >= MIN_SWIPE_DISTANCE_X)&&(deltaXAbs<=MAX_SWIPE_DISTANCE_X)){
            if (deltaX > 0){
                //Move left
                System.out.println("Left");
            }
            else{
                //Move right
                System.out.println("Right");
            }
        }
        if ((deltaYAbs >= MIN_SWIPE_DISTANCE_Y)&&(deltaYAbs<=MAX_SWIPE_DISTANCE_Y)){
            if (deltaY > 0){
                //Move up
                System.out.println("Up");
            }
            else{
                //Move down
                System.out.println("Down");
            }
        }

        return true;
        //return super.onFling(e1, e2, velocityX, velocityY);
    }*/

}
