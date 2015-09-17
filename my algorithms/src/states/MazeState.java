package states;

import java.util.ArrayList;
import java.util.Iterator;

import algorithms.mazeGenerators.Position;
public class MazeState extends State
{
	private Position p;

	public Position getP() 
	{
		return p;
	}

	public MazeState(Position p)
	{
		super();
		this.p = new Position(p);
		this.toString();
	}


	public State positionToState(Position pos) 
	{
		this.p.copyPosition(pos);
		this.toString();
		return this;
	}

	public void setP(Position p) {
		this.p.copyPosition(p);;
	}
	
	public String toString ()
	{
		Integer tempIntx = new Integer(p.getX());
		Integer tempIntz = new Integer(p.getZ());
		Integer tempInty = new Integer(p.getY());
		this.setStateString((tempIntx.toString() + ',' + tempIntz.toString() + ',' +tempInty.toString()));
		return (this.getStateString());
	}
	
	public Position toPosition (String posInString)
	{
		String[] seperatedArray = posInString.split(",");
		this.p.setX(Integer.parseInt(seperatedArray[0]));
		this.p.setZ(Integer.parseInt(seperatedArray[1]));
		this.p.setY(Integer.parseInt(seperatedArray[2]));
		return this.getP();
	}
	public ArrayList<State> positionArraytoStateArray (ArrayList<Position> pArray)
	{
		ArrayList<State> sArray = new ArrayList<State>();
		for (Iterator<Position> iterator = pArray.iterator(); iterator.hasNext();) 
		{
			Position position = (Position) iterator.next();
			State sTemp = new MazeState(position);
			sTemp.toString();
			sArray.add(sTemp);
		}
		return sArray;
	}
	public MazeState(State s) 
	{
		super();
		this.p = new Position(((MazeState) s).getP());
		this.toString();
		if (s.getPreviousState() != null) 
		{
			this.setPreviousState(s.getPreviousState());
		}
	}

	public void copyMazeState(State s) 
	{
		this.p.copyPosition(((MazeState) s).getP());
		this.toString();
		if (s.getPreviousState() != null) 
		{
			this.setPreviousState(s.getPreviousState());
		}
	}
}
