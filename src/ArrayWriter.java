import java.util.Random;

public class ArrayWriter {
    public int n;
    public int[][] arr = new int[n][n];

    public ArrayWriter(int n) {
        this.n = n;


    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int[][] getArr() {
        return arr;
    }

    public void setArr(int[][] arr) {
        this.arr = arr;
    }
    //заполнение матрицы
    public static int[][] createArray(int n){
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Random random = new Random();
                arr[i][j] = random.nextInt(10);
            }
        }
        return arr;
    }

    public static void soutArr(int[][] arr){
        //System.out.print("|");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("|");
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
                if(j != arr.length - 1) {
                    System.out.print(" ");
                }
                else System.out.println("|");
            }
            System.out.print("\n");
        }

    }

    public static int[][] sumOfArray(int[][] arr1, int[][] arr2){
        int[][] arr3 = new int[arr1.length][arr1.length];
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3.length; j++) {
                arr3[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return arr3;
    }

}
