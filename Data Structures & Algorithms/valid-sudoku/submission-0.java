class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // Check rows
        for (int i = 0; i < 9; i++) {
            boolean[] seen = new boolean[10];
            
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    
                    if (seen[num]) {
                        return false;
                    }
                    
                    seen[num] = true;
                }
            }
        }

        // Check columns
        for (int j = 0; j < 9; j++) {
            boolean[] seen = new boolean[10];
            
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    
                    if (seen[num]) {
                        return false;
                    }
                    
                    seen[num] = true;
                }
            }
        }

        // Check 3x3 sub-boxes
        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                boolean[] seen = new boolean[10];
                
                for (int i = boxRow; i < boxRow + 3; i++) {
                    for (int j = boxCol; j < boxCol + 3; j++) {
                        if (board[i][j] != '.') {
                            int num = board[i][j] - '0';
                            
                            if (seen[num]) {
                                return false;
                            }
                            
                            seen[num] = true;
                        }
                    }
                }
            }
        }

        return true;
    }
}