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
package src.main.handler

enum class ImageHandler(val `val`: String) {
    MAIN_BTN("src/main/assets/RunnerPanel/main_click_button.png"), RNDCLR_BTN("src/main/assets/RunnerPanel/random_color_click_button.png"), RESET_BTN("src/main/assets/RunnerPanel/reset_save_click_button.png"), UPG_BTN("src/main/assets/RunnerPanel/upgrade_click_button.png"), MFRA_ICN("src/main/assets/RunnerPanel/mainframe_icon.png"), SAVE_BTN("src/main/assets/RunnerPanel/save_click_button.png"), BRWS_BTN("src/main/assets/HelpPanel/browser_click_button.png"), HLP_ICN("src/main/assets/HelpPanel/help_icon.png");

    fun getVal(): String? {
        th
    }

}
