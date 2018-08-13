import java.util.ArrayList;
import java.util.List;

public class Pan {

    /**
     * Représentation interne de la casserole
     */
    private ArrayList<Meatball> content;

    public Pan(ArrayList<Meatball> content) {
        this.content = content;
    }

    /**
     * Permet de récupérer toutes les boulettes de la casserole
     */
    public ArrayList<Meatball> takeAll() {
        ArrayList<Meatball> meatballs = this.content;
        this.content = new ArrayList<>();
        return meatballs;
    }

    /**
     * Permet de mettre une boulette dans la casserole.
     * On en profite pour augmenter sa temperature a se moment ci
     * @param meatball
     */
    public void put( Meatball meatball ) {
        meatball.heatUp();
        content.add(meatball);
    }
}
