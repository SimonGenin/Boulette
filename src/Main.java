import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        final int NUMBER = 999;

        Pan[] pans = new Pan[999];

        for (int i = 0; i < 999; i++) {

            pans[i] = new Pan(/* mettre des boulettes */);

        }

        Philosopher[] philos = new Philosopher[999];


        for (int i = 0; i < 999; i++) {

            if (i != 998) {
                philos[i] = new Philosopher(new ArrayList<>(), pans[i], pans[i + 1]);
            }
            else {
                philos[i] = new Philosopher(new ArrayList<>(), pans[998], pans[0]);
            }

        }


        ArrayList content1 = new ArrayList();
        content1.add(new Meatball());
        content1.add(new Meatball());
        content1.add(new Meatball());

        ArrayList content2 = new ArrayList();
        content2.add(new Meatball());
        content2.add(new Meatball());
        content2.add(new Meatball());

        ArrayList content3 = new ArrayList();
        content3.add(new Meatball());
        content3.add(new Meatball());
        content3.add(new Meatball());

        Pan p1 = new Pan(content1);
        Pan p2 = new Pan(content2);
        Pan p3 = new Pan(content3);

        Meatball.total = 9;

        Philosopher one = new Philosopher(new ArrayList<>(), p3, p1);
        Philosopher two = new Philosopher(new ArrayList<>(), p1, p2);
        Philosopher three = new Philosopher(new ArrayList<>(), p2, p3);

        Thread t1 = new Thread(one);
        t1.start();

        Thread t2 = new Thread(two);
        t2.start();

        Thread t3 = new Thread(three);
        t3.start();

    }

}
