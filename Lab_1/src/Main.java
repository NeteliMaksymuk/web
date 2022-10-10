
// Знайти в заданій директорії всі файли, що містять вихідний код Java-програми,
// і переписати до іншого файлу їх вміст, видаливши всі види коментарів.
// Створені файли зберегти в новій директорії

//resources/files/dir_1
public class Main {
    public static void main(String[] args) {
        System.out.println("main Start");
        Thread myThread = new Thread(new Task());
        myThread.start();
        try {
            myThread.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main End");
    }
}