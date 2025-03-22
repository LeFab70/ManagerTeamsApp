

import service.ManageTeams;
import entities.*;
import testGlobale.*;
import utils.FileMethods;
import utils.Utils;

import java.util.List;

/*
 * ====================================================================
 * Nom du Programme     : Foot Manager
 * Description         : Application de gestion d'équipes de football,
 *                       permettant de gérer les joueurs, les coachs, les
 *                       gardiens de but et les équipes, avec des fonctionnalités
 *                       de transfert et de simulation de matchs.
 * Auteur              :  Fabrice and Bruno
 * Date de création    :  March 2025
 * Dernière modification : 17 March 2025
 * Version             : 1.0
 * ====================================================================
 */
/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        final ManageTeams manageTeamsController=new ManageTeams();
        System.out.println("========================Foot Manager testing====================");

        //Testing

        //Remplir les données et les stocker dans les listes
        TestingPlayers.createSomePlayers();
        List<Player> allPlayers=TestingPlayers.getPlayerList();

        TestingTeams.createSomeTeams();
        List<Teams> allTeams=TestingTeams.getTeamsList();

        TestingCoach.createSomeCoach();
        List<Coach> allCoach=TestingCoach.getCoaches();

        TestingGoalKeepers.createSomeGoalKeepers();
        List<Goalkeeper> allGoalKeepers=TestingGoalKeepers.getGoalkeeperList();

        //Premier affichage pour voir si tout est ok
        System.out.println("\n\n========================General datas====================\n\n");
        System.out.println("\n\n========================All Teams====================\n");
        Utils.displayObject(allTeams);
        System.out.println("\n\n========================All Players====================\n");
        Utils.displayObject(allPlayers);
        System.out.println("\n\n========================All coachs===================\n");
        Utils.displayObject(allCoach);
        System.out.println("\n\n========================All Keepers====================\n");
        Utils.displayObject(allGoalKeepers);


        System.out.println("\n\n========================Add players Coach and keepers to the teams====================\n");
        int startIndexPlayerByTeam=0;
        int endIndexPlayerByTeam=3;
        for (int indexTeam = 0; indexTeam <allTeams.size() ; indexTeam++) {
            //== 1 coach par team et 1 keeper par team=====
            //Add GoalKeepers in teams
            manageTeamsController.addPlayer(allGoalKeepers.get(indexTeam), allTeams.get(indexTeam));
            //Add Coach in team
            manageTeamsController.addPlayer(allCoach.get(indexTeam), allTeams.get(indexTeam));

            //Add Player in teams
            //=> 3 players par team
            for (int indexPlayer = startIndexPlayerByTeam; indexPlayer <endIndexPlayerByTeam ; indexPlayer++) {
                  if (endIndexPlayerByTeam > allPlayers.size())
                    break; //sortir de l'ajout aléatoire si la liste est deja au dernier élément
                manageTeamsController.addPlayer(allPlayers.get(indexPlayer), allTeams.get(indexTeam));
               // manageTeamsController.addPlayer(allPlayers.get(indexPlayer), allTeams.get(indexTeam));

            }
            startIndexPlayerByTeam +=endIndexPlayerByTeam;
            endIndexPlayerByTeam +=3;
        }

        System.out.println("\n\n========================Afficher 02 équipes pour voir si les players/coach et keepers ont été bien ajoutés====================\n\n");
        //Afficher le résultat pour la team 1
        System.out.println(allTeams.get(0));
        System.out.println("_______________________________");
        System.out.println(allTeams.get(1));

        System.out.println("\n\n========================Test du transfer de joueur====================\n\n");
        //Test de transfert player
        manageTeamsController.transferPlayer(allPlayers.get(1), allTeams.get(0), allTeams.get(1), 1200);


        System.out.println("\n\n========================Test de suppression keeper, teams====================\n\n");
        manageTeamsController.removePlayer(allGoalKeepers.getFirst(), allTeams.get(0));
        manageTeamsController.removeTeams(allTeams.getFirst());


        System.out.println("\n\n========================Affichage des teams apres transfer/suppression des joueurs, keepers====================\n\n");
        //Afficher les résultats de toutes les teams
        Utils.displayObject(allTeams);


        System.out.println("\n========================Simulation du tournoi ==Écriture et lecture du fichier====================");
        //Random des équipes et écriture dans file pour 3
        for (int i = 0; i < 3; i++) {
            Game game=Utils.teamsGames();
            FileMethods.writeFile("ResultGame.txt", game+"\n");
           // System.out.println(game);
        }

        System.out.println("========================Liste des matchs====================\n");
        //Lecture du fichier de gamesResultat
        List<String> files=FileMethods.readFile("ResultGame.txt");
        for (String line:files)
           System.out.println(line);

    }
}
