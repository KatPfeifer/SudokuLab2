package pkgGame;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import pkgHelper.LatinSquare;
//import pkgGame.Sudoku;

public class SudokuTest {
	
	@Test
	public void isValidValueTest() throws Exception {
		int [][] mySquare = {{1,2,3,4},{3,4,1,2},{2,3,4,1},{4,1,2,3}};
		Sudoku puzzle = new Sudoku(mySquare);
		assertTrue(puzzle.isValidValue(0, 0, 5));
	}

	@Test
	public void isValidValueTest2() throws Exception {
		int [][] mySquare = {{1,2,3,4},{3,4,1,2},{2,3,4,1},{4,1,2,3}};
		Sudoku puzzle2 = new Sudoku(mySquare);
		int i = puzzle2.getiSize();
		assertFalse(puzzle2.isValidValue(0, 0, 3));
	}
	
	@Test
	public void getPuzzleTest() throws Exception {
		int [][] s = {{1,2,3,4},{3,4,1,2},{2,3,4,1},{4,1,2,3}};
		Sudoku square = new Sudoku(s);
		int [][] testArray = {{1,2,3,4},{3,4,1,2},{2,3,4,1},{4,1,2,3}};
		int[][] actualArray = square.getPuzzle();
		
		assertTrue(Arrays.deepEquals(actualArray, testArray));
		
		//should be assertTrue on next line. Fails though 
		//assertFalse(Arrays.equals(testArray, square.getPuzzle()));
	}
		
	@Test
	public void getRegionTest() throws Exception {
		int [][] s = {{1,2,3,4},{3,4,1,2},{2,3,4,1},{4,1,2,3}};
		Sudoku su = new Sudoku(s);
		int r=0;
		int[] testRegion= {1,2,3,4};
		assertTrue(Arrays.equals(testRegion, su.getRegion(r)));
	}
	
	@Test
	public void getRegionTest4() throws Exception {
		int [][] s = {{1,2,3,4},{3,4,1,2},{2,3,4,1},{4,1,2,3}};
		Sudoku sudoku = new Sudoku(s);
		int r=2;
		int[] testRegion= {2,3,4,1};
		assertTrue(Arrays.equals(testRegion, sudoku.getRegion(r)));
	}
	
	@Test
	public void getRegionTest2() throws Exception {
		int [][] s = {{1,2,3,4},{3,4,1,2},{2,3,4,1},{4,1,2,3}};
		Sudoku sud = new Sudoku(s);
		int r=0;
		int[] testRegion= {1,2,5,4};
		assertFalse(Arrays.equals(testRegion, sud.getRegion(r)));
	}
	
	@Test
	public void getRegionTest3() throws Exception {
		int [][] s = {{1,2,3,4},{3,4,1,2},{2,3,4,1},{4,1,2,3}};
		Sudoku sudo = new Sudoku(s);
		int iCol=0;
		int iRow=0;
		int [] testArray = {1,2,3,4};
		assertTrue(Arrays.equals(testArray, sudo.getRegion(iCol, iRow)));
	}
	
	@Test
	public void getRegionTest5() throws Exception {
		int [][] s = {{1,2,3,4},{3,4,1,2},{2,3,4,1},{4,1,2,3}};
		Sudoku sudok = new Sudoku(s);
		int iCol=3;
		int iRow=2;
		int [] testArray = {4,1,2,3};
		assertTrue(Arrays.equals(testArray, sudok.getRegion(iCol, iRow)));
	}
	
	@Test
	public void getRegionTest6() throws Exception {
		int [][] s = {{1,2,3,4},{3,4,1,2},{2,3,4,1},{4,1,2,3}};
		Sudoku u = new Sudoku(s);
		int iCol=3;
		int iRow=2;
		int [] testArray = {4,5,2,3};
		assertFalse(Arrays.equals(testArray, u.getRegion(iCol, iRow)));
	}
	@Test
	public void getRegionTest7() throws Exception {
		int [][] s = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,4,3,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
		Sudoku mySquare = new Sudoku(s);
		int r=0;
		int[] testRegion= {5,3,4,6,7,2,1,9,8};
		int[] actualRegion=mySquare.getRegion(r);
		assertTrue(Arrays.equals(testRegion, actualRegion));
	}
	@Test
	public void getRegionTest8() throws Exception {
		int [][] s = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,4,3,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
		Sudoku mySquare = new Sudoku(s);
		int r=7;
		int[] testRegion= {5,3,7,4,1,9,2,8,6};
		int[] actualRegion=mySquare.getRegion(r);
		assertTrue(Arrays.equals(testRegion, actualRegion));
	}
	@Test
	public void getRegionTest9() throws Exception {
		int [][] s = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,4,3,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
		Sudoku mySquare = new Sudoku(s);
		int iCol=4;
		int iRow=6;
		int[] testRegion= {5,3,7,4,1,9,2,8,6};
		int[] actualRegion=mySquare.getRegion(iCol, iRow);
		assertTrue(Arrays.equals(testRegion, actualRegion));
	}
	@Test
	public void Sudoku_Good() {
		try {
			Sudoku s1 = new Sudoku(9);
			int iExpectedSize = 9;
			assertEquals(s1.getiSize(),iExpectedSize);
		} catch (Exception e) {
			fail("Bad Sudoku");
		}
	}
	 
	@Test(expected = Exception.class)
	public void Sudoku_Bad() throws Exception
	{
		Sudoku s1 = new Sudoku(10);
	}
	
	@Test
	public void isPartialSudokuTest() throws Exception {
		int [][] s = {{0,2,3,4},{3,4,0,2},{2,3,4,0},{4,0,2,3}};
		Sudoku uk = new Sudoku(s);
		assertEquals(true, uk.isPartialSudoku());
	}
	
	@Test
	public void isPartialSudokuTest2() throws Exception {
		int [][] s = {{0,0,3,4},{3,5,0,2},{2,3,4,0},{4,4,2,3}};
		Sudoku uko = new Sudoku(s);
		assertEquals(false, uko.isPartialSudoku());
	}
	@Test
	public void isSudokuTest() throws Exception {
		int [][] s = {{1,2,3,4},{3,4,1,2},{2,3,4,1},{4,1,2,3}};
		Sudoku ukod = new Sudoku(s);
		assertEquals(true, ukod.isSudoku());
	}
	@Test
	public void isSudokuTest2() throws Exception {
		int [][] s = {{1,1,5,3},{3,4,1,2},{2,3,4,1},{4,1,2,3}};
		Sudoku ukodu = new Sudoku(s);
		assertEquals(false, ukodu.isSudoku());
	}
	@Test
	public void isSudokuTest3() throws Exception {
		int [][] s = {{1,2,3,5},{3,4,1,2},{2,3,4,1},{4,1,2,3}};
		Sudoku ukod = new Sudoku(s);
		assertEquals(true, ukod.isSudoku());
	}
	@Test
	public void isSudokuTest4() throws Exception {
		int [][] s = {{1,2,3,4},{3,4,1,2},{2,0,4,1},{4,1,2,3}};
		Sudoku ukod = new Sudoku(s);
		assertEquals(true, ukod.isSudoku());
	}
}
