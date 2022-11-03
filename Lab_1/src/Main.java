
// Знайти в заданій директорії всі файли, що містять вихідний код Java-програми,
// і переписати до іншого файлу їх вміст, видаливши всі види коментарів.
// Створені файли зберегти в новій директорії

import java.util.concurrent.*;

//resources/files/dir_1
public class Main {
    public static void main(String[] args) {
        WorkWithFiles workWithFiles = new WorkWithFiles();
        workWithFiles.startSearchingInFiles();
    }
}