import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Puissance4 extends Application {
    private IA modelePuissance4;
    private ArrayList<Image> lesImages;
    public List<String> niveaux;
    private Text leNiveau;
    private Chronometre chrono;
    private BorderPane panelCentral;
    private Button boutonParametres;
    private Button boutonMaison;
    private Button boutoninfo;
    private Button bJouer;

    @Override
    public void init() { 
        this.lesImages = new ArrayList<>();
        this.leNiveau = new Text();
        this.chrono = new Chronometre();
        this.panelCentral = new BorderPane();

        this.niveaux = new ArrayList<>();
        this.niveaux.add("Niveau : Facile");
        this.niveaux.add("Niveau : Moyen");
        this.niveaux.add("Niveau : Difficile");
        this.niveaux.add("Niveau : Expert");
    }

    private Scene laScene() {
        BorderPane fenetre = new BorderPane();
        fenetre.setTop(this.titre());
        fenetre.setCenter(this.panelCentral);
        return new Scene(fenetre, 800, 1000);
    }

    private Pane titre() {
        HBox banniere = new HBox();
        this.boutonMaison = new Button("Menu");
        boutonMaison.setMinHeight(100);
        boutonMaison.setMinWidth(266.666666667);
        this.boutonParametres = new Button("Paramètres");
        boutonParametres.setMinHeight(100);
        boutonParametres.setMinWidth(266.666666667);
        boutonParametres.setOnAction(new ControleurParametre(this)); // Set action for Parameters button
        this.boutoninfo = new Button("Régles");
        boutoninfo.setMinHeight(100);
        boutoninfo.setMinWidth(266.666666667);
        this.boutoninfo.setOnAction(new ControleurInfos(this));
        banniere.setStyle("-fx-background-color: lightgrey;");
        banniere.getChildren().addAll(boutonMaison, boutonParametres, boutoninfo);
        return banniere;
    }

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

    private Pane Parametre() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label nbRowLabel = new Label("Nombre de lignes du tableau :");
        TextField text1 = new TextField("6");
        Label nbColLabel = new Label("Nombre de colonnes du tableau :");
        TextField text2 = new TextField("7");

        CheckBox computerOnCheckBox = new CheckBox("Jouer contre l'ordinateur");
        CheckBox computerStartsCheckBox = new CheckBox("L'ordinateur commence");
        Label label4 = new Label("Difficulté");
        Slider slider1 = new Slider(1, 9, 1);

        VBox networkPane = new VBox(10);
        CheckBox networkOn = new CheckBox("Jouer en réseau");
        ToggleGroup serveurClient = new ToggleGroup();
        RadioButton server = new RadioButton("Etre serveur");
        server.setToggleGroup(serveurClient);
        RadioButton client = new RadioButton("Etre client");
        client.setToggleGroup(serveurClient);
        TextField ipTextField = new TextField("...");
        networkPane.getChildren().addAll(networkOn, server, client, ipTextField);

        gridPane.add(nbRowLabel, 0, 0);
        gridPane.add(text1, 1, 0);
        gridPane.add(nbColLabel, 0, 1);
        gridPane.add(text2, 1, 1);
        gridPane.add(computerOnCheckBox, 0, 2, 2, 1);
        gridPane.add(computerStartsCheckBox, 0, 3, 2, 1);
        gridPane.add(label4, 0, 4);
        gridPane.add(slider1, 1, 4);
        gridPane.add(networkPane, 0, 5, 2, 1);

        return gridPane;
    }

    public void modeParametres() {
        this.panelCentral.setCenter(Parametre());
    }

    private Pane fenetreJeu() {
        // To be implemented
        return null;
    }

    private VBox fenetreAccueil() {
        // To be implemented
        return null;
    }

    public void modeAccueil() {
        this.panelCentral.setCenter(fenetreAccueil());
        this.modelePuissance4.setNiveau(IA.FACILE);
    }

    public void modeJeu() {
        this.panelCentral.setCenter(fenetreJeu());
    }

    public void lancePartie() {
        this.chrono.resetTime();
        this.chrono.start();
        this.modeJeu();
        this.majAffichage();
    }

    public void majAffichage() {
        this.panelCentral.setCenter(fenetreJeu());
    }

    public Chronometre getChrono() {
        return this.chrono;
    }

    public Alert popUpPartieEnCours() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "La partie est en cours!\n Etes-vous sûr de l'interrompre ?", ButtonType.YES, ButtonType.NO);
        this.chrono.stop();
        alert.setOnHidden(dialogEvent -> {
            if (alert.getResult() == ButtonType.NO) {
                this.chrono.start();
            }
        });
        alert.setTitle("Attention");
        return alert;
    }

    public Alert popUpReglesDuJeu() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Comment jouer au Puissance 4 ? \n" +
                "Le but du jeu est d'aligner une suite de 4 pions de même couleur sur une grille. Chaque joueur dispose de 21 pions d'une couleur (par convention, en général jaune ou rouge). Tour à tour, les deux joueurs placent un pion dans la colonne de leur choix, le pion coulisse alors jusqu'à la position la plus basse possible dans ladite colonne à la suite de quoi c'est à l'adversaire de jouer. Le vainqueur est le joueur qui réalise le premier un alignement (horizontal, vertical ou diagonal) consécutif d'au moins quatre pions de sa couleur. Si, alors que toutes les cases de la grille de jeu sont remplies, aucun des deux joueurs n'a réalisé un tel alignement, la partie est déclarée nulle. ");
        alert.setTitle("Jeu du Puissance 4");
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setMinWidth(400);
        dialogPane.setMinHeight(350);
        return alert;
    }

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

    @Override
    public void start(Stage stage) {
        stage.setTitle("Puissance 4");
        stage.setScene(this.laScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
