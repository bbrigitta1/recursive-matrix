import java.util.ArrayList;
import java.util.List;

public class Square {
  private int x;
  private int y;
  private int value;
  private boolean pressed;
  private List<Square> neighBours = new ArrayList<>();

  public Square(int x, int y, int value, boolean pressed) {
    this.x = x;
    this.y = y;
    this.value = value;
    this.pressed = pressed;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getValue() {
    return value;
  }

  public void setNeighBours(List<Square> neighBours) {
    this.neighBours = neighBours;
  }
}
