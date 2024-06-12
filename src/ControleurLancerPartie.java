import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import java.util.Optional;

/**
 * Contrôleur à activer lorsque l'on clique sur le bouton rejouer ou Lancer une partie
 */
public class ControleurLancerPartie implements EventHandler<ActionEvent> {
    /**
     * modèle du jeu
     */
    private IA modelePuissance4;
    /**
     * vue du jeu
     **/
    private Puissance4 vuePuissance4;

    /**
     * @param modelePuissance4 modèle du jeu
     * @param p vue du jeu
     */
    public ControleurLancerPartie(IA modelePuissance4, Puissance4 vuePuissance4) {
        this.modelePuissance4 = modelePuissance4;
        this.vuePuissance4 = vuePuissance4;
    }

    /**
     * L'action consiste à recommencer une partie. Il faut vérifier qu'il n'y a pas une partie en cours
     * @param actionEvent l'événement action
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        // A implémenter
        return null;
    }
}
