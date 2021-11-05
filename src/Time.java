import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Time {

  private LocalDateTime startDateLocalDateTime;
  private DateTimeFormatter format;
  private Date startDate;

  public Time() {
    this.startDateLocalDateTime = LocalDateTime.now();
    this.format = DateTimeFormatter.ofPattern("dd-MM-yyy hh:mm:ss");
    this.startDate = new Date();
  }

  public LocalDateTime getStartDateLocalDateTime() {
    return startDateLocalDateTime;
  }

  public DateTimeFormatter getFormat() {
    return format;
  }

  public Date getStartDate() {
    return startDate;
  }

  public long calculateSeconds() {
    Date endDate   = new Date();
    long duration  = endDate.getTime() - startDate.getTime();
    long diffInMilliSeconds = TimeUnit.MILLISECONDS.toMillis(duration);
    long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(duration);
    return diffInSeconds;
  }

  public void printStartDate() {
    System.out.println(startDateLocalDateTime.format(format));
  }


}
