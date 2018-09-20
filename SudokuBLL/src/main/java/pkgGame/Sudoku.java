package pkgGame;

import java.util.Arrays;

import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare{
	
private int iSize;
private int iSqrtSize;

public Sudoku(int iSize) throws Exception
{
	this.iSize = iSize;
	double SQRT = Math.sqrt(iSize);
	
	if ((SQRT == Math.floor(SQRT)) && (!Double.isInfinite(SQRT)))
	{
		//	Good Sudoku
		this.iSqrtSize = (int)SQRT;
	}
	else
	{
		//	Bad Sudoku
		throw new Exception("Bad Sudoku");
	}
	
	//	Generate Sudoku
	
}
public Sudoku(int[][] puzzle) {
	super(puzzle);
	iSqrtSize=(int)Math.round(Math.sqrt(puzzle.length));
	if (iSqrtSize%1==0) {
		iSize=puzzle.length;
	}
}



public int getiSize() {
	return iSize;
}

protected int[][] getPuzzle() {
	//System.out.print("in method");
	return super.getLatinSquare(); 
}

public boolean isValidValue(int iCol, int iRow, int iValue) {
	if (super.doesElementExist(super.getColumn(iCol), iValue)==false) {
		if (super.doesElementExist(super.getRow(iRow), iValue)==false) {
			return true;
		}
		else {
			return false;
		}
	}
	else {
		return false;
	}
}

public int[] getRegion(int r) {
	int [] region=new int [iSize];
	int index=0;
	int root = (int) Math.round(Math.sqrt(iSize));
	for (int i = 0; i<iSize; i+= root) {
		if (r>= i && r<i+root) {
			int startRow=i;
			int startCol=(r%root)*root;
			for (int row=startRow; row<startRow+root; row++) {
				for (int col=startCol; col<startCol+root; col++) {
					region[index] = getPuzzle()[row][col];
					index++;
				}
			}
		}
	}
	return region;
}

public int[] getRegion(int iCol, int iRow) {
	int root = (int) Math.round(Math.sqrt(iSize));
	int region = ((iRow/root)*root) + iCol/root;
	return getRegion(region);
}

public boolean isPartialSudoku() {
	for (int i=0; i<iSize; i++) {
		if (super.hasDuplicates(getRegion(i))==false) {
			if (super.hasAllValues(getRegion(0), getRegion(i))==true) {
				if (super.doesElementExist(getRegion(i), 0)==true) {
					return true;
				}
			}
		}
	}
	return false;
}

public boolean isSudoku() {
	for (int i=0; i<iSize; i++) {
		if (super.hasDuplicates(getRegion(i))==false) {
			if (super.hasAllValues(getRegion(0), getRegion(i))==true) {
				if (super.doesElementExist(getRegion(i), 0)==false) {
					return true;
				}
			}
		}
	}
	return false;
}

}