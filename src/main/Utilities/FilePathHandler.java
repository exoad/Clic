package Extra.Utilities;

public enum FilePathHandler {
  SAVE_PATH("click_game/");
  private final String val;
  FilePathHandler(String t) {
    this.val = t;
  }
  public String getPath() {
    return this.val;
  }
}
