public class ProducerConsumerTest {
    public static void main(String[] args){
        CubbyHole ch = new CubbyHole();

        Producer p1 = new Producer(1, ch);
        Consumer c1 = new Consumer(1, ch);

        p1.start();
        c1.start();

    }
}
