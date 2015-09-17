package algorithms.mazeGenerators;

import java.util.Random;

public abstract class CommonMaze3dGenerator implements Maze3dGenerator {

	@Override
	public Maze3d generate(int rows, int cols, int levels) {
		return null;
	}

	@Override
	public String measureAlgorithmTime(int rows,int cols,int levels) {
		long start= System.currentTimeMillis();
		generate(rows,cols,levels);
		long end=System.currentTimeMillis();
		long totalTime=end-start;
		return Long.toString(totalTime);
		
	}
	public int randomNumberMaker(int max, int min)
	{
		int num = 0;
		Random rand = new Random();
		num = rand.nextInt((max - min) + 1) + min;
		return num; 
	

	}
}
