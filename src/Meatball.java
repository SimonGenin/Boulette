import java.util.Random;

public class Meatball {

    // Temperature à laquelle on estime une boulette "chaude"
    private static final int HOT_THRESHOLD = 30;

    // Permet de garder une trace du nombre de boulette restante
    public static volatile int total;

    // Temperature actuelle
    private int temperature;

    // pour cuire les boulettes!
    private Random random = new Random();

    /**
     * Chauffe de quelques degrés une boulette
     */
    public void heatUp() {
        temperature += random.nextInt(4);
    }

    /**
     * Permet de savoir si une boulette est chaude ou pas
     */
    public boolean isHot () {
        return temperature >= HOT_THRESHOLD;
    }

}
