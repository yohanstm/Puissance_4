import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurParametre implements EventHandler<ActionEvent> {
    private Puissance4 vue;

    public ControleurParametre(Puissance4 vue) {
        this.vue = vue;
    }

    @Override
    public void handle(ActionEvent event) {
        vue.modeParametres();
    }
}
