package Puissance_4.src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * Vue du jeu du puissance5
 */
public class Puissance5 extends Application {

    Pane panelCentral;
    Pane top;
    FXMLLoader loaderjeu;

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
        loaderjeu = new FXMLLoader(this.getClass().getResource("jeu.fxml"));
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
            for(int i=0; i<largeur; )
        } catch (Exception e) {
            this.panelCentral = new Pane();
        }
        
    }


}