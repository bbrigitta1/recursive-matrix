import javax.print.attribute.standard.DateTimeAtCreation;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
  public static void main(String[] args) {
    // 1. print the matrix
    Util util = new Util();
    Matrix matrix = new Matrix();
    matrix.printMatrix();

    // 2.print actual time
    Time time = new Time();
    time.printStartDate();

    // 3. steps, for now it is random
    List<Square> stepsTaken = new ArrayList<>();
    boolean run = true;
    while(run){

      int size = matrix.getSize();
      int randomX = util.randomIntWithUpperBound(size);
      int randomY = util.randomIntWithUpperBound(size);

      Square selectedSquare = matrix.getMatrix()[randomX][randomY];

      stepsTaken.add(selectedSquare);
      matrix.switchFunction(selectedSquare);
      matrix.printMatrix();

      long secondsPassed = time.calculateSeconds();
      System.out.println("passed ms: " + secondsPassed);
      long remainder = secondsPassed % 10;
      System.out.println("remainder: " + remainder);

      if (remainder == 0.0) {
        System.out.println("taken steps: " + stepsTaken.size());
      }

      //create a point to step out
      if (stepsTaken.size() == 100000) {
        run = false;
      }
    }

  }
}
