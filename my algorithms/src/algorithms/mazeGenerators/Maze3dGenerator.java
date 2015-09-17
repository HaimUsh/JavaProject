package algorithms.mazeGenerators;

public interface Maze3dGenerator {
	
	public Maze3d generate(int rows,int cols,int levels);
	public String measureAlgorithmTime(int rows,int cols,int levels);

}
