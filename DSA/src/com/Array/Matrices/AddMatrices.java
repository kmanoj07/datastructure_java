package com.Array.Matrices;

public class AddMatrices {
    public static int[][] solve(int[][] A, int[][] B) {
        int row = A.length;
        int col = A[0].length;
        int ans[][] = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                ans[i][j] = A[i][j] + B[i][j];
            }
        }
        printMat(ans);
        return ans;
    }
    public static void printMat(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        for(int i = 0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(A[i][j] + " ");
            }System.out.println();
        }

    }
    
    public static void leftTorigthDiagonal(int[][] A) {
        int n = A.length;
        int i = 0;
        int j = 0;
        while(i<n && j<n){
            System.out.print(A[i][j]);
            i++;
            j++;
        }System.out.println();
    }

    public static void rightToleftDigonal(int[][] A) {
        int n = A.length;
        int col = n-1;
        int row = 0;
        while (row < n && col >= 0) {
            System.out.print(A[row][col]);
            row++;
            col--;
        }System.out.println();
    }

    public static void antiDiognal(int[][] A) {
        int n = A.length;
        for(int i =0;i<n;i++){
            int row = 0;
            int col = i;
            while (col >= 0 && row < n) {
                System.out.println(A[row][col]);
                col--;
                row++;
            }
        }
    }

    public static int[] columnSum (int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[] ans = new int[m];
        for(int col = 0; col <m; col++){
            int sum = 0;
            for(int row= 0; row < n; row++){
                sum = sum + A[row][col];
            }
            ans[col] = sum;
        }
        return ans;
    }

    public static int[][] transpose(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<m;j++){
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        return A;
    }
    
    public static void printArr(int[] A) {
        int n = A.length;
        for(int i=0;i<n;i++){
            System.out.print(A[i] + " ");
        }System.out.println();
    }

    public static void printArr(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(A[i][j] + " ");
            } System.out.println();
        }
    }

    public static void rotate90inSqrmat(int[][] A) {
        int n = A.length;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++){
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp; 
            }
        }
        for(int i=0;i<n;i++){
            int s = 0;
            int e = n-1;
            while(s < e){
                int temp = A[i][s];
                A[i][s] = A[i][e];
                A[i][e] = temp;
                s++;
                e--;
            }
        }
        printArr(A);
    }

    public static void rotateMatrix(int[][] A) {
        //N*M square matric transpose
        int n = A.length;
        int m = A[0].length;
        int[][] arrTranspose = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++){
                arrTranspose[i][j] = A[j][i]; 
            }
        }
        //printArr(arrTranspose);
        //System.out.println("Reverser the array ! ..");
        //reverse the row
        for(int i=0;i<n;i++){
            int s = 0;
            int e = n-1;
            while(s < e){
                int temp = arrTranspose[i][s];
                arrTranspose[i][s] = arrTranspose[i][e];
                arrTranspose[i][e] = temp;
                s++;
                e--;
            }
        }
        //printArr(arrTranspose);
    }
    
    public static void matrixMultiplication(int[][] A, int[][] B) {
        int rowA = A.length;
        int colA = A[0].length;

        int rowB = B.length;
        int colB = B[0].length;
        int sum = 0;
        if(colA == rowB){
            //result matrix
            int[][] ans = new int[rowA][colB];
            int rans = ans.length;
            int cans = ans[0].length;
            for(int i=0;i<rans;i++) {
                for(int j=0;j<cans;j++){
                    for(int k = 0; k<rowA; k++) {
                         sum =  sum + (A[i][k]) * (B[k][j]);
                    }
                    ans[i][j] = sum;
                    sum = 0;
                }
            }
            printArr(ans);
        } else {
            System.out.println("Multiplication not possible");
        }
    }

    public static void printSpiralMatrix(int[][] A) {
        int n = A.length;
        int row = 0;
        int col = 0;

        while(col < n ){
            System.out.print(A[row][col]);
            col++;
        }

        for(int k=1; k<n; k++){
            System.out.print(A[row][col]);
            row++;
        }
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3},
                     {4, 5, 6},
                     {7, 8, 9}};
        //leftTorigthDiagonal(A);
        //rightToleftDigonal(A);
        //antiDiognal(A);
        //int[][] B = {{1,2,3,4},{5,6,7,8},{9,2,3,4}};
        //int[] colSum = columnSum(B);
        //printArr(colSum);
        int[][] B = {{9, 8, 7},
                     {6, 5, 4},
                     {3, 2, 1}};
        // int[][] C = solve(A, B);

        //int[][] At = transpose(A);
        //printArr(At);
        //rotate90inSqrmat(B);

        //matrixMultiplication(A, B);
        int[][] s = {{1,2,3,4},
                     {5,6,7,8}, 
                     {9,10,11,12}, 
                     {13,14,15,16}
                    };
        printSpiralMatrix(A);
     }
}
