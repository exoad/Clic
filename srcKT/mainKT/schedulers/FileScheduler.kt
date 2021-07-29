/**
 * A simple Clicker game.
 *
 * @author Jack Meng
 * @version 1.0z (EXP)
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
 */
package src.main.schedulers

import kotlin.Throws
import java.io.IOException
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.charset.Charset
import src.main.Runner
import java.io.FileWriter
import java.util.function.Consumer

class FileScheduler {
    private val fileDir = "click_game/"

    /**
     * @param clicks   the clicks value recieved at the time of the save action
     * @param mult     the multiplier current
     * @param multCost multiplier Cost at current tick
     * @param objs     objnum Number
     * @throws IOException
     */
    @Throws(IOException::class)
    fun write(clicks: Int, mult: Int, multCost: Int, objs: Int) {
        if (File(fileDir).isDirectory) {
            val msg = """
                ${Integer.toString(clicks)}
                ${Integer.toString(mult)}
                ${Integer.toString(multCost)}
                ${Integer.toString(objs)}
                
                """.trimIndent()
            Files.write(Paths.get(fileDir + "saves"), msg.toByteArray())
        }
    }

    fun readLineNumber(number: Int): String {
        if (File(fileDir + "saves").exists()) {
            var t = ""
            try {
                Files.lines(Paths.get(fileDir + "saves")).use { lines ->
                    t = lines.skip(number.toLong()).findFirst().get()
                    val f = Files.readAllLines(Paths.get(fileDir + "saves"), Charset.defaultCharset())
                    f.forEach(Consumer { m: String -> print("\nSuccess on reading: $m\n") })
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return t
        }
        return "0"
    }

    fun resetData(): Boolean {
        val fr = File(fileDir + "saves")
        if (fr.exists()) fr.delete()
        return true
    }

    @Throws(IOException::class)
    fun createNoticeFile() {
        Runner()
        Runner.initGameFolder()
        val s = File(fileDir + "NOTICE_PLEASE_READ.txt")
        val fw = FileWriter(s)
        fw.write(
                "EDIT THE CONTENTS OF FILES IN THIS FOLDER AT YOUR OWN RISK!\nPLEASE THE GITHUB WIKI HERE FOR MORE INFO: https://github.com/exoad/ClickGame/wiki\n\n\nYOU ARE RESPONSIBLE FOR ANY MISHANDLINGS")
        fw.close()
    }
}
