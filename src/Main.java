import java.math.BigInteger;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    List<Square> stepsTaken = new ArrayList<>();
    List<Square[]> combinations = new ArrayList<>();
    SolutionsCheckedReport report = new SolutionsCheckedReport();

    report.setStepsTaken(stepsTaken);
    report.setCombinations(combinations);
    report.start();

    // 1. create matrix, point squares and print the matrix
    Matrix matrix = new Matrix(3);

    // 2.print actual time
    Time time = new Time();
    time.printStartDate();

    //recursive
    matrix.combinationsWithoutRepetitions(combinations);

    //try with pointing the squares
    matrix.pointing();
    matrix.printMatrix();

    //try to switch down a row from the line below
    boolean allDown = matrix.checkIfAllDown();
    boolean searchUp = false;
    boolean searchDown = true;
    Scanner scanner = new Scanner(System.in);

    while(!allDown){
      if (matrix.checkIfAllDown()) {
        allDown = true;
        report.setRunReport(false);
      }
        while (searchDown) {
          String input = scanner.nextLine();
          if (input.isEmpty()) {
            Square squareToSwitch = matrix.searchOneDownwards();
            if (squareToSwitch != null) {
              matrix.switchFunction(squareToSwitch);
              stepsTaken.add(squareToSwitch);
            } else if (squareToSwitch == null && !matrix.checkIfAllDown()) {
              searchDown = false;
              searchUp = true;
            }
          }
          matrix.printMatrix();
        }
          while (searchUp) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
              Square squareToSwitchUp = matrix.searchOneUpwards();
              if (squareToSwitchUp != null && !matrix.checkIfAllDown()) {
                matrix.switchFunction(squareToSwitchUp);
                stepsTaken.add(squareToSwitchUp);
              } else if (squareToSwitchUp == null && !matrix.checkIfAllDown()) {
                searchDown = true;
                searchUp = false;
              }
            }
            matrix.printMatrix();
          }
        }

      }
    }


