/**
 * A simple Clicker game.
 * 
 * @author Jack Meng
 * @version 1.2 (EXP)
 * 
 * BSD 3-Clause License
 * 
 * Copyright (c) 2021, Jack Meng
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * 
 * 3. Neither the name of the copyright holder nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * 
 */

package src.main.schedulers;

import main.Runner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileScheduler {
  private final String fileDir = "click_game/";

  public FileScheduler() {
    super();
  }

  /**
   * @param clicks   the clicks value recieved at the time of the save action
   * @param mult     the multiplier current
   * @param multCost multiplier Cost at current tick
   * @param objs     objnum Number
   * @throws IOException an exception when it is encountered
   */
  public void write(int clicks, int mult, int multCost, int objs, int displayUpgrade) throws IOException {
    if (new File(fileDir).isDirectory()) {
      String msg = clicks + "\n" + mult + "\n" + multCost + "\n"
          + objs + "\n" + displayUpgrade + "\n";
      Files.write(Paths.get(fileDir + "saves"), msg.getBytes());
    }
  }

  public String readLineNumber(int number) {
    if (new File(fileDir + "saves").exists()) {
      String t = "";
      try (Stream<String> lines = Files.lines(Paths.get(fileDir + "saves"))) {
        t = lines.skip(number).findFirst().get();
        List<String> f = Files.readAllLines(Paths.get(fileDir + "saves"), Charset.defaultCharset());
        f.forEach((m) -> System.out.print("\nSuccess on reading: " + m + "\n"));
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

  /**
   * @param number is the line number to be read
   * @param typ the file directory to be read, specifically the directory
   * @return the final value
   */
  public String readLineNumber(int number, File typ) {
    if (typ.exists()) {
      String t = "";
      try (Stream<String> lines = Files.lines(Paths.get(typ.toString()))) {
        t = lines.skip(number).findFirst().get();
        List<String> f = Files.readAllLines(Paths.get(typ.toString()), Charset.defaultCharset());
        f.forEach((m) -> System.out.print("\nSuccess on reading: " + m + "\n"));
      } catch (IOException e) {
        e.printStackTrace();
      }
      return t;
    }
    return "0";
  }
}
