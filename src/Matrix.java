import java.math.BigInteger;
import java.util.*;

public class Matrix {
  private Square[][] matrix;
  private int size;
  private int matrixSize;
  private Util util;


  public Matrix(int size) {
    this.size = size;
    this.matrixSize = size * size;
    this.matrix = new Square[size][size];
    util = new Util();
    createRandomMatrix(size);
    setSquareNeighbours();
    util = new Util();
  }

  public Matrix() {
    this.size = 6;
    this.matrixSize = size * size;
    this.matrix = new Square[6][6];
    createFixMatrix();
    setSquareNeighbours();
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
          if ((i + dir.x > -1 && i + dir.x < size) && (j + dir.y > -1 && j + dir.y < size)) {
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

  public Square selectRandomSquare() {
    int randomX = util.randomIntWithUpperBound(size);
    int randomY = util.randomIntWithUpperBound(size);
    return matrix[randomX][randomY];
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
        } else if (i == 5 && !checkIfAllDown()) {
          setRowToIdealPosition(i);
          return null;
        }
      }
    }
    return null;
  }

  public Square searchOneUpwards() {
    for (int i=size-1; i<size; i--) {
      for (int j=0; j< matrix[i].length; j++) {
        Square actual = matrix[i][j];
        int actualValue = actual.getValue();
        if (actualValue == 1 && i > 0) {
          Square upSquare = matrix[i - 1][j];
          return upSquare;
          //if last row and not AllSwitchedDown
        } else if (i == 0 && !checkIfAllDown()) {
          setRowToIdealPosition(i);
          return null;
        }
      }
    }
    return null;
  }

  public void setRowToIdealPosition(int rowIndex) {
    Square[] rowToSet = matrix[rowIndex];
    for (int i=0; i<rowToSet.length; i++) {
      //prevent indexError
      if (i != rowToSet.length-1) {
        int actualValue = rowToSet[i].getValue();
        //pattern to achieve: 1 0 1 0 1 0
        if ((i + 1) % 2 != 0) {
          if (actualValue == 0) {
            Square squareToSwitch = matrix[rowIndex][i + 1];
            switchFunction(squareToSwitch);
          }
        } else {
          if (actualValue == 1) {
            Square squareToSwitch = matrix[rowIndex][i + 1];
            switchFunction(squareToSwitch);
          }
        }
      }
    }
  }

  public List<Square> makeMatrixAsList() {
    Square[][] matrixCopy = matrix.clone();
    List<Square> matrixAsList = new ArrayList<>();

    for (int i=0; i<size; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        Square square = matrixCopy[i][j];
        matrixAsList.add(square);
      }
    }
    return matrixAsList;
  }

  public List<Square[]> combinationsWithoutRepetitions(List<Square[]> combinations) {
    List<Square> matrixAsList = makeMatrixAsList();
    for (int i=1; i<matrixSize+1; i++) {
      addCombination(matrixAsList, combinations, i, new Square[i], 0, matrixSize-1, 0);
    }
    return combinations;
  }


  public void addCombination(List<Square> matrix, List<Square[]> combinations, int i, Square[] combinationCollector, int start, int end, int index) {
    if (index == combinationCollector.length) {
      Square[] combination = combinationCollector.clone();
      combinations.add(combination);

      for (int j=0; j<combination.length; j++) {
        Square squareToSwitch = combination[j];
        switchFunction(squareToSwitch);
        util.scanner.nextLine();
        printMatrix();
      }

      if (checkIfAllDown()) {
        printMatrix();

        for (int j=0; j<combination.length; j++) {
          System.out.print("(" + combination[j].getX() + ", " + combination[j].getY() + ")");
        }
        System.out.println();
      } else {

        //switch back, if not ok
        for (int j=0; j<combination.length; j++) {
          Square squareToSwitch = combination[j];
          switchFunction(squareToSwitch);
        }
        System.out.println("Wrong solution!");
        printMatrix();
      }
    } else {
      int max = Math.min(end, end + 1 - combinationCollector.length + index);
      for (int k = start; k <= max; k++) {
        combinationCollector[index] = matrix.get(k);
        addCombination(matrix, combinations, i, combinationCollector, k + 1, end, index + 1);
      }
    }
  }



}
