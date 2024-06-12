import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import java.util.Optional;

/**
 * Contrôleur à activer lorsque l'on clique sur le bouton Accueil
 */
public class RetourAccueil implements EventHandler<ActionEvent> {
    /**
     * modèle du jeu
     */
    private IA modelePuissance4;
    /**
     * vue du jeu
     **/
    private Puissance4 vuePuisssance4;

    /**
     * @param modelePuissance4 modèle du jeu
     * @param vuePendu vue du jeu
     */
    public RetourAccueil(IA modelePuissance4, Puissance4 vuePuisssance4) {
        this.modelePuissance4 = modelePuissance4;
        this.vuePuisssance4 = vuePuisssance4;
    }


    /**
     * L'action consiste à retourner sur la page d'accueil. Il faut vérifier qu'il n'y avait pas une partie en cours
     * @param actionEvent l'événement action
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        this.vuePuisssance4.modeAccueil();
    }
}
