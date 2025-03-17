/*

    But: Classe additionnelle permettant de gérer les matchs entre teams
 */
package entities;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Game {
    private String receptionTeam;
    private String visitorTeam;
    private int recepTeamNumberGoals;
    private int visitorTeamNumberGoals;
    private LocalDate dateOfGame;
    private String refereeName;
    private static final AtomicInteger count= new AtomicInteger(1);
    private  int id;

    public Game(String receptionTeam, String visitorTeam, int recepTeamNumberGoals, int visitorTeamNumberGoals, LocalDate dateOfGame, String refereeName) {
        this.receptionTeam = receptionTeam;
        this.id=count.getAndIncrement();
        this.visitorTeam = visitorTeam;
        this.recepTeamNumberGoals = recepTeamNumberGoals;
        this.visitorTeamNumberGoals = visitorTeamNumberGoals;
        this.dateOfGame = dateOfGame;
        this.refereeName = refereeName;
    }

    public Game() {
    }

    public String getReceptionTeam() {
        return receptionTeam;
    }

    public void setReceptionTeam(String receptionTeam) {
        this.receptionTeam = receptionTeam;
    }

    public String getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam(String visitorTeam) {
        this.visitorTeam = visitorTeam;
    }

    public int getRecepTeamNumberGoals() {
        return recepTeamNumberGoals;
    }

    public void setRecepTeamNumberGoals(int recepTeamNumberGoals) {
        this.recepTeamNumberGoals = recepTeamNumberGoals;
    }

    public int getVisitorTeamNumberGoals() {
        return visitorTeamNumberGoals;
    }

    public void setVisitorTeamNumberGoals(int visitorTeamNumberGoals) {
        this.visitorTeamNumberGoals = visitorTeamNumberGoals;
    }

    public LocalDate getDateOfGame() {
        return dateOfGame;
    }

    public void setDateOfGame(LocalDate dateOfGame) {
        this.dateOfGame = dateOfGame;
    }

    public String getRefereeName() {
        return refereeName;
    }

    public void setRefereeName(String refereeName) {
        this.refereeName = refereeName;
    }

    @Override
    public String toString() {
        return "Game{" +
                "receptionTeam=" + receptionTeam +
                ", visitorTeam=" + visitorTeam +
                ", recepTeamNumberGoals=" + recepTeamNumberGoals +
                ", visitorTeamNumberGoals=" + visitorTeamNumberGoals +
                ", dateOfGame=" + dateOfGame +
                ", refereeName='" + refereeName + '\'' +
                ", id=" + id +
                '}';
    }
}
