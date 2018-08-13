import java.util.ArrayList;

/**
 * Représente le philisophe ET son assiette.
 * L'assiete pourrait très bien être une autre classe, mais ça vaut pas la peine.
 */
public class Philosopher implements Runnable {

    /**
     * Les casseroles qui l'entourent
     */
    private Pan leftPan;
    private Pan rightPan;

    // Représente une assiette
    private ArrayList<Meatball> plate;

    public Philosopher(ArrayList<Meatball> plate, Pan left, Pan right) {
        this.plate = plate;
        this.leftPan = left;
        this.rightPan = right;
    }

    @Override
    public synchronized void run() {

        while (Meatball.total > 0) {

            // si son assiette est vide
            while (plate.isEmpty()) {

                // on prend ce qu'il y a dans la casserole de gauche
                plate = leftPan.takeAll();

                // si toujours rien, on attend
                if (plate.isEmpty()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

            // Ici, on est sur d'avoir des boulettes
            // Donc, on en prend une
            Meatball mb = plate.get(0);

            // On check si elle est chaude
            if (mb.isHot()) {
                // Bah on fait rien, on la mange !
                plate.remove(mb);
                Meatball.total--;
                continue;
            }

            // Si on est ici, notre boulette est froide ...
            // on la met dans la casserole de droite

            rightPan.put(mb);

            // Et on préviens tout le monde que une casserole à reçu une boulette !

            notifyAll();

        }

    }
}
