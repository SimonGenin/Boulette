import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {

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
