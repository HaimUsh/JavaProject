package search;

import java.util.ArrayList;

import states.MazeState;
import states.State;
import algorithms.mazeGenerators.Maze3d;
public class SearchableMaze implements Searchable 
{
	Maze3d maze;
	State startState;
	State goalState;
	final int movePrice = 10;
	public SearchableMaze() //default ctor
	{

	}
	public SearchableMaze(Maze3d _maze) // ctor
	{
		this.maze = new Maze3d(_maze);
		this.startState = new MazeState(_maze.getStartPosition());
		this.goalState = new MazeState(_maze.getGoalPosition());

	}

	public Maze3d getMaze()
	{
		return maze;
	}
	public void setStartState(State startState)
	{
		this.startState = new State(startState);
	}

	public void setGoalState(State goalState)
	{
		this.goalState = new State(goalState);
	}

	@Override
	public State getStartState()
	{
		return this.startState;
	}

	@Override
	public State getGoalState() 
	{
		return this.goalState;
	}
	@Override
	public ArrayList<State> getAllPossibleStates(State s1) 
	{
		ArrayList<String> stringList = maze.getPossibleMovesInArrayList(s1);
		ArrayList<State> statesList = s1.stringArraytoStateArray(stringList);

		return statesList;
	}

	@Override
	public double getPrice(State s1, State s2) 
	{
		if (s1.equals(s2))
		{
			return 0;
		}
		return movePrice;
	}
}
