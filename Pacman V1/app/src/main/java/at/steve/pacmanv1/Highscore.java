package at.steve.pacmanv1;

public class Highscore {

    int uuid;
    int highscore;
    int deaths;

    public Highscore(){

    }

    public Highscore(int uuid, int highscore, int deaths){
        this.uuid = uuid;
        this.highscore = highscore;
        this.deaths = deaths;
    }

    public Highscore(int highscore,int deaths){
        this.highscore = highscore;
        this.deaths = deaths;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }
}
