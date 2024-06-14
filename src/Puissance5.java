import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.*;
import javafx.stage.Stage;


/**
 * Vue du jeu du puissance5
 */
public class Puissance5 extends Application {

    Pane panelCentral;
    Pane top;
    FXMLLoader loaderjeu;
    int largeur = 7;
    int hauteur = 6;

        /**
     * initialise les attributs
     */
    @Override
    public void init() {
    }


    /**
     * créer le graphe de scène et lance le jeu
     * @param stage la fenêtre principale
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("OBAMA battle royale");
        loaderjeu = new FXMLLoader(this.getClass().getResource("jeu vide.fxml"));
        stage.setScene(this.laScene());
        this.jeu();
        stage.show();
    }

        /**
     * @return  le graphe de scène de la vue à partir de methodes précédantes
     */
    private Scene laScene(){
        BorderPane fenetre = new BorderPane();
        top = this.menuBar();
        top.setPrefHeight(80);
        fenetre.setTop(top);
        this.jeu();
        fenetre.setCenter(this.panelCentral);
        return new Scene(fenetre, 700, 500);
    }


    private Pane menuBar(){
        return new Pane();
    }

    private void accueil(){
        this.panelCentral = new Pane();
    }

    private void param(){
        this.panelCentral = new Pane();
    }

    private void jeu(){
        try {
            this.panelCentral = loaderjeu.load();
            HBox select_col = new HBox();
            GridPane plateau = new GridPane();
            for(int x=0; x<largeur; x++){
                Button pos_col = new Button("V"); // a ajouter les trucs sur bouton
                select_col.getChildren().add(pos_col);
                for(int y=0; y<hauteur; y++){
                    Circle cercle = new Circle();
                    //cercle.setColor(Color.WHITE); //faire une classe cercle
                    plateau.add(cercle, x, y);
                }
            }
        } catch (Exception e) {
            this.panelCentral = new Pane();
        }
        
    }


}