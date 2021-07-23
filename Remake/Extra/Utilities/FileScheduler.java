package Extra.Utilities;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class FileScheduler {
  private File f;
  private FileReader fr;
  private FileWriter fw;
  private BufferedReader br;
  private BufferedWriter bw;

  public FileScheduler() {
  }

  public String initGameFolder() {
    f = new File("/click_game");
    if(!f.isDirectory())
      f.mkdir();
    else
      System.out.println("return 0");
    return "good.";
  }
  public String getPath(int callNum) {
    initGameFolder();
    if(callNum == 0) 
      return "clicks.txt";
    else if(callNum == 1)
      return "multiplier.txt";
    else if(callNum == 2)
      return "m_cost.txt";
    else if(callNum == 3) 
      return "objs.txt";
    return "-1";
  }
}
