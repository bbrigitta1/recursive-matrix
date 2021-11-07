import java.math.BigInteger;
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

  public boolean checkIfAllDown() {
    for (int i=0; i<size; i++) {
      for (int j=0; j<matrix[i].length; j++) {
        Square actual = matrix[i][j];
        if (actual.getValue() == 1) {
          return false;
        }
      }
    }
    return true;
  }

  private void pointingSquares(Square squareToPoint){
    int points = 0;
    int act = squareToPoint.getValue();
    if (act == 1) {
      points += 1;
    } else {
      points -= 1;
    }
    for (Square neighbour : squareToPoint.getNeighBours()) {
      int a = neighbour.getValue();
      if (a == 1) {
        points += 1;
      } else {
        points -= 1;
      }
    }
    squareToPoint.setPoints(points);

  }

  public void pointing() {
    for (int i=0; i<size; i++) {
      for (int j=0; j<matrix[i].length; j++) {
        Square actual = matrix[i][j];
        pointingSquares(actual);
      }
    }
  }

  public BigInteger factorial(int n) {
    BigInteger result = BigInteger.ONE;
    for (int i=0; i<n; i++) {
      result = result.multiply(BigInteger.valueOf(i+1));
    }
    return result;
  }

  public BigInteger variationsWithoutRepetition(int n, int k) {
    return factorial(n).divide(factorial(k).multiply(factorial(n-k)));
  }

  public Square searchOneDownwards() {
    for (int i=0; i<size; i++) {
      for (int j=0; j< matrix[i].length; j++) {
        Square actual = matrix[i][j];
        int actualValue = actual.getValue();
        if (actualValue == 1 && i<5) {
          Square downSquare = matrix[i + 1][j];
          return downSquare;
        } else if (i == 5) {
          return null;
        }
      }
    }
    return null;
  }

  public Square selectRandomSquare() {
    int randomX = util.randomIntWithUpperBound(size);
    int randomY = util.randomIntWithUpperBound(size);
    return matrix[randomX][randomY];
  }

}
