import java.util.Random;

public class Util {

  private Random rd;

  public Util() {
    this.rd = new Random();
  }

  public int randomIntWithUpperBound(int upperBound) {
    return rd.nextInt(upperBound-1);
  }
}
