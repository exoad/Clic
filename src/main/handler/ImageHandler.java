package src.main.handler;

public enum ImageHandler {
  MAIN_BTN("src/main/assets/RunnerPanel/main_click_button.png"),
  RNDCLR_BTN("src/main/assets/RunnerPanel/random_color_click_button.png"),
  RESET_BTN("src/main/assets/RunnerPanel/reset_save_click_button.png"),
  UPG_BTN("src/main/assets/RunnerPanel/upgrade_click_button.png"),
  MFRA_ICN("src/main/assets/RunnerPanel/mainframe_icon.png"),
  SAVE_BTN("src/main/assets/RunnerPanel/save_click_button.png"),

  HLP_ICN("src/main/assets/HelpPanel/help_icon.png");

  private final String request;

  ImageHandler(String request) {
    this.request = request;
  }
  public String getVal() {
    return this.request;
  }
}
