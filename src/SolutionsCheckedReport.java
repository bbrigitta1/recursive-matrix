import java.util.ArrayList;
import java.util.List;

public class SolutionsCheckedReport extends Thread {

  private boolean runReport = true;
  List<Square> stepsTaken;
  List<Square[]> combinations = new ArrayList<>();

  public void setRunReport(boolean runReport) {
    this.runReport = runReport;
  }

  public void setStepsTaken(List<Square> stepsTaken) {
    this.stepsTaken = stepsTaken;
  }

  public void setCombinations(List<Square[]> combinations) {
    this.combinations = combinations;
  }

  @Override
  public void run() {
    while (runReport) {
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      int counter = 0;
      for (Square[] combinations : combinations) {
        counter = counter + 1;
      }
      System.out.println("Number of solutions tried: " + counter);
    }
  }
}
