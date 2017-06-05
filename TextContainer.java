import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path="/tmp/file.txt")  // for linux
public class TextContainer {
    String str = "Some string";

    @Saver
    public void save(String path) {
        try (FileWriter writer = new FileWriter(new File(path));){
            writer.write(this.str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
