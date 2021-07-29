package src.main.handler;

public enum ImageHandler {
  MAIN_BTN("src/main/assets/main_click_button.png"),
  RNDCLR_BTN("src/main/assets/random_color_click_button.png"),
  RESET_BTN("src/main/assets/reset_save_click_button.png"),
  UPG_BTN("src/main/assets/upgrade_click_button.png"),
  MFRA_ICN("src/main/assets/mainframe_icon.png"),
  SAVE_BTN("src/main/assets/save_click_button.png");

  private final String request;

  ImageHandler(String request) {
    this.request = request;
  }
  public String getVal() {
    return this.request;
  }
}
