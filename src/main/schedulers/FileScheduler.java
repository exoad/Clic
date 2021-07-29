package src.main.schedulers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;
import java.io.FileWriter;
import java.nio.charset.Charset;

import src.main.Runner;

public class FileScheduler {
  private String fileDir = "click_game/";

  public FileScheduler() {
    super();
  }

  /**
   * @param clicks the clicks value recieved at the time of the save action
   * @param mult the multiplier current
   * @param multCost multiplier Cost at current tick
   * @param objs objnum Number
   * @throws IOException
   */
  public void write(int clicks, int mult, int multCost, int objs) throws IOException {
    if (new File(fileDir).isDirectory()) {
      String msg = Integer.toString(clicks) + "\n" + Integer.toString(mult) + "\n" + Integer.toString(multCost) + "\n"
          + Integer.toString(objs) + "\n";
      Files.write(Paths.get(fileDir + "saves"), msg.getBytes());
    }
  }

  public String readLineNumber(int number) {
    if (new File(fileDir + "saves").exists()) {
      String t = "";
      try (Stream<String> lines = Files.lines(Paths.get(fileDir + "saves"))) {
        t = lines.skip(number).findFirst().get();
        List<String> f = Files.readAllLines(Paths.get(fileDir + "saves"), Charset.defaultCharset());
        f.forEach((m) -> {
          System.out.print("\nSuccess on reading: " + m + "\n");
        });
      } catch (IOException e) {
        e.printStackTrace();
      }
      return t;
    }
    return "0";
  }

  public boolean resetData() {
    File fr = new File(fileDir + "saves");
    if (fr.exists())
      fr.delete();
    return true;
  }

  public void createNoticeFile() throws IOException {
    new Runner();
    Runner.initGameFolder();
    File s = new File(fileDir + "NOTICE_PLEASE_READ.txt");
    FileWriter fw = new FileWriter(s);
    fw.write(
        "EDIT THE CONTENTS OF FILES IN THIS FOLDER AT YOUR OWN RISK!\nPLEASE THE GITHUB WIKI HERE FOR MORE INFO: https://github.com/exoad/ClickGame/wiki\n\n\nYOU ARE RESPONSIBLE FOR ANY MISHANDLINGS");
    fw.close();
  }

}
