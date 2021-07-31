package src.main.schedulers;

import src.main.Runner;

import java.time.LocalDate;
import java.time.LocalTime;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class ActionLogger {
  private File fr; 
  private LocalDate now = LocalDate.now();
  private final String date, cT;
  private LocalTime rn = LocalTime.now();
  public ActionLogger() throws IOException {
    super();
    date = now.toString();
    cT = rn.toString();
    fr = new File("click_game/logs/"+ date +".log");
    fr.createNewFile();
    if (!new File("click_game/logs").isDirectory()) {
      new src.main.Runner();
      Runner.initGameFolder();
    } else if(!new File("click_game/logs/"+ date +".log").exists()) {
      fr.createNewFile();
    }
    
  }
  public void Log(String action) throws IOException {
    FileWriter fw = new FileWriter(fr, true);
    fw.write("\n[" + cT + "] " + action);

    fw.flush();
    fw.close();
  }
}
