public class SolutionsCheckedReport extends Thread {

  private boolean runReport = true;

  public void setRunReport(boolean runReport) {
    this.runReport = runReport;
  }

  @Override
  public void run() {
    while (runReport) {
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Solutions tried: ");
    }
  }
}
