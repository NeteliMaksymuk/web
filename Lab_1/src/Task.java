import java.io.File;

public class Task implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
                + "start");
        new WorkWithFiles().search(new File(WorkWithFiles.CURRENT_FILE));
        System.out.println(Thread.currentThread().getName()
                + "end");
    }
}


