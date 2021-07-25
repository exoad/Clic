package src.main.schedulers;

import src.main.schedulers.FilePathHandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileScheduler {
  private File f;
  private FileReader fr;
  private FileWriter fw;
  private BufferedReader br;
  private BufferedWriter bw;
  private String li, toFile;

  public FileScheduler() {
    super();
  }
  
  // this void method stores the mainlabel value currently into a txt file
  public void storeMain(int t) {
    String userDat = Integer.toString(t);
    String oldDat = "";
    f = new File(FilePathHandler.SAVE_PATH.getPath() + "clicks.txt");
    try {
      if (!f.exists())
        f.createNewFile();
      br = new BufferedReader(new FileReader(f));
      li = br.readLine();
      while (li != null) {
        oldDat = oldDat + li + System.lineSeparator();
        li = br.readLine();
      }
      toFile = oldDat.replaceAll(oldDat, userDat);
      fw = new FileWriter(f);
      fw.write(toFile);
    } catch (IOException ev) {
      ev.printStackTrace();
    } finally {
      try {
        fw.close();
      } catch (IOException err) {
        err.printStackTrace();
      }
    }
  }
  
  // this is a void method and when called stores the current value of multX
  public void storeMult(int t) {
    String userDat = Integer.toString(t);
    String oldDat = "";
    f = new File(FilePathHandler.SAVE_PATH.getPath() + "mult.txt");
    try {
      if (!f.exists())
        f.createNewFile();
      br = new BufferedReader(new FileReader(f));
      li = br.readLine();
      while (li != null) {
        oldDat = oldDat + li + System.lineSeparator();
        li = br.readLine();
      }
      toFile = oldDat.replaceAll(oldDat, userDat);
      fw = new FileWriter(f);
      fw.write(toFile);
    } catch (IOException ev) {
      ev.printStackTrace();
    } finally {
      try {
        fw.close();
      } catch (IOException err) {
        err.printStackTrace();
      }
    }
  }
  
  // this void method stores the multcost var into a txt file of name USERMULTCOST
  public void storeMultCost(int t) {
    String userDat = Integer.toString(t);
    String oldDat = "";
    f = new File(FilePathHandler.SAVE_PATH.getPath() + "mult_cost.txt");
    try {
      if (!f.exists())
        f.createNewFile();
      br = new BufferedReader(new FileReader(f));
      li = br.readLine();
      while (li != null) {
        oldDat = oldDat + li + System.lineSeparator();
        li = br.readLine();
      }
      toFile = oldDat.replaceAll(oldDat, userDat);
      fw = new FileWriter(f);
      fw.write(toFile);
    } catch (IOException ev) {
      ev.printStackTrace();
    } finally {
      try {
        fw.close();
      } catch (IOException err) {
        err.printStackTrace();
      }
    }
  }

  // this method stores info on the objective cases to a text file
  public void storeObj(int t) {
    String userDat = Integer.toString(t);
    String oldDat = "";
    f = new File(FilePathHandler.SAVE_PATH.getPath() + "objs.txt");
    try {
      if (!f.exists())
        f.createNewFile();
      br = new BufferedReader(new FileReader(f));
      li = br.readLine();
      while (li != null) {
        oldDat = oldDat + li + System.lineSeparator();
        li = br.readLine();
      }
      toFile = oldDat.replaceAll(oldDat, userDat);
      fw = new FileWriter(f);
      fw.write(toFile);
    } catch (IOException ev) {
      ev.printStackTrace();
    } finally {
      try {
        fw.close();
      } catch (IOException err) {
        err.printStackTrace();
      }
    }
  }
  
  public int readMain() {
    try {
      String str;
      if (!new File(FilePathHandler.SAVE_PATH.getPath() + "clicks.txt").exists()) {
        return 0;
      }
      br = new BufferedReader(new FileReader(FilePathHandler.SAVE_PATH.getPath() + "clicks.txt"));

      while ((str = br.readLine()) != null) {
        return Integer.parseInt(str);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return 0;
  }

  public int readMult() {
    try {
      String str;
      if (!new File(FilePathHandler.SAVE_PATH.getPath() + "mult.txt").exists() || br.readLine() == null) {
        return 1;
      }
      br = new BufferedReader(new FileReader(FilePathHandler.SAVE_PATH.getPath() + "mult.txt"));

      while ((str = br.readLine()) != null) {
        return Integer.parseInt(str);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return 1;
  }

  public int readMultCost() {
    try {
      String str;
      if (!new File(FilePathHandler.SAVE_PATH.getPath() + "mult_cost.txt").exists() || br.readLine() == null) {
        return 100;
      }
      br = new BufferedReader(new FileReader(FilePathHandler.SAVE_PATH.getPath() + "mult_cost.txt"));

      while ((str = br.readLine()) != null) {
        return Integer.parseInt(str);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return 100;
  }

  public int readObj() {
    try {
      String str;
      if (!new File(FilePathHandler.SAVE_PATH.getPath() + "objs.txt").exists() || br.readLine() == null) {
        return 50;
      }
      br = new BufferedReader(new FileReader(FilePathHandler.SAVE_PATH.getPath() + "objs.txt"));

      while ((str = br.readLine()) != null) {
        return Integer.parseInt(str);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return 50;
  }

}
