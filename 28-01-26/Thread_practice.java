class A extends Thread {
    public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println("From A: " + i);
            }
    }
}
class B implements Runnable {
    
    public void run()  {
        for (int i = 1; i <= 9; i++) {
            System.out.println("From B: " + i);
        }
    }

}

public class Thread_practice {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        Runnable c = () -> {
            for (int i = 1; i <= 9; i++) {
                System.out.println("From C: " + i);
            }
        };
        a.setPriority(Thread.MIN_PRIORITY);
        a.start();
        Thread t = new Thread(b);
        t.start();
        Thread t1 = new Thread(c);
        t1.start();
    }
}
