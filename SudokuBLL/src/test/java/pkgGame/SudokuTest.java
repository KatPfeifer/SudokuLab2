package pkgGame;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import pkgHelper.LatinSquare;
//import pkgGame.Sudoku;

public class SudokuTest {
	
	@Test
	public void isValidValueTest() {
		int [][] mySquare = {{1,2,3},{2,3,1},{3,1,2}};
		Sudoku puzzle = new Sudoku(mySquare);
		assertTrue(puzzle.isValidValue(0, 0, 4));
	}

	@Test
	public void isValidValueTest2() {
		int [][] mySquare = {{1,2,3},{2,3,1},{3,1,2}};
		Sudoku puzzle2 = new Sudoku(mySquare);
		int i = puzzle2.getiSize();
		assertFalse(puzzle2.isValidValue(0, 0, 3));
	}
	
	@Test
	public void getPuzzleTest() {
		int [][] mySquare = {{1,2,3},{2,3,1},{3,1,2}};
		Sudoku square = new Sudoku(mySquare);
		int [][] testArray = {{1,2,3},{2,3,1},{3,1,2}};
		int[][] actualArray = square.getPuzzle();
		
		assertTrue(Arrays.deepEquals(actualArray, testArray));
		
		//should be assertTrue on next line. Fails though 
		//assertFalse(Arrays.equals(testArray, square.getPuzzle()));
	}
		
	@Test
	public void getRegionTest() {
		int [][] s = {{1,2,3,4},{3,4,1,2},{2,3,4,1},{4,1,2,3}};
		Sudoku su = new Sudoku(s);
		int r=0;
		int[] testRegion= {1,2,3,4};
		assertTrue(Arrays.equals(testRegion, su.getRegion(r)));
	}
	
	@Test
	public void getRegionTest4() {
		int [][] s = {{1,2,3,4},{3,4,1,2},{2,3,4,1},{4,1,2,3}};
		Sudoku sudoku = new Sudoku(s);
		int r=2;
		int[] testRegion= {2,3,4,1};
		assertTrue(Arrays.equals(testRegion, sudoku.getRegion(r)));
	}
	
	@Test
	public void getRegionTest2() {
		int [][] s = {{1,2,3,4},{3,4,1,2},{2,3,4,1},{4,1,2,3}};
		Sudoku sud = new Sudoku(s);
		int r=0;
		int[] testRegion= {1,2,5,4};
		assertFalse(Arrays.equals(testRegion, sud.getRegion(r)));
	}
	
	@Test
	public void getRegionTest3() {
		int [][] s = {{1,2,3,4},{3,4,1,2},{2,3,4,1},{4,1,2,3}};
		Sudoku sudo = new Sudoku(s);
		int iCol=0;
		int iRow=0;
		int [] testArray = {1,2,3,4};
		assertTrue(Arrays.equals(testArray, sudo.getRegion(iCol, iRow)));
	}
	
	@Test
	public void getRegionTest5() {
		int [][] s = {{1,2,3,4},{3,4,1,2},{2,3,4,1},{4,1,2,3}};
		Sudoku sudok = new Sudoku(s);
		int iCol=3;
		int iRow=2;
		int [] testArray = {4,1,2,3};
		assertTrue(Arrays.equals(testArray, sudok.getRegion(iCol, iRow)));
	}
	
	@Test
	public void getRegionTest6() {
		int [][] s = {{1,2,3,4},{3,4,1,2},{2,3,4,1},{4,1,2,3}};
		Sudoku u = new Sudoku(s);
		int iCol=3;
		int iRow=2;
		int [] testArray = {4,5,2,3};
		assertFalse(Arrays.equals(testArray, u.getRegion(iCol, iRow)));
	}
	
	
	
	
	
	
	@Test
	public void Sudoku_Good()
	{
		try {
			Sudoku s1 = new Sudoku(9);
			int iExpectedSize = 9;
			assertEquals(s1.getiSize(),iExpectedSize);
			
		} catch (Exception e) {
			fail("Bad Sudoku");
		}
		
	}
	
	@Test(expected = Exception.class)
	public void Suduko_Bad() throws Exception
	{
		Sudoku s1 = new Sudoku(10);
	}
}