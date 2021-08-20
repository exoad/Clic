/**
 * A simple Clicker game.
 * 
 * @author Jack Meng
 * @version 1.2 (EXP) (EXP)
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

import src.main.Runner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class ActionLogger {
  private final File fr;
  private final String cT;
  public boolean Wiped = false;

  public ActionLogger() throws IOException {
    super();
    LocalDate now = LocalDate.now();
    String date = now.toString();
    LocalTime rn = LocalTime.now();
    cT = rn.toString();
    fr = new File("click_game/logs/" + date + ".log");
    fr.createNewFile();
    Log("Created Log file");
    if (!new File("click_game/logs/").isDirectory()) {
      new Runner();
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
