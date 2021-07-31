package src.main.elements;

public enum DefaultValues {
  // 225, 229, 230
  COLORS_R(225),
  COLORS_G(229),
  COLORS_B(230);

  private final int val;

  DefaultValues(int val) {
    this.val = val;
  }
  public int getColor() {
    return this.val;
  }
}
