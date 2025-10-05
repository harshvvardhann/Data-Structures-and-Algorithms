package Graphs;
import java.util.LinkedList;
import java.util.Queue;

class SurroundedRegions {
    Queue<int[]> queue = new LinkedList<>();
    public void solve(char[][] nums) {
        int m = nums.length;
        int n = nums[0].length; 

        for(int i=0;i<m;i++){
            dfs(nums,i,0,m,n);
            dfs(nums,i,n-1,m,n);
        }

        for(int j=0;j<n;j++){
            dfs(nums,0,j,m,n);
            dfs(nums,m-1,j,m,n);
        }


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(nums[i][j] == 'O'){
                    nums[i][j] = 'X';
                }
                if(nums[i][j] == '#'){
                    nums[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char nums[][],int row1,int col1,int m,int n){
        if(row1<0 || row1>=m || col1<0 || col1>=n || nums[row1][col1] != 'O') return;

        nums[row1][col1] = '#';
        queue.add(new int[]{row1,col1});

        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,-1,0,1};

        while(!queue.isEmpty()){
            int ar[] = queue.poll();
            int row = ar[0];
            int col = ar[1];

            for(int i=0;i<4;i++){
                int newar = row + delRow[i];
                int newcl = col + delCol[i];

                if(newar >=0 && newar<m && newcl>=0 && newcl<n && nums[newar][newcl] == 'O'){
                    nums[newar][newcl] = '#';
                    queue.add(new int[]{newar,newcl});
                }
            }
        }
    }
}
