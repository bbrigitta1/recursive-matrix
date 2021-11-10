import java.util.Random;
import java.util.Scanner;

public class Util {

  private Random rd;
  Scanner scanner;

  public Util() {
    this.rd = new Random();
    this.scanner = new Scanner(System.in);
  }

  public int randomIntWithUpperBound(int upperBound) {
    return rd.nextInt(upperBound-1);
  }
}
