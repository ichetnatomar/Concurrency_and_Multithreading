public class WorkerThread implements Runnable {
    private int taskNo;

    public WorkerThread(int taskNo) {
        this.taskNo = taskNo;
    }

    @Override
    public void run() {
        System.out.println("Worker " + Thread.currentThread().getName() + " started with task: " + taskNo);
    }
}
