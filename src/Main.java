import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {
  public static void main(String[] args) {
    // 1. print the matrix
    Matrix matrix = new Matrix();
    matrix.printMatrix();
    System.out.println();

    // 2.print actual time
    LocalDateTime actualDateTime = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyy hh:mm:ss");
    System.out.println(actualDateTime.format(format));
  }
}
