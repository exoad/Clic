package src.main.elements;

import java.awt.Color;

public class RndColor {
  public RndColor() {
    super();
  }
  public Color returnRND() {
    return new Color(returnTypeColor(), returnTypeColor(), returnTypeColor());
  }
  private int returnTypeColor() {
    return (int) Math.random() * 256;
  }
} 
