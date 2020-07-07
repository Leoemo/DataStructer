import java.io.*;

public class SparseMatrix {

    private static final long serialVersionUID = 264645486L;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int[][] data = new int[7][7];
        data[1][2] = 1;
        data[2][3] = 1;
        data[3][5] = 2;
        data[4][5] = 1;
        SparseMatrix s = new SparseMatrix();
        //获取稀疏矩阵,并输出到本地文件SparseMatrix.data
        int[][] ints = s.fullToSparseMatrix(data);
        s.showMatrix(ints);
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("SparseMatrix.data"));
        os.writeObject(ints);
        os.close();
        //从本地文件输入data文件，转换为全矩阵

        ObjectInputStream osi = new ObjectInputStream(new FileInputStream("SparseMatrix.data"));
        int[][] readObject = (int[][])osi.readObject();
        int[][] fullMatrix = s.sparseToFullMatrix(readObject);
        s.showMatrix(fullMatrix);
        osi.close();

    }

    /*
    稀疏矩阵转换为全矩阵
     */
    public int[][] sparseToFullMatrix(int[][] a){
        int fullMatrix[][] = new int[a[0][1]][a[0][1]];
        for(int i = 1;i <= a[0][2];i++){
            fullMatrix[a[i][0]][a[i][1]] = a[i][2];
        }

        return fullMatrix;
    }

    /*
    全矩阵转换为稀疏矩阵
     */

    public int[][]fullToSparseMatrix(int[][] a){
        int sum = 0;
        for(int[] rows : a){
            for(int column : rows){
                if(column != 0)
                    sum ++;
            }
        }
        int[][] sparseMatrix = new int[sum+1][3];
        sparseMatrix[0][0] = a.length;
        sparseMatrix[0][1] =a[0].length;
        sparseMatrix[0][2] = sum;

        int count = 1;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(a[i][j] != 0 ){
                    sparseMatrix[count][0] = i;
                    sparseMatrix[count][1] = j;
                    sparseMatrix[count][2] = a[i][j];
                    count ++;
                }
            }
        }
        return sparseMatrix;
    }

    /*
    显示矩阵的通用方法
     */
    public void showMatrix(int[][] a ){
        for(int i=0;i<a.length;i++){
            for(int j = 0 ;j<a[0].length;j++){
                System.out.print(a[i][j]);
            }
            System.out.println();
        }

    }

}
