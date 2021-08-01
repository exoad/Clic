package src.main.schedulers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

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

  public void Log(String action) throws IOException {
      FileWriter fw = new FileWriter(fr, true);
      fw.write("\n[" + cT + "] " + action);

      fw.flush();
      fw.close();
  }

  // destroy all files
  public void wipeLogs() throws IOException {
    File fi = new File("click_game/logs/");
    for (File subfile : fi.listFiles()) {

      if (subfile.isDirectory())
        wipeLogs(subfile);

      subfile.delete();
    }
    Wiped = true;
  }

  public void wipeLogs(File xb) throws IOException {
    xb = new File("click_game/logs/");
    for (File subfile : xb.listFiles()) {

      if (subfile.isDirectory())
        wipeLogs(subfile);

      subfile.delete();
    }
    Wiped = true;
  }
}
