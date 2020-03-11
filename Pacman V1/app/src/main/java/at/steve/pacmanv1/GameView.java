package at.steve.pacmanv1;

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
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GestureDetectorCompat;

import java.util.Random;

import static at.steve.pacmanv1.Board.board;
import static at.steve.pacmanv1.Board.pacmanBackup;
import static at.steve.pacmanv1.Board.pacmanRun;

public class GameView extends AppCompatActivity implements View.OnClickListener {
    public Coins coins = new Coins();

    public int coinAmount;
    public int deathCount;
    public int highScore;

    private Button up;
    private Button down;
    private Button left;
    private Button right;
    private Button death;
    private Button win;

    private int bashfulY;
    private int bashfulX;
    private int pokeyY;
    private int pokeyX;
    private int shadowY;
    private int shadowX;
    private int speedyY;
    private int speedyX;

    private Ghost bashful;
    private Ghost pokey;
    private Ghost shadow;
    private Ghost speedy;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setExitTransition(new Explode());
        setContentView(R.layout.activity_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        orientationAndToolbar();

        View view = findViewById(R.id.linearGameLayout);


        view.setBackground(ContextCompat.getDrawable(this, R.drawable.viewbackground));


        Board gameBoard = new Board();
        gameBoard.createGridLevelOne();

        CreateField();

        deathCount=0;

        up = findViewById(R.id.moveUp);
        down = findViewById(R.id.moveDown);
        left = findViewById(R.id.moveLeft);
        right=findViewById(R.id.moveRight);
        death=findViewById(R.id.instaDeath);
        win = findViewById(R.id.instaWin);

        up.setOnClickListener(this);
        down.setOnClickListener(this);
        left.setOnClickListener(this);
        right.setOnClickListener(this);
        death.setOnClickListener(this);
        win.setOnClickListener(this);



        int[] bashfulPos= checkGhostPos("bashful");
        bashfulY = bashfulPos[0];
        bashfulX = bashfulPos[1];

        int[] pokeyPos= checkGhostPos("pokey");
        pokeyY = pokeyPos[0];
        pokeyX = pokeyPos[1];

        int[] shadowPos= checkGhostPos("shadow");
        shadowY = shadowPos[0];
        shadowX = shadowPos[1];

        int[] speedyPos= checkGhostPos("speedy");
        speedyY = speedyPos[0];
        speedyX = speedyPos[1];

        System.out.println("bashfulPos: "+bashfulPos);
        System.out.println("pokeyPos: "+pokeyPos);
        System.out.println("shadowPos: "+shadowPos);
        System.out.println("speedyPos: "+speedyPos);

        bashful=new Ghost(board,pacmanRun,6,bashfulX,bashfulY, this);
        pokey = new Ghost(board,pacmanRun,7,pokeyX,pokeyY,this);
        shadow = new Ghost(board,pacmanRun,4,shadowX,shadowY,this);
        speedy = new Ghost(board,pacmanRun,5,speedyX,speedyY,this);


        Sleeper sleeper = new Sleeper(1000,this);
        sleeper.start();

    }

    private int[] checkGhostPos(String name){
        //First y then x pos
        int[] pacPos = new int[]{0,0};
        for (int row = 0; row < pacmanRun.length; row++) {
            for (int col = 0; col < pacmanRun[row].length; col++) {
                switch (name) {
                    case "bashful":
                        if (pacmanRun[row][col] == 6) {
                            pacPos[0]=row;
                            pacPos[1]=col;
                        }
                        break;
                    case "pokey":
                        if (pacmanRun[row][col] == 7) {
                            pacPos[0]=row;
                            pacPos[1]=col;
                        }
                        break;
                    case "shadow":
                        if (pacmanRun[row][col] == 4) {
                            pacPos[0]=row;
                            pacPos[1]=col;
                        }
                        break;
                    case "speedy":
                        if (pacmanRun[row][col] == 5) {
                            pacPos[0]=row;
                            pacPos[1]=col;
                        }
                        break;
                }
            }
        }
        return pacPos;
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
    public void onClick(View view) {

        int pacX=0;
        int pacY=0;

        for (int row = 0; row < pacmanRun.length; row++) {
            for (int col = 0; col < pacmanRun[row].length; col++) {
                if (pacmanRun[row][col] == 3){
                    pacX = col;
                    pacY = row;
                }
            }
        }

        switch (view.getId()){
            case R.id.moveUp:
                //MoveUp


                int under = pacY+1;
                int above = pacY-1;
                int right = pacX+1;
                int left = pacX-1;



                System.out.println("Row: "+pacX);
                System.out.println("Col: "+pacY);
                //int tmp = pacmanRun[pacY][14];


                //pacmanRun[under][14]=tmp;
                //updatePacmanGrid((androidx.gridlayout.widget.GridLayout)findViewById(R.id.pacmanBoard));
                //canMove("above");
                try {
                    canMove("Above", pacX,pacY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.moveRight:
                //MoveRight
                try {
                    canMove("Right", pacX,pacY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.moveLeft:
                //MoveLeft
                try {
                    canMove("Left", pacX,pacY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.moveDown:
                //MoveDown
                try {
                    canMove("Under", pacX,pacY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.instaDeath:
                //debug (start death activity)
                Death(pacX,pacY);
                break;
            case R.id.instaWin:
                Win(pacX,pacY);
                break;
        }
    }

    private void Death(int pacX, int pacY){
        Intent intent = new Intent(GameView.this, Deadscreen.class);
        Board clear = new Board();
        androidx.gridlayout.widget.GridLayout field = findViewById(R.id.pacmanBoard);
        androidx.gridlayout.widget.GridLayout gameField = findViewById(R.id.gameBoard);

        switch (board[pacX][pacY]){
            case 0:
                pacmanRun[pacX][pacY] = 0;
                board[pacX][pacY] = 0;
                board = pacmanBackup;
                break;
            case 2:
                pacmanRun[pacX][pacY] = 2;
                board[pacX][pacY] = 2;
                board = pacmanBackup;
                break;
            case 3:
                pacmanRun[pacX][pacY] = 2;
                board[pacX][pacY] = 3;
                board = pacmanBackup;
                break;
        }

        recreateGrid();

        putInDB();

        coinAmount=coins.returnCoin();
        intent.putExtra("coinAmount", coinAmount);
        intent.putExtra("highScore",highScore);

        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        finish();
    }

    private void Win(int pacX, int pacY){
        Intent intent = new Intent(GameView.this, win.class);

        switch (board[pacX][pacY]){
            case 0:
                pacmanRun[pacX][pacY] = 0;
                board[pacX][pacY] = 0;
                //board = pacmanBackup;
                break;
            case 2:
                pacmanRun[pacX][pacY] = 2;
                board[pacX][pacY] = 2;
                //board = pacmanBackup;
                break;
            case 3:
                pacmanRun[pacX][pacY] = 2;
                board[pacX][pacY] = 3;
                //board = pacmanBackup;
                break;
        }

        recreateGrid();

        putInDB();

        coinAmount=coins.returnCoin();
        intent.putExtra("coinAmount", coinAmount);
        intent.putExtra("highScore",highScore);

        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        finish();
    }

    private void recreateGrid(){
        Board clear = new Board();
        androidx.gridlayout.widget.GridLayout field = findViewById(R.id.pacmanBoard);
        androidx.gridlayout.widget.GridLayout gameField = findViewById(R.id.gameBoard);
        clear.createGridLevelOne();

        field.removeAllViewsInLayout();
        gameField.removeAllViewsInLayout();

        clear.clearGrid();

        clear.createGridLevelOne();
        CreateField();
    }

    private void CreateField() {

        androidx.gridlayout.widget.GridLayout field = findViewById(R.id.gameBoard);

        for (int row = 0; row < field.getRowCount(); row++) {
            for (int col = 0; col < field.getColumnCount(); col++) {
                switch (board[row][col]){
                    case 0:
                        setUpLayout(R.drawable.floor,field);
                        break;
                    case 1:
                        setUpLayout(R.drawable.wall,field);
                        break;
                    case 2:
                        setUpLayout(R.drawable.spawn,field);
                        break;
                    case 3:
                        setUpLayout(R.drawable.spawn,field);
                        break;
                }

            }
        }

        createPacmanGrid((androidx.gridlayout.widget.GridLayout)findViewById(R.id.pacmanBoard));

    }

    public void createPacmanGrid(androidx.gridlayout.widget.GridLayout pacBoard){

        //int count=0;
        System.out.println("Column: "+pacBoard.getColumnCount());
        System.out.println("Row: "+pacBoard.getRowCount());

        //Spawn for ghost_shadow
        pacmanRun[7][10] = 4;
        //Spawn for ghost_speedy
        pacmanRun[7][11] = 5;
        //Spawn for ghost_bashful
        pacmanRun[7][13] = 6;
        //Spawn for ghost_pokey
        pacmanRun[7][14] = 7;

        for (int row = 0; row < pacBoard.getRowCount() ; row++) {
            for (int col = 0; col < pacBoard.getColumnCount(); col++) {
                switch (pacmanRun[row][col]){
                    case 0:
                        setUpLayout(R.drawable.coins,pacBoard);
                        //477 points
                        //System.out.println(count+=1);
                        break;
                    case 1:
                        setUpLayout(R.drawable.blackborder,pacBoard);
                        break;
                    case 2:
                        setUpLayout(R.drawable.blackborder, pacBoard);
                        break;
                    case 3:
                        setUpLayout(R.drawable.pacman_figure,pacBoard);
                        break;
                    case 4:
                        setUpLayout(R.drawable.ghost_shadow,pacBoard);
                        break;
                    case 5:
                        setUpLayout(R.drawable.ghost_speedy,pacBoard);
                        break;
                    case 6:
                        setUpLayout(R.drawable.ghost_bashful,pacBoard);
                        break;
                    case 7:
                        setUpLayout(R.drawable.ghost_pokey,pacBoard);
                        break;

                }
            }
        }
    }

    public void canMove(String direction, int pacX, int pacY) throws InterruptedException {



        //int pacX=14;
        //int pacY=26;

        int under = pacY+1;
        int above = pacY-1;
        int right = pacX+1;
        int left = pacX-1;

        androidx.gridlayout.widget.GridLayout field = findViewById(R.id.pacmanBoard);

        switch (direction.toLowerCase()){
            case "above":
                /*for (row = 0; row < pacmanRun.length; row++) {
                    for (col = 0; col < pacmanRun[row].length; col++) {
                        if (pacmanRun[row][col]<=31 && pacmanRun[row][col] >= 0){
                            if (pacmanRun[above][col] == 0 || pacmanRun[above][col] == 2) {
                                try {
                                    int tmp = pacmanRun[pacY][row];
                                    pacY=above;
                                    pacmanRun[pacY][row]=3;
                                    pacmanRun[under][row]=tmp;

                                    CreateField();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }*/
                System.out.println("Above");

                if (board[above][pacX] != 1){
                    if (pacmanRun[above][pacX] == 0){
                        coins.setCoinCount();
                        coins.setCountText((TextView) findViewById(R.id.scoreView));
                    }

                    if (pacmanRun[above][pacX] == 4 || pacmanRun[above][pacX] == 5 ||pacmanRun[above][pacX] == 6 || pacmanRun[above][pacX] == 7){
                        deathCount+=1;
                        coins.resetCountText((TextView) findViewById(R.id.scoreView));
                        recreateGrid();
                    }

                    pacmanRun[pacY][pacX]=2;
                    pacmanRun[above][pacX]=3;

                    field.removeAllViewsInLayout();

                    createPacmanGrid(field);

                    checkWinDeath();
                }


                //field.invalidate();
                break;
            case "under":
                /*for (row = 0; row < pacmanRun.length; row++) {
                    for (col = 0; col < pacmanRun[row].length; col++) {
                        if (pacmanRun[row][col]<=31 && pacmanRun[row][col] >= 0){
                            if (pacmanRun[under][col] == 0 || pacmanRun[under][col] == 2) {
                                try {
                                    pacY=above;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }*/
                System.out.println("Under");

                if (board[under][pacX] != 1){
                    if (pacmanRun[under][pacX] == 0){
                        coins.setCoinCount();
                        coins.setCountText((TextView) findViewById(R.id.scoreView));
                    }
                    if (pacmanRun[under][pacX] == 4 || pacmanRun[under][pacX] == 5 ||pacmanRun[under][pacX] == 6 ||pacmanRun[under][pacX] == 7){
                        deathCount+=1;
                        coins.resetCountText((TextView) findViewById(R.id.scoreView));
                        recreateGrid();
                    }
                    pacmanRun[pacY][pacX]=2;
                    pacmanRun[pacY+1][pacX]=3;

                    field.removeAllViewsInLayout();

                    createPacmanGrid(field);

                    checkWinDeath();
                }
                break;
            case "left":
                /*for (row = 0; row < pacmanRun.length; row++) {
                    for (col = 0; col < pacmanRun[row].length; col++) {
                        if (pacmanRun[row][col]<=31 && pacmanRun[row][col] >= 0){
                            if (pacmanRun[left][col] == 0 || pacmanRun[left][col] == 2) {
                                try {
                                    pacY=above;

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }*/
                System.out.println("Left");

                if (board[pacY][left] != 1){
                    if (pacmanRun[pacY][left] == 0){
                        coins.setCoinCount();
                        coins.setCountText((TextView) findViewById(R.id.scoreView));
                    }

                    if (pacmanRun[pacY][left] == 4 || pacmanRun[pacY][left] == 5 ||pacmanRun[pacY][left] == 6 || pacmanRun[pacY][left] == 7){
                        deathCount+=1;
                        coins.resetCountText((TextView) findViewById(R.id.scoreView));
                        recreateGrid();
                    }

                    pacmanRun[pacY][pacX]=2;
                    pacmanRun[pacY][pacX-1]=3;

                    field.removeAllViewsInLayout();

                    createPacmanGrid(field);

                    checkWinDeath();
                }

                break;
            case "right":
                /*for (row = 0; row < pacmanRun.length; row++) {
                    for (col = 0; col < pacmanRun[row].length; col++) {
                        if (pacmanRun[row][col] <= 31 && pacmanRun[row][col] >= 0) {
                            if (pacmanRun[right][col] == 0 || pacmanRun[right][col] == 2) {
                                try {
                                    pacY = above;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }*/
                System.out.println("Right");

                if (board[pacY][right] != 1){
                    if (pacmanRun[pacY][right] == 0){
                        coins.setCoinCount();
                        coins.setCountText((TextView) findViewById(R.id.scoreView));
                    }

                    if (pacmanRun[pacY][right] == 4 || pacmanRun[pacY][right] == 5 ||pacmanRun[pacY][right] == 6 ||pacmanRun[pacY][right] == 7){
                        deathCount+=1;
                        coins.resetCountText((TextView) findViewById(R.id.scoreView));
                        recreateGrid();
                    }

                    pacmanRun[pacY][pacX]=2;
                    pacmanRun[pacY][pacX+1]=3;

                    field.removeAllViewsInLayout();

                    createPacmanGrid(field);

                    checkWinDeath();
                }
                break;
        }
    }

    private void checkWinDeath(){
        int pacX=0;
        int pacY=0;

        coinAmount=coins.returnCoin();
        System.out.println(coinAmount);

        for (int row = 0; row < pacmanRun.length; row++) {
            for (int col = 0; col < pacmanRun[row].length; col++) {
                if (pacmanRun[row][col] == 3){
                    pacX = col;
                    pacY = row;
                }
            }
        }

        //Datenbank in Win() oder Death() Methode

        if (coinAmount >= 477){
            Win(pacX,pacY);
        }

        if (deathCount >= 3){
            Death(pacX,pacY);
        }
    }

    private void putInDB(){
        DatabaseHelper db = new DatabaseHelper(this);

        db.addHighscore(new Highscore(coinAmount,deathCount));

        System.out.println("Count of records: "+db.getDatabaseCount());

        if (db.getDatabaseCount() > 0){
            System.out.println("Höchster score in db: "+db.getHighscoreString());
            highScore = Integer.parseInt(db.getHighscoreString());
        }
        else {
            highScore = 0;
        }
    }

    public androidx.gridlayout.widget.GridLayout setUpLayout(int path, androidx.gridlayout.widget.GridLayout field){

        GridView gw;

        gw = new GridView(this);
        gw.setLayoutParams(new GridView.LayoutParams(35,35));
        gw.setBackgroundResource(path);
        gw.setVisibility(View.VISIBLE);
        field.addView(gw);

        return field;
    }

    public void ghostMove(){
        bashful.run();
        speedy.run();
        shadow.run();
        pokey.run();
    }
}

class Ghost {


    int[][] board,ghostBoard;
    int ghostNum,ghostX,ghostY;
    GameView gV;

    Ghost(int[][] board, int[][] ghostBoard, int ghostNum, int ghostX, int ghostY, GameView gV){
        this.board = board;
        this.ghostBoard = ghostBoard;
        this.ghostNum = ghostNum;
        this.ghostX = ghostX;
        this.ghostY = ghostY;
        this.gV = gV;
    }

    public void run() {
        try {

            Random rnd = new Random();

            int direction;

            int under = ghostY + 1;
            int above = ghostY - 1;
            int right = ghostX + 1;
            int left = ghostX - 1;

            androidx.gridlayout.widget.GridLayout field = gV.findViewById(R.id.pacmanBoard);

            direction = rnd.nextInt(3);

            switch (direction) {
                case 0:
                    //Above
                    if (board[above][ghostX] != 10) {
                        ghostBoard[ghostY][ghostX] = 2;
                        ghostBoard[above][ghostX] = ghostNum;
                    }
                    else{
                        run();
                    }
                    break;
                case 1:
                    //Under
                    if (board[under][ghostX] != 10){
                        ghostBoard[ghostY][ghostX] = 2;
                        ghostBoard[under][ghostX] = ghostNum;
                    }else{
                        run();
                    }
                    break;
                case 2:
                    //Right
                    if (board[ghostY][right] != 10){
                        ghostBoard[ghostY][ghostX] = 2;
                        ghostBoard[ghostY][right] = ghostNum;
                    }else{
                        run();
                    }
                    break;
                case 3:
                    //Left
                    if (board[ghostY][left] != 10){
                        ghostBoard[ghostY][ghostX] = 2;
                        ghostBoard[ghostY][left] = ghostNum;
                    }else{
                        run();
                    }
                    break;
            }

            System.out.println("ghostPosY: "+ghostY+"\n"
                    +"ghostPosX: "+ghostX);

            Thread.sleep(1000);

            field.removeAllViewsInLayout();

            gV.createPacmanGrid(field);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}

class Sleeper extends Thread{
    int sec;
    GameView gV;

    Sleeper(int sec, GameView gV){
        this.sec = sec;
        this.gV = gV;
    }

    public void checkUpdate() throws InterruptedException {
        if (gV.deathCount < 4 && gV.coinAmount < 478){
            long start = System.currentTimeMillis();
            Thread.sleep(sec);
            long finish = System.currentTimeMillis();

            System.out.println(finish-start);

            if (finish-start == 1){
                gV.ghostMove();
            }
            checkUpdate();
        }
    }
}