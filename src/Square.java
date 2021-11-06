import java.util.ArrayList;
import java.util.List;

public class Square {
  private int x;
  private int y;
  private int value;
  private boolean pressed;
  private List<Square> neighBours = new ArrayList<>();
  private int points;

  public Square(int x, int y, int value, boolean pressed) {
    this.x = x;
    this.y = y;
    this.value = value;
    this.pressed = pressed;
    this.points = 0;
  }

  public int getValue() {
    return value;
  }

  public List<Square> getNeighBours() {
    return neighBours;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public boolean isPressed() {
    return pressed;
  }

  public void setNeighBours(List<Square> neighBours) {
    this.neighBours = neighBours;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  public void setPressed(boolean pressed) {
    this.pressed = pressed;
  }
}
