import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.ButtonBar.ButtonData ;

import java.util.List;
import java.util.Optional;
import java.util.Arrays;
import java.io.File;
import java.util.ArrayList;


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
        this.accueil();
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
        return new Scene(fenetre, 500, 600);
    }


    private Pane menuBar(){
        return new Pane();
    }

    private Pane accueil(){
        return new Pane();
    }

    private Pane param(){
        return new Pane();
    }

    private Pane jeu(){
        
    }


}