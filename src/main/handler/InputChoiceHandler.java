package src.main.handler;

public class InputChoiceHandler {
  public InputChoiceHandler() {
    super();
  }
  /**
   * @param s is the input to check
   * @return returns the status code that which will be used to check
   */
  public int checkYN(String s) {
    if(s.equals("y") || s.equals("Y") || s.contains("y") || s.contains("Y"))
      return 0;
    else if(s.equals("n") || s.equals("N"))
      System.exit(1);
    return -1;

  }
}
