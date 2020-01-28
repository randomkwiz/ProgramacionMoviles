package es.iesnervion.avazquez.puntokus.entities;

import java.util.concurrent.TimeUnit;

public class Game {
    private String email;
    private String idUser;
    private String level;
    private long timeInMilis;

    public Game(String email, String idUser, String level, long timeInMilis) {
        this.email = email;
        this.idUser = idUser;
        this.level = level;
        this.timeInMilis = timeInMilis;
    }

    public Game() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public long getTimeInMilis() {
        return timeInMilis;
    }

    public void setTimeInMilis(long timeInMilis) {
        this.timeInMilis = timeInMilis;
    }

    @Override
    public String toString() {
        return getEmail()+", "+getLevel() + ": "+String.format("%d min %d sec",
                TimeUnit.MILLISECONDS.toMinutes(getTimeInMilis()),
                TimeUnit.MILLISECONDS.toSeconds(getTimeInMilis()) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(getTimeInMilis()))
        );
    }
}
