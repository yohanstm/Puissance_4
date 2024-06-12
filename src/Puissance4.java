import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
import java.util.Set;

import javafx.scene.text.TextAlignment;
import javafx.scene.control.ButtonBar.ButtonData ;

import java.util.List;
import java.util.Arrays;
import java.io.File;
import java.util.ArrayList;

// java -cp bin:img --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls Pendu
/**
 * Vue du jeu du pendu
 */
public class Puissance4 extends Application {
    /**
     * modèle du jeu
     **/
    private IA modelePuissance4;
    /**
     * Liste qui contient les images du jeu
     */
    private ArrayList<Image> lesImages;
    /**
     * Liste qui contient les noms des niveaux
     */    
    public List<String> niveaux;
    /**
     * le text qui indique le niveau de difficulté
     */
    private Text leNiveau;
    /**
     * le chronomètre qui sera géré par une clasee à implémenter
     */
    private Chronometre chrono;
    /**
     * le panel Central qui pourra être modifié selon le mode (accueil ou jeu)
     */
    private BorderPane panelCentral;
    /**
     * le bouton Paramètre / Engrenage
     */
    private Button boutonParametres;
    /**
     * le bouton Accueil / Maison
     */    
    private Button boutonMaison;

    /**
     * le bouton Accueil / info
     */    
    private Button boutoninfo;

    /**
     * le bouton qui permet de (lancer ou relancer une partie
     */ 
    private Button bJouer;

    /**
     * initialise les attributs (créer le modèle, charge les images, crée le chrono ...)
     */
    @Override
    public void init() { 
        this.lesImages = new ArrayList<Image>();
        this.leNiveau = new Text();
        this.chrono = new Chronometre();
        this.panelCentral = new BorderPane();

        this.niveaux = new ArrayList<>();
        this.niveaux.add("Niveau : Facile");
        this.niveaux.add("Niveau : Moyen");
        this.niveaux.add("Niveau : Difficile");
        this.niveaux.add("Niveau : Expert");
    }

    /**
     * @return  le graphe de scène de la vue à partir de methodes précédentes
     */
    private Scene laScene(){
        BorderPane fenetre = new BorderPane();
        fenetre.setTop(this.titre());
        fenetre.setCenter(this.panelCentral);
        return new Scene(fenetre, 800, 1000);
    }

    /**
     * @return le panel contenant le titre du jeu
     */
    private Pane titre(){
        // A implémenter
        return null;
    }

    // /**
     // * @return le panel du chronomètre
     // */
     private TitledPane leChrono() {
        TitledPane res = new TitledPane();
        res.setText("Chronomètre");
        res.setCollapsible(false);
        res.setAlignment(Pos.CENTER);
        VBox vboxChrono = new VBox();
        vboxChrono.getChildren().addAll(this.chrono);
        
        Label chronometreEcrit = new Label();
        vboxChrono.setAlignment(Pos.CENTER);
        vboxChrono.getChildren().add(chronometreEcrit); 
        res.setContent(vboxChrono);
        return res;
    }


    /**
     * @return la fenêtre de jeu avec le mot crypté, l'image, la barre
     *         de progression et le clavier
     */

    private Pane fenetreJeu(){
        // A implémenter
        return null;
    }



    /**
     * @return la fenêtre d'accueil sur laquelle on peut choisir les paramètres de jeu
     */
    private VBox fenetreAccueil(){   
        // A implémenter
        return null;
    }
    

    public void modeAccueil(){
        this.panelCentral.setCenter(fenetreAccueil());
        this.modelePuissance4.setNiveau(IA.FACILE);
    }
    
    public void modeJeu(){
        this.panelCentral.setCenter(fenetreJeu());
    }
    
    public void modeParametres(){
        popUpReglesDuJeu();
    }

    /** lance une partie */
    public void lancePartie(){
        this.chrono.resetTime();
        this.chrono.start();
        this.modeJeu();

        this.majAffichage();
    }

    /**
     * raffraichit l'affichage selon les données du modèle
     */
    public void majAffichage(){
        this.panelCentral.setCenter(fenetreJeu());
    }

    /**
     * accesseur du chronomètre (pour les controleur du jeu)
     * @return le chronomètre du jeu
     */
    public Chronometre getChrono(){
        return this.chrono; 
    }

    /**
     * pop-up pour confirmer l'interruption d'une partie en cours
     * @return l'alerte de confirmation
     */
    public Alert popUpPartieEnCours(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"La partie est en cours!\n Etes-vous sûr de l'interrompre ?", ButtonType.YES, ButtonType.NO);
        this.chrono.stop();
        alert.setOnHidden(dialogEvent -> {
            if (alert.getResult() == ButtonType.NO) {
                this.chrono.start();
            }
        });
        alert.setTitle("Attention");
        return alert;
    }
        
    /**
     * pop-up pour afficher les règles du jeu
     * @return l'alerte avec les règles du jeu
     */
    public Alert popUpReglesDuJeu(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "");
        alert.setTitle("Jeu du Puissance 4");
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setMinWidth(400);
        dialogPane.setMinHeight(350);
        return alert;
    }
    
    /**
     * pop-up pour afficher un message de victoire
     * @return l'alerte de victoire
     */
    public Alert popUpMessageGagne() {
        String temps = this.chrono.getText();
        String message = String.format("Le joueur .... à gagner"); 
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message); 
        alert.setTitle("Jeu du Puissance 4");
        this.chrono.stop();
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setMinWidth(400);
        dialogPane.setMinHeight(250);
        return alert;
    }

    /**
     * créer le graphe de scène et lance le jeu
     * @param stage la fenêtre principale
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("Puissance 4");
        stage.setScene(this.laScene());
        this.modeAccueil();
        stage.show();
    }

    /**
     * Programme principal
     * @param args inutilisé
     */
    public static void main(String[] args) {
        launch(args);
    }
}
