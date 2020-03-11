package at.steve.pacmanv1;

import androidx.appcompat.app.AppCompatActivity;

public class Board extends AppCompatActivity {

    public static int[][] board;
    public static int[][] pacmanRun;    //Create grid for pacman just to move the pacman a layer over the board.
    public static int[][] pacmanBackup;


    public void createGridLevelOne(){
        board = new int[31][28];
        int row=0,col=0;
        for (row = 0; row <board.length ; row++) {
            for (col = 0; col < board[row].length; col++) {
                if (row == 0 || row == 30 || col == 27 || col == 0){
                    switch (row){
                        case 1:
                            board[row][12] = 1;
                            break;
                        case 2:
                            board[row][2] =1;
                            board[row][3]=1;
                            board[row][4]=1;
                            board[row][5]=1;
                            board[row][7]=1;
                            board[row][8]=1;
                            board[row][9]=1;
                            board[row][10]=1;
                            board[row][12]=1;
                            board[row][14]=1;
                            board[row][15]=1;
                            board[row][16]=1;
                            board[row][17]=1;
                            board[row][18]=1;
                            board[row][19]=1;
                            board[row][20]=1;
                            board[row][22]=1;
                            board[row][23]=1;
                            board[row][24]=1;
                            board[row][25]=1;
                            break;
                        case 3:
                            board[row][2] =1;
                            board[row][3]=1;
                            board[row][4]=1;
                            board[row][5]=1;
                            board[row][7]=1;
                            board[row][8]=1;
                            board[row][9]=1;
                            board[row][10]=1;
                            board[row][12]=1;
                            board[row][14]=1;
                            board[row][15]=1;
                            board[row][16]=1;
                            board[row][17]=1;
                            board[row][18]=1;
                            board[row][19]=1;
                            board[row][20]=1;
                            board[row][22]=1;
                            board[row][23]=1;
                            board[row][24]=1;
                            board[row][25]=1;
                            break;
                        case 5:
                            board[row][2] =1;
                            board[row][3]=1;
                            board[row][9]=1;
                            board[row][10]=2;
                            board[row][11]=2;
                            board[row][12]=2;
                            board[row][13]=2;
                            board[row][14]=2;
                            board[row][15]=1;
                            board[row][17]=1;
                            board[row][18]=1;
                            board[row][19]=1;
                            board[row][20]=1;
                            board[row][21]=1;
                            board[row][22]=1;
                            board[row][23]=1;
                            board[row][24]=1;
                            board[row][25]=1;
                            break;
                        case 6:
                            board[row][2]=1;
                            board[row][3]=1;
                            board[row][9]=1;
                            board[row][10]=2;
                            board[row][11]=2;
                            board[row][12]=2;
                            board[row][13]=2;
                            board[row][14]=2;
                            board[row][15]=1;
                            board[row][25]=1;
                            break;
                        case 7:
                            board[row][2]=1;
                            board[row][3]=1;
                            board[row][4]=1;
                            board[row][5]=1;
                            board[row][6]=1;
                            board[row][7]=1;
                            board[row][9]=1;
                            board[row][10]=2;
                            board[row][11]=2;
                            board[row][12]=2;
                            board[row][13]=2;
                            board[row][14]=2;
                            board[row][15]=1;
                            board[row][17]=1;
                            board[row][18]=1;
                            board[row][19]=1;
                            board[row][20]=1;
                            board[row][21]=1;
                            break;
                        case 8:
                            board[row][2]=1;
                            board[row][3]=1;
                            board[row][4]=1;
                            board[row][5]=1;
                            board[row][6]=1;
                            board[row][7]=1;
                            board[row][9]=1;
                            board[row][10]=2;
                            board[row][11]=2;
                            board[row][12]=2;
                            board[row][13]=2;
                            board[row][14]=2;
                            board[row][15]=1;
                            board[row][17]=1;
                            board[row][18]=1;
                            board[row][19]=1;
                            board[row][20]=1;
                            board[row][21]=1;
                            board[row][25]=1;
                            break;
                        case 9:
                            board[row][2]=1;
                            board[row][3]=1;
                            board[row][9]=1;
                            board[row][10]=1;
                            board[row][11]=1;
                            board[row][12]=1;
                            board[row][13]=1;
                            board[row][14]=1;
                            board[row][15]=1;
                            board[row][25]=1;
                            break;
                        case 10:
                            board[row][2]=1;
                            board[row][3]=1;
                            board[row][25]=1;
                            break;
                        case 11:
                            board[row][6]=1;
                            board[row][7]=1;
                            board[row][8]=1;
                            board[row][9]=1;
                            board[row][10]=1;
                            board[row][11]=1;
                            board[row][12]=1;
                            board[row][14]=1;
                            board[row][15]=1;
                            board[row][16]=1;
                            board[row][17]=1;
                            board[row][18]=1;
                            board[row][19]=1;
                            board[row][20]=1;
                            break;
                        case 12:
                            board[row][2]=1;
                            board[row][6]=1;
                            board[row][7]=1;
                            board[row][19]=1;
                            board[row][20]=1;
                            board[row][25]=1;
                            break;
                        case 13:
                            board[row][2]=1;
                            board[row][6]=1;
                            board[row][7]=1;
                            board[row][19]=1;
                            board[row][20]=1;
                            board[row][25]=1;
                            break;
                        case 14:
                            board[row][2]=1;
                            board[row][6]=1;
                            board[row][7]=1;
                            board[row][19]=1;
                            board[row][20]=1;
                            board[row][25]=1;
                            break;
                        case 15:
                            board[row][2]=1;
                            board[row][6]=1;
                            board[row][7]=1;
                            board[row][19]=1;
                            board[row][20]=1;
                            board[row][25]=1;
                            break;
                        case 16:
                            board[row][6]=1;
                            board[row][7]=1;
                            board[row][8]=1;
                            board[row][9]=1;
                            board[row][10]=1;
                            board[row][11]=1;
                            board[row][12]=1;
                            board[row][15]=1;
                            board[row][16]=1;
                            board[row][17]=1;
                            board[row][18]=1;
                            board[row][19]=1;
                            board[row][20]=1;
                            board[row][25]=1;
                            break;
                        case 17:
                            board[row][2]=1;
                            board[row][9]=1;
                            board[row][15]=1;
                            break;
                        case 18:
                            board[row][2]=1;
                            board[row][5]=1;
                            board[row][6]=1;
                            board[row][7]=1;
                            board[row][8]=1;
                            board[row][9]=1;
                            board[row][15]=1;
                            board[row][16]=1;
                            board[row][17]=1;
                            board[row][18]=1;
                            board[row][19]=1;
                            board[row][20]=1;
                            board[row][21]=1;
                            board[row][25]=1;
                            break;
                        case 19:
                            board[row][2]=1;
                            board[row][9]=1;
                            board[row][18]=1;
                            board[row][21]=1;
                            board[row][22]=1;
                            board[row][24]=1;
                            board[row][25]=1;
                            break;
                        case 20:
                            board[row][2]=1;
                            board[row][8]=1;
                            board[row][9]=1;
                            board[row][18]=1;
                            board[row][25]=1;
                            break;
                        case 21:
                            board[row][8]=1;
                            board[row][11]=1;
                            board[row][12]=1;
                            board[row][13]=1;
                            board[row][18]=1;
                            board[row][21]=1;
                            board[row][25]=1;
                            break;
                        case 22:
                            board[row][4]=1;
                            board[row][5]=1;
                            board[row][6]=1;
                            board[row][8]=1;
                            board[row][13]=1;
                            board[row][21]=1;
                            board[row][25]=1;
                            break;
                        case 23:
                            board[row][2]=1;
                            board[row][4]=1;
                            board[row][8]=1;
                            board[row][13]=1;
                            board[row][14]=1;
                            board[row][15]=1;
                            board[row][16]=1;
                            board[row][17]=1;
                            board[row][18]=1;
                            board[row][21]=1;
                            break;
                        case 24:
                            board[row][2]=1;
                            board[row][4]=1;
                            board[row][8]=1;
                            board[row][21]=1;
                            break;
                        case 25:
                            board[row][2]=1;
                            board[row][11]=1;
                            board[row][12]=2;
                            board[row][13]=2;
                            board[row][14]=2;
                            board[row][15]=2;
                            board[row][16]=2;
                            board[row][17]=1;
                            board[row][20]=1;
                            board[row][21]=1;
                            board[row][25]=1;
                            break;
                        case 26:
                            board[row][2]=1;
                            board[row][11]=1;
                            board[row][12]=2;
                            board[row][13]=2;
                            board[row][14]=3;
                            board[row][15]=2;
                            board[row][16]=2;
                            board[row][17]=1;
                            board[row][25]=1;
                            break;
                        case 27:
                            board[row][11]=1;
                            board[row][12]=2;
                            board[row][13]=2;
                            board[row][14]=2;
                            board[row][15]=2;
                            board[row][16]=2;
                            board[row][17]=1;
                            board[row][25]=1;
                            break;
                        case 28:
                            board[row][2]=1;
                            board[row][3]=1;
                            board[row][4]=1;
                            board[row][5]=1;
                            board[row][6]=1;
                            board[row][7]=1;
                            board[row][8]=1;
                            board[row][11]=1;
                            board[row][12]=1;
                            board[row][13]=1;
                            board[row][14]=1;
                            board[row][15]=1;
                            board[row][16]=1;
                            board[row][17]=1;
                            board[row][18]=1;
                            board[row][19]=1;
                            board[row][20]=1;
                            board[row][21]=1;
                            board[row][22]=1;
                            board[row][23]=1;
                            board[row][24]=1;
                            board[row][25]=1;
                            break;

                    }
                    board[row][col] = 1;
                }
            }
        }

        pacmanRun = board;

        pacmanBackup = board;
        //patchGrid();
    }

    public void clearGrid(){
        board = null;
        pacmanRun = null;
        pacmanBackup = null;
    }

    private void patchGrid(){
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 0){
                    board[row][col] = 2;
                }
            }
        }
        pacmanRun = board;
    }

    private void createGridOriginal(){
        int row=0,col=0;
        for (row = 0; row < board.length; row++) {
            for (col = 0; col < board[row].length; col++) {
                if (row == 0 || row == 30 || col == 27 || col == 0){
                    switch (row){
                        case 1:
                            return;
                    }
                    board[row][col] = 1;
                }
            }
        }
    }

    public void debugPrintGrid(){
        createGridLevelOne();
        //createPacmanGrid();
        int row,col;
        for (row = 0; row < board.length ; row++) {
            for (col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]+"\t");
            }
            System.out.println();
        }
    }

    public void debugPrintMatrixPositions(){
        for (int row = 0; row < board.length ; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.println(row+","+col);
            }
        }
    }
}


