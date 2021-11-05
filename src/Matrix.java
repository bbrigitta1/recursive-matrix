import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Matrix {
  private Square[][] matrix;
  private int size;
  private Util util;

  public Matrix(int size) {
    this.size = size;
    this.matrix = new Square[size][size];
    createRandomMatrix(size);
    setSquareNeighbours();
    util = new Util();
  }

  public Matrix() {
    this.size = 6;
    this.matrix = new Square[6][6];
    createFixMatrix();
    setSquareNeighbours();
  }

  public int getSize() {
    return size;
  }

  public Square[][] getMatrix() {
    return matrix;
  }

  private void createRandomMatrix(int size) {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        int randomValue = util.randomIntWithUpperBound(2);
        Square square = new Square(i, j, randomValue, false);
        matrix[i][j] = square;
      }
    }
  }

  private void createFixMatrix() {
    int[][] matrixBase = new int[][]{{1,0,0,1,0,1},{0,0,0,0,1,1},{1,1,1,0,1,0},{0,1,0,1,1,0},{0,0,1,1,0,1},{0,1,0,0,1,1}};
    for (int i = 0; i < matrixBase.length; i++) {
      for (int j = 0; j < matrixBase.length; j++) {
        int squareValue = matrixBase[i][j];
        Square square = new Square(i, j, squareValue, false);
        matrix[i][j] = square;
      }
    }
  }

  private void setSquareNeighbours() {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        Square actualSquare = matrix[i][j];
        List<Direction> directions = Arrays.asList(Direction.values());
        List<Square> neighbours = new ArrayList<>();
        for (Direction dir : directions) {
          if ((i + dir.x > -1 && i + dir.x < 6) && (j + dir.y > -1 && j + dir.y < 6)) {
            neighbours.add(matrix[i + dir.x][j + dir.y]);
          }
        }
        actualSquare.setNeighBours(neighbours);
      }
    }
  }

  public void printMatrix() {
    for (Square[] row : matrix) {
      for(Square square : row) {
        System.out.print(square.getValue());
      }
      System.out.println();
    }
    System.out.println();
  }

  public void switchFunction(Square squareSelected) {
    switcher(squareSelected);
    for (Square neighbour : squareSelected.getNeighBours()) {
      switcher(neighbour);
    }

  }

  private void switcher(Square squareToSwitch) {
    int actSquareValue = squareToSwitch.getValue();
    if (actSquareValue == 1) {
      squareToSwitch.setValue(0);
    } else if (actSquareValue == 0) {
      squareToSwitch.setValue(1);
    }
  }



}
