package at.steve.pacmanv1;

import java.util.Random;

class GhostS implements Runnable {


    int[][] board,ghostBoard;
    int ghostNum,ghostX,ghostY;
    GameView gV;

    GhostS(int[][] board, int[][] ghostBoard, int ghostNum, int ghostX, int ghostY, GameView gV){
        this.board = board;
        this.ghostBoard = ghostBoard;
        this.ghostNum = ghostNum;
        this.ghostX = ghostX;
        this.ghostY = ghostY;
        this.gV = gV;
    }

    @Override
    public void run() {
        try {
            //Rnd importieren bzw RND-Richtung

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

                        field.removeAllViewsInLayout();

                        gV.createPacmanGrid(field);
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

                        field.removeAllViewsInLayout();

                        gV.createPacmanGrid(field);
                    }else{
                        run();
                    }
                    break;
                case 2:
                    //Right
                    if (board[ghostY][right] != 10){
                        ghostBoard[ghostY][ghostX] = 2;
                        ghostBoard[ghostY][right] = ghostNum;

                        field.removeAllViewsInLayout();

                        gV.createPacmanGrid(field);
                    }else{
                        run();
                    }
                    break;
                case 3:
                    //Left
                    if (board[ghostY][left] != 10){
                        ghostBoard[ghostY][ghostX] = 2;
                        ghostBoard[ghostY][left] = ghostNum;

                        field.removeAllViewsInLayout();

                        gV.createPacmanGrid(field);

                    }else{
                        run();
                    }
                    break;
            }

            System.out.println("ghostPosY: "+ghostY+"\n"
                    +"ghostPosX: "+ghostX);

            Thread.sleep(1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
