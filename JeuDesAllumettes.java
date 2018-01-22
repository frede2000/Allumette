import java.util.Random;
import java.util.Scanner;

public class JeuDesAllumettes {
    public static void main(String[] args){

        Random random = new Random();

        // varriable

        int nmbAllumetteRestant = random.nextInt( 100 + 1 - 20) + 20;
        int tour = random.nextInt(2);
        int allumetteRetirer = 0;
        int rejouer = 0;
        String joueur1Choice = "";
        String joueur2Choice = "";
        String[] joueurNom = new String[2];
        boolean arret = false;

        Scanner sc = new Scanner(System.in);

        System.out.print("Bienvenue dans le jeu des allumettes !\n");
        System.out.print("Joueur 1, veuillez entrer votre nom :\n");
        joueurNom[0] = sc.next();
        System.out.print("Joueur 2, veuillez entrer votre nom :\n");
        joueurNom[1] = sc.next();
        do{
            do{
                switch (tour)
                {
                    case 0:
                        tour = 1;
                        break;
                    case 1:
                        tour = 0;
                        break;
                    default:
                        tour = 0;
                }
                System.out.print("Il reste " + nmbAllumetteRestant + " allumettes.\n");
                System.out.print(joueurNom[tour] + ", combien d’allumettes (entre 1 et 3) voulez-vous retirer?\n");
                do{
                    allumetteRetirer = sc.nextInt();
                    if(allumetteRetirer <= 0 || allumetteRetirer > 3)
                    {
                        System.out.print("Le chiffre doit etre entre 1 et 3\n");
                    }
                }while(allumetteRetirer <= 0 || allumetteRetirer > 3);

                if(nmbAllumetteRestant-allumetteRetirer <= 0)
                {
                    nmbAllumetteRestant = 0;
                    arret = true;
                    if(tour == 0)
                    {
                        System.out.print(joueurNom[1] + " remporte la partie !\n");
                    }
                    else if(tour == 1)
                    {
                        System.out.print(joueurNom[0] + " remporte la partie !\n");
                    }
                    System.out.print("Décisions prises par " + joueurNom[0] + ": " + joueur1Choice + "\nDécisions prises par " + joueurNom[1] + ": " + joueur2Choice + "\n");
                }
                else
                {
                    nmbAllumetteRestant -= allumetteRetirer;
                    if(tour == 0)
                    {
                        joueur1Choice += allumetteRetirer + ", ";
                    }
                    else if(tour == 1)
                    {
                        joueur2Choice += allumetteRetirer + ", ";
                    }
                }
            }while (!arret);
            arret = false;
            nmbAllumetteRestant = random.nextInt( 100 + 1 - 20) + 20;
            System.out.print("Voulez-vous jouer de nouveau?\n1- oui\n2- non\n");
            if(rejouer != 1 || rejouer != 2)
            {
                rejouer = 2;
            }
            rejouer = sc.nextInt();
        }while(rejouer == 1);
    }
}
