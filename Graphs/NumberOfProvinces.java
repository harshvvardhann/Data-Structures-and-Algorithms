package Graphs;
class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean visited[] = new boolean[n];
        int count = 0;
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                count++;
                dfs(isConnected,visited,i);
            }
        }

        return count;
    }

    public void dfs(int isConnected[][],boolean visited[],int i){
        visited[i] = true;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j] == 1 && !visited[j]){
                dfs(isConnected,visited,j);
            }
        }
    }
}