package at.steve.pacmanv1;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Coins extends AppCompatActivity {
    private int coinCount=0;

    public void setCoin(int coin){
        coin = coinCount;
    }

    public void setCoinCount(){
        coinCount+=1;
    }

    public void setCountText(TextView tV){
        String strCoin = String.valueOf(coinCount);
        tV.setText("Score: "+strCoin);
        //setContentView(R.layout.activity_game);
    }

    public void resetCountText(TextView tV){
        coinCount=0;
        String strCoin = String.valueOf(coinCount);
        tV.setText("Score: "+strCoin);
    }

    public int returnCoin(){
        return coinCount;
    }

}
