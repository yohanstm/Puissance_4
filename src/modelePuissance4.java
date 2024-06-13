import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;


/**
 * Modèle pour le jeu le puissance4.
 */
public class modelePuissance4 {

    /**
     * la grille
     * 
     * 
     */

    private int rows = 6;

    private int columns = 7;

    private int position;


    private int[][] grille = new int[rows][columns] ;


    private int joueur1 = 1;

    private int joueur2 = 2;

    private int joueurActuel = this.joueur1;


    public modelePuissance4(int[][] grille, int joueur1, int joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        for (int x = 0 ; x<rows ; x++){
            for (int y = 0 ; y<columns ; y++){
                grille[rows][columns] = 0;
            }
        }
    }

    
    public int getPosition() {
        return position;
    }

    public int getJoueur1() {
        return joueur1;
    }

    public int getJoueur2() {
        return joueur2;
    }

    public int getJoueurActuel() {
        return joueurActuel;
    }


    public void jouer(int[][] grille, int joueurActuel, int position){
        boolean fin = false;
        while (!(fin)){
            for (int x = 0 ; x<rows ; x++){
                for (int y = 0 ; y<columns ; y++){
                    if (y == position)
                        if (grille[rows][columns] != 0)
                            grille[rows][columns] = this.joueurActuel;
                            fin = true;           
                }
            }
        }
    }



    public boolean gagneVertical(int[][] grille){
        boolean gagne = true;
        for (int y = 0 ; y<columns ; y++){
            try {
                gagne = true;
                for (int i = 0 ; i<4 ; i++){
                    if (grille[rows][columns] == grille[rows+i][columns] && grille[rows][columns] != 0)
                        return false;
                }
            }catch (Exception e) {
            }
        }
        return gagne;
    }

    public boolean gagneHorizontal(int[][] grille){
        boolean gagne = true;
        for (int y = 0 ; y<columns ; y++){
            try {
                gagne = true;
                for (int i = 0 ; i<4 ; i++){
                    if (grille[rows][columns] == grille[rows][columns+1] && grille[rows][columns] != 0)
                        return false;
                }
            }catch (Exception e) {
            }
        }
        return gagne;
    }


    public boolean gagneDiagonal(int[][] grille){
        boolean gagne = true;
        for (int y = 0 ; y<columns ; y++){
            try {
                gagne = true;
                for (int i = 0 ; i<4 ; i++){
                    if (grille[rows][columns] == grille[rows+i][columns+i] && grille[rows][columns] != 0)
                        return false;
                }
            }catch (Exception e) {
            }
        }
        return gagne;
    }


    public boolean gagneDiagonalInverse(int[][] grille){
        boolean gagne = true;
        for (int y = 0 ; y<columns ; y++){
            try {
                gagne = true;
                for (int i = 0 ; i<4 ; i++){
                    if (grille[rows][columns] == grille[rows-i][columns+i] && grille[rows][columns] != 0)
                        return false;
                }
            }catch (Exception e) {
            }
        }
        return gagne;
    }








    public boolean estGagne(int[][] grille){
        if (gagneVertical(grille) || gagneHorizontal(grille)){
            return true;
        }
        return false;
    }









}