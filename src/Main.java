public class Main {
    public static void main(String[] args) {
        System.out.println("inside main method"); //1
        Thread t3 = new Thread3();
        t3.start(); //3 async task

        Thread t4 = new Thread(() -> {
            System.out.println("Thread4 is running");
        });
        t4.start();

        System.out.println("exiting main method");  //2

        String lock1 = "lock1";
        String lock2 = "lock2";

        Thread t5 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("lock2 acquired");
                }
            }
        });

        Thread t6 = new Thread(() -> {
            synchronized (lock2) {
                try{
                    Thread.sleep(2);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("lock1 acquired");
                }
            }
        });

        t5.start();
        t6.start();


    }
}