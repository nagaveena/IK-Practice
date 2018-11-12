import java.util.*;
public class NumberOfIslands {
	public class Node{
		int row;
		int col;
		
		public Node(int r , int c) {
			row =r;
			col =c;
		}
	}
	public int countIslands(int [][] grid) {
		int count  = 0;
		int tot_rows = grid.length;
		int tot_cols = grid[0].length;
		int[][] visited = new int[tot_rows][tot_cols];
		for(int r = 0 ; r < tot_rows; r++) {
			for(int c = 0; c < tot_cols ; c++) {
				
				if(visited[r][c] == 0 && grid[r][c] == 1) {
					dfs(grid,visited,r,c);
					count++;
				}
			}
		}
		return count;
	
	}
	public void dfs(int [][] grid,int [][] visited,int row,int col) {
		visited[row][col] = 1;
		for(Node neighbor : findNeighbors(grid,row,col,visited)) {
			dfs(grid,visited,neighbor.row,neighbor.col);
		}
	}
 public List<Node> findNeighbors(int [][]grid,int row,int col,int [][]visited){
	 List<Node> neighbors =  new ArrayList<Node>();
	 int[] valid_rows = {0,1,0,-1};
	 int [] valid_cols = {-1,0,1,0};
	 for(int i =0; i < valid_rows.length  ;i++) {
		int  r = row+valid_rows[i];
		int  c = col+valid_cols[i];
		if( r > 0  && r < grid.length &&   c> 0  && c < grid[0].length) {
		   if(visited[r][c]== 0 && grid[r][c] == 1) {
			   System.out.println("r:" + r + "c:" + c);
			neighbors.add(new Node(r,c));
		 }
		}
	 }
	 return neighbors;
	 
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int [][] grid = { {0,1,1,0,0}, 
    		           {0,0,1,0,0}, 
    		           {0,0,1,0,0},
    		           {1,0,0,0,0},
    		           {1,1,0,0,0}
    		           };
                  
	
	NumberOfIslands numOfIsl = new NumberOfIslands();
	int cnt = numOfIsl.countIslands(grid);
	System.out.println("cnt:" +cnt);
	
	
	
	
  }
}
