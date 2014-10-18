public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;
        if (word.length() == 0)
            return true;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(board, i, j, m, n, 0, word, visited))
                    return true;
            }
        }
        return false;
    }
    
    public boolean exist(char[][] board, int row, int col, int m, int n, int index, String word, boolean[][] visited) {
        if (board[row][col] != word.charAt(index))
            return false;
        if (index == word.length() - 1) 
            return true;
        boolean found = false;
        visited[row][col] = true;
        if (col > 0 && visited[row][col-1] == false && exist(board, row, col - 1, m, n, index + 1, word, visited)) 
            return true;
        if (col < n - 1 && visited[row][col+1] == false && exist(board, row, col + 1, m, n, index + 1, word, visited)) 
            return true;
        if (row > 0 && visited[row-1][col] == false && exist(board, row - 1, col, m, n, index + 1, word, visited)) 
            return true;
        if (row < m - 1 && visited[row+1][col] == false && exist(board, row + 1, col, m, n, index + 1, word, visited))
            return true;
        visited[row][col] = false;
        return false;
    }
}