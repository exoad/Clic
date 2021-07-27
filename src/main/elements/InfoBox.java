package src.main.elements;

import java.util.Random;

public class InfoBox {
  private Random rd = new Random();
  public InfoBox() { super(); }

  public String randomNews() {
    // this method returns a random text
    String[] allNews = { "That is a lot of Clicks!", "Keep Clicking!", "Is there an end?", "Never stop clicking",
        "Clicking...Clicking...", "Click Click Click" };
    int i = rd.nextInt(allNews.length);
    return allNews[i];
  }
}
