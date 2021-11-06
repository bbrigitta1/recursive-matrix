import java.util.*;

public class Main {
  public static void main(String[] args) {
    List<Square> stepsTaken = new ArrayList<>();
    SolutionsCheckedReport report = new SolutionsCheckedReport();
    report.setStepsTaken(stepsTaken);
    report.start();

    // 1. create matrix, point squares and print the matrix
    Util util = new Util();
    Matrix matrix = new Matrix();

    matrix.pointing();
    matrix.printMatrix();

    // 2.print actual time
    Time time = new Time();
    time.printStartDate();

    // 3. steps, for now it is random

    boolean allDown = matrix.checkIfAllDown();

    while(!allDown){
      if (matrix.checkIfAllDown()) {
        allDown = true;
        report.setRunReport(false);
      }
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
