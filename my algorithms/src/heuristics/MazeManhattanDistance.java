package heuristics;

import states.State;
import algorithms.mazeGenerators.Position;
public class MazeManhattanDistance implements Heuristic
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

		return ((Math.abs((startX-goalX)+(startZ-goalZ)+(startY-goalY)))*10);
	}

}
