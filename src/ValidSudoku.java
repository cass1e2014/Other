import java.util.HashSet;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules. The
 * Sudoku board could be partially filled, where empty cells are filled with the
 * character '.'. A partially filled sudoku which is valid. Note: A valid Sudoku
 * board (partially filled) is not necessarily solvable. Only the filled cells
 * need to be validated.
 * 
 * ##用Hashset来做##
 * @author cassie9082
 * 
 */
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board){
		HashSet<Character> set = new HashSet<Character>();
		//row
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(board[i][j] == '.'){
					continue;
				}
				if(set.contains(board[i][j])){
					return false;
				}
				set.add(board[i][j]);
			}
			set.clear(); //每一行不能有重复数字
		}
		
		//column
		for(int j = 0; j < 9; j++){
			for(int i = 0; i < 9; i++){
				if(board[i][j] == '.'){
					continue;
				}
				if(set.contains(board[i][j])){
					return false;
				}
				set.add(board[i][j]);
			}
			set.clear(); //每一列不能有重复数字
		}
		
		//check for each sub-grid
		//1  4  7
		//2  5  8
		//3  6  9
		//竖过来的顺序，一共要走遍9大格，所以把k=9那个loop放最外面
		//按编号求'/'就是求得当前小方格的第一行横坐标，因为每个小方格有3行，所以循环3次。
		//按编号求'%'就是求得当前小方格的第一列纵坐标，因为每个小方格有3列，所以循环3次。
		for(int k = 0; k < 9; k++){
			for(int i = k / 3 * 3; i < k / 3 * 3 + 3; i ++){
				for(int j = k % 3 * 3; j < k % 3 * 3 + 3; j ++){
					if(board[i][j] == '.'){
						continue;
					}
					if(set.contains(board[i][j])){
						return false;
					}
					set.add(board[i][j]);
				}
			}
			set.clear();
		}
		return true;
	}
}
