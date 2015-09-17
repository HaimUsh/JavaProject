
package heuristics;

import states.State;
import algorithms.mazeGenerators.Position;
public class MazeEuclideanDistance implements Heuristic 
{
	@Override
	public double h(State s1, State s2)
	{
		int goalX,goalZ,goalY;
		int startX, startZ, startY;
		Position p1 = s1.toPositionGeneric(s1.getStateString());
		Position p2 = s1.toPositionGeneric(s2.getStateString());

		goalX = p1.getX();
		goalZ = p1.getZ();
		goalY = p1.getY();

		startX = p2.getX();
		startZ = p2.getZ();
		startY = p2.getY();

		return ((Math.sqrt(Math.pow(Math.abs((startX-goalX)), 2)+Math.pow(Math.abs((startZ-goalZ)), 2)+Math.pow(Math.abs((startY-goalY)), 2)))*10);
	}

}
