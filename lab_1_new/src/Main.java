import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {


    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Введіть директорію:");
            final String directoryPath = reader.readLine();
            reader.close();

            File directory = new File(directoryPath);

            if (directory.exists() && directory.isDirectory()) {
                processDirectory(directory);
            }
            else {
                System.out.println("Такої директорії не існує або то файл");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }}
    private static void processDirectory(File directory) {
        //  Отримуємо список доступних файлів в директорії
        File[] files = directory.listFiles();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (final File f : files) {
            if (f.getName().endsWith(".java")) {
                System.out.println("Файл .java було знайдено");
                service.execute(new Runnable() {
                    @Override
                    public void run() {
                        helpclass.createNewDirWithModifyFiles(f);

                        System.out.println("Потік: " + Thread.currentThread().getName() + ". Файл: " + f.getName() );
                    }
                });
            } }

        service.shutdown();

        try {
            service.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

