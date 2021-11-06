import javax.print.attribute.standard.DateTimeAtCreation;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
  public static void main(String[] args) {
    // 1. create matrix, point squares and print the matrix
    Util util = new Util();
    Matrix matrix = new Matrix();

    matrix.pointing();
    matrix.printMatrix();

    // 2.print actual time
    Time time = new Time();
    time.printStartDate();

    // 3. steps, for now it is random
    List<Square> stepsTaken = new ArrayList<>();
    boolean allDown = matrix.checkIfAllDown();

    while(!allDown){
      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();

      if (input.isEmpty()) {

        int size = matrix.getSize();
        int randomX = util.randomIntWithUpperBound(size);
        int randomY = util.randomIntWithUpperBound(size);

        Square selectedSquare = matrix.getMatrix()[randomX][randomY];

        if (!selectedSquare.isPressed()) {
          matrix.switchFunction(selectedSquare);
          selectedSquare.setPressed(true);
          stepsTaken.add(selectedSquare);
        }
        matrix.printMatrix();
      }
    }
  }
}
