import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;


/**
 * Permet de gérer un Text associé à une Timeline pour afficher un temps écoulé
 */
public class Chronometre extends Text{
    /**
     * timeline qui va gérer le temps
     */
    private Timeline timeline;
    /**
     * la fenêtre de temps
     */
    private KeyFrame keyFrame;
    /**
     * le contrôleur associé au chronomètre
     */
    private ControleurChronometre actionTemps;

    /**
     * Temps écoulé en millisecondes
     */
    private long tempsMillisec;

    /**
     * Constructeur permettant de créer le chronomètre
     * avec un label initialisé à "0:0:0"
     * Ce constructeur créer la Timeline, la KeyFrame et le contrôleur
     */
    public Chronometre(){
        super("0:0");
        this.setFont(new Font(20));  // Taille de la police, ajustez selon les besoins
        this.setTextAlignment(TextAlignment.CENTER);
        tempsMillisec = 0;
        actionTemps = new ControleurChronometre(this);
        keyFrame = new KeyFrame(Duration.seconds(1), e -> {
            tempsMillisec += 1000;
            setTime(tempsMillisec);
        });
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    /**
     * Permet au controleur de mettre à jour le text
     * la durée est affichée sous la forme m:s
     * @param tempsMillisec la durée depuis à afficher
     */
    public void setTime(long tempsMillisec){
        // A implémenter
        long seconds = (tempsMillisec / 1000) % 60;
        long minutes = (tempsMillisec / 1000) / 60;
        this.setText(String.format("%d:%02d", minutes, seconds));
    }

    /**
     * Permet de démarrer le chronomètre
     */
    public void start(){
        timeline.play();
    }

    /**
     * Permet d'arrêter le chronomètre
     */
    public void stop(){
        timeline.stop();
    }

    /**
     * Permet de remettre le chronomètre à 0
     */
    public void resetTime(){
        timeline.stop();
        tempsMillisec = 0;
        setTime(tempsMillisec);
    }
}
