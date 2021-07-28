package src.main.schedulers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileScheduler {
  private String fileDir = "click_game/";

  public FileScheduler() {
    super();
  }

  public void write(int clicks, int mult, int multCost, int objs) throws IOException {
    String msg = Integer.toString(clicks) + "\n"+ Integer.toString(mult) + "\n" + Integer.toString(multCost) + "\n" + Integer.toString(objs) + "\n";
    Files.write(Paths.get(fileDir + "saves"), msg.getBytes());
  }
  public String readLineNumber(int number) {
    String t  = "";
    try (Stream<String> lines = Files.lines(Paths.get(fileDir + "saves"))) {
      t = lines.skip(number).findFirst().get();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return t;
  }
  public boolean resetData() {
    File fr = new File(fileDir + "saves");
    if(fr.exists())
      fr.delete();
      return true;
  }



}
