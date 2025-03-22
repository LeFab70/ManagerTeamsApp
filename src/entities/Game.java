
package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * La classe Game représente un match entre deux équipes avec les informations clés comme
 * les noms des équipes, le score, la date du match, et le nom de l'arbitre.
 * Chaque match reçoit un identifiant unique généré automatiquement.
 *
 * <h2>Fonctionnalités principales :</h2>
 * <ul>
 *     <li>Gère les informations sur les équipes (équipe réception et visiteuse).</li>
 *     <li>Stocke les scores de chaque équipe.</li>
 *     <li>Enregistre la date du match et le nom de l'arbitre.</li>
 *     <li>Génère un identifiant unique pour chaque match.</li>
 * </ul>
 *
 * @author Fabrice & Bruno
 * @version 1.0
 * @since 2025
 */
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
                ", dateOfGame=" +this.dateOfGame +
                ", refereeName='" + refereeName + '\'' +
                ", id=" + id +
                '}';
    }
}
