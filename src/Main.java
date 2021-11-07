import java.math.BigInteger;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    List<Square> stepsTaken = new ArrayList<>();
    SolutionsCheckedReport report = new SolutionsCheckedReport();
    report.setStepsTaken(stepsTaken);
    report.start();

    // 1. create matrix, point squares and print the matrix
    Matrix matrix = new Matrix();

    //idea - calculate the number of all possibilities, of switching 2 out of 36, it is a combination without repetition
    //System.out.println(matrix.variationsWithoutRepetition(36, 2)); // TODO check from 33 on

    matrix.pointing();
    matrix.printMatrix();

    // 2.print actual time
    Time time = new Time();
    time.printStartDate();

    // 3. steps, try to switch down a row from the line below

    boolean allDown = matrix.checkIfAllDown();

    while(!allDown){
      if (matrix.checkIfAllDown()) {
        allDown = true;
        report.setRunReport(false);
      }
      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();

      if (input.isEmpty()) {
        Square squareToSwitch = matrix.searchOneDownwards();
        if (squareToSwitch != null && !squareToSwitch.isPressed()) {
          matrix.switchFunction(squareToSwitch);
          squareToSwitch.setPressed(true);
          stepsTaken.add(squareToSwitch);
        } else if (squareToSwitch == null) {

        }
        matrix.printMatrix();
      }
    }
  }
}
