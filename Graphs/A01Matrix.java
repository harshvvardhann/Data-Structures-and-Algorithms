package Graphs;
import java.util.LinkedList;
import java.util.Queue;

class A01Matrix { // original problem name -> 01 Matrix (542)
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int matrix[][] = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    matrix[i][j] = 0;
                    queue.add(new int[]{i,j});
                }else{
                    matrix[i][j] = -1;
                }
            }
        }

        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,-1,0,1};

        while(!queue.isEmpty()){
            int arr[] = queue.poll();
            int row = arr[0];
            int col = arr[1];
            for(int i=0;i<4;i++){
                int rw = row + delRow[i];
                int cl = col + delCol[i];
                if(rw>=0 && rw<m && cl>=0 && cl<n && matrix[rw][cl] == -1){
                    matrix[rw][cl] = matrix[row][col] + 1;
                    queue.add(new int[]{rw,cl});
                }
            }
        }

        return matrix;
    }
}