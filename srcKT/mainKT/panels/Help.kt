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
package src.main.panels

import src.main.handler.ImageHandler
import java.awt.Component
import java.lang.Exception
import java.net.URI
import java.net.URL

/*
 * Awaiting Packages
 * import java.io.*;
 * import java.util.*;
 * import java.awt.event.*;
 */
class Help : JPanel(), Runnable, ActionListener {
    private val frame: JFrame
    private val VIEWMENU: JButton
    override fun run() {
        frame.pack()
        frame.setVisible(true)
    }

    fun askRun() {
        Help().run()
    }

    override fun actionPerformed(ex: ActionEvent) {
        // open the help menu in the client's default browser
        if (ex.getSource() === VIEWMENU) {
            try {
                openWebpage(URL("https://github.com/exoad/ClickGame/wiki"))
            } catch (e: MalformedURLException) {
                println("Something went horribly wrong when trying to open the Help Menu in your default browser!\n\n\n")
                e.printStackTrace()
            }
        }
    }

    companion object {
        fun openWebpage(uri: URI?): Boolean {
            val desktop: Desktop? = if (Desktop.isDesktopSupported()) Desktop.getDesktop() else null
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    desktop.browse(uri)
                    return true
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            return false
        }

        fun openWebpage(url: URL): Boolean {
            try {
                return openWebpage(url.toURI())
            } catch (e: URISyntaxException) {
                e.printStackTrace()
            }
            return false
        }
    }

    init {
        frame = JFrame("Help Menu")
        val templar2 = ImageIcon(ImageHandler.HLP_ICN.getVal())
        val VMENU: Icon = ImageIcon(ImageHandler.BRWS_BTN.getVal())
        frame.setIconImage(templar2.getImage())
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE)
        val title = JLabel("--View Menu In Your Default Browser--")
        title.setAlignmentX(Component.CENTER_ALIGNMENT)
        VIEWMENU = JButton("View Help", VMENU)
        VIEWMENU.setAlignmentX(Component.CENTER_ALIGNMENT)
        VIEWMENU.setBackground(Color.ORANGE)
        VIEWMENU.addActionListener(this)
        setLayout(BoxLayout(this, BoxLayout.Y_AXIS))
        setPreferredSize(Dimension(300, 100))
        add(title)
        add(VIEWMENU)
        frame.add(this)
    }
}
