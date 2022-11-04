import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class helpclass {
    private static String NEW_PATH = "resources/results";

    private static boolean IS_COMMENT_BIGGER_THEN_ONE_LINE = false;

    static void createNewDirWithModifyFiles(File file) {
        List<String> infoFromInputFile = getInfoFromFile(file);

        File newDir = new File(NEW_PATH);
        if (!newDir.exists()) {
            System.out.println("Створено директорію для результуючих файлів");
            newDir.mkdir();
        }
        File newFile = createNewFile();
        writeChangedInfoToFile(newFile, infoFromInputFile);
    }

    private static List<String> getInfoFromFile(File file) {
        List<String> infoFromInputFile;
        try {
            infoFromInputFile = Files.readAllLines(Path.of(file.getPath()));
        } catch (IOException e) {
            throw new RuntimeException("Не можемо прочитати файл ", e);
        }
        return infoFromInputFile;
    }

    private static File createNewFile() {
        File newFile = new File(NEW_PATH + "/resultFile" + Thread.currentThread().getName() + ".java");
        try {
            newFile.createNewFile();
            System.out.println("Файл з результатом створений  " + Thread.currentThread().getName() );

        } catch (IOException e) {
            throw new RuntimeException("Не можна створити файл", e);
        }
        return newFile;
    }

    private static void writeChangedInfoToFile(File newFile, List<String> infoFromInputFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile.getPath(), true))) {
            for (String line : infoFromInputFile) {
                String result=RemoveComments(line);
                bufferedWriter.write(result + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Не можа записати файл " + newFile.getPath(), e);
        }
    }

    private static String RemoveComments(String str){
        if (str.contains("//")){
            return new StringBuilder(str).delete(str.indexOf("//"),str.length()).toString();
        }else if (str.startsWith("/*") && str.endsWith("*/") ){
            return new StringBuilder(str).delete(0,str.indexOf("*/")+2).toString();
        }else if (str.startsWith("/*")){
            IS_COMMENT_BIGGER_THEN_ONE_LINE = true;
            return new StringBuilder(str).delete(0,str.length()).toString();
        }else if (IS_COMMENT_BIGGER_THEN_ONE_LINE){
            if (str.endsWith("*/")){
                IS_COMMENT_BIGGER_THEN_ONE_LINE=false;
                return new StringBuilder(str).delete(0,str.length()).toString();
            }
            return new StringBuilder(str).delete(0,str.length()).toString();
        }
        return str;

    }
}
