import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Contrôleur à activer lorsque l'on clique sur le bouton info
 */
public class ControleurInfos implements EventHandler<ActionEvent> {
    private Puissance4 appliPuissance4;

    /**
     * @param p vue du jeu
     */
    public ControleurInfos(Puissance4 appliPuissance4) {
        this.appliPuissance4 = appliPuissance4;
    }

    /**
     * L'action consiste à afficher une fenêtre popup précisant les règles du jeu.
     * @param actionEvent l'événement action
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        this.appliPuissance4.popUpReglesDuJeu().showAndWait();
    }
}
