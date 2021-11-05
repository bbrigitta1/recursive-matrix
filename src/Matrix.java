import java.util.Random;

public class Matrix {
  private Square[][] matrix;

  public Matrix(int size) {
    this.matrix = new Square[size][size];
    createRandomMatrix(size);
  }

  public Matrix() {
    this.matrix = new Square[6][6];
    createFixMatrix();
  }

  private void createRandomMatrix(int size) {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        Random rd = new Random();
        int randomValue = rd.nextInt(2);
        Square square = new Square(i, j, randomValue, false);
        matrix[i][j] = square;
      }
    }
  }

  private void createFixMatrix() {
    int[][] matrixBase = new int[][]{{1,0,0,1,0,1},{0,0,0,0,1,1},{1,1,1,0,1,0},{0,1,0,1,1,0},{0,0,1,1,0,1},{0,1,0,0,1,1}};
    for (int i = 0; i < matrixBase.length; i++) {
      for (int j = 0; j < matrixBase.length; j++) {
        int squareValue = matrixBase[i][j]
        Square square = new Square(i, j, squareValue, false);
        matrix[i][j] = square;
      }
    }
  }

}
