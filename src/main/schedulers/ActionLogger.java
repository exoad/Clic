package src.main.schedulers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import src.main.Runner;

public class ActionLogger {
  private File fr;
  private LocalDate now = LocalDate.now();
  private final String date, cT;
  public boolean Wiped = false;
  private LocalTime rn = LocalTime.now();

  public ActionLogger() throws IOException {
    super();
    date = now.toString();
    cT = rn.toString();
    fr = new File("click_game/logs/" + date + ".log");
    fr.createNewFile();
    Log("Created Log file");
    if (!new File("click_game/logs/").isDirectory()) {
      new src.main.Runner();
      Runner.initGameFolder();
    } else if (!new File("click_game/logs/" + date + ".log").exists()) {
      fr.createNewFile();
    }
  }

  /**
   * @param action the action that is to logged most use toString()
   * @throws IOException when something is caught
   */
  public < E > void Log(E action) throws IOException {
    FileWriter fw = new FileWriter(fr, true);
    fw.write("\n[" + cT + "] " + action);

    fw.flush();
    fw.close();
  }

  // destroy all files
  public void wipeLogs() throws IOException {
    File fi = new File("click_game/logs/");
    for (File subfile : Objects.requireNonNull(fi.listFiles())) {

      if (subfile.isDirectory())
        wipeLogs(subfile);

      subfile.delete();
    }
    Wiped = true;
  }

  /**
   * 
   * @param xb overloaded method
   * @throws IOException catch this exception when it is made
   */
  public void wipeLogs(File xb) throws IOException {
    xb = new File("click_game/logs/");
    for (File subfile : Objects.requireNonNull(xb.listFiles())) {

      if (subfile.isDirectory())
        wipeLogs(subfile);

      subfile.delete();
    }
    Wiped = true;
  }
}
