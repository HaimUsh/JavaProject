package states;

import java.util.ArrayList;
import java.util.Iterator;

import algorithms.mazeGenerators.Position;
public class State 
{
	private String stateString;   
	private double cost;   			 
	private State previousState;  		
	private double g,h;					

	public State() 
	{
		this.stateString = new String();
		this.cost = 0;
		this.g = 0;
		this.h = 0;
	}
	public State(State s1) 
	{
		this.stateString = new String(s1.stateString);
		this.cost = s1.cost;
		{
			this.previousState = new State();
			previousState = s1.previousState;
		}
		this.g = s1.g;
		this.h = s1.h;

	}
	
	public double getG() {
		return g;
	}
	public void setG(double g)
	{
		this.g = g;
	}
	public double getH()
	{
		return h;
	}
	public void setH(double h) 
	{
		this.h = h;
	}
	public String getStateString()
	{
		return stateString;
	}
	public void setStateString(String stateString)
	{
		this.stateString = new String(stateString);
	}
	public State(String state)
	{      
		this.stateString = new String(state);
	}
	public void print() 
	{
		System.out.println(this.getStateString());
	}
	public State getPreviousState()
	{
		return previousState;
	}
	public void setPreviousState(State prevState)
	{
		this.previousState = new State();
		this.previousState = prevState;

	}
	@Override
	public boolean equals(Object obj)
	{ 
		return stateString.equals(((State)obj).stateString);
	}
	
	public double getCost() 
	{
		return cost;
	}
	
	public void setCost(double cost)
	{
		this.cost = cost;
	}
	public void setCameFrom(State n)
	{
		this.previousState = new State(n);

	}
	public void calcCost()
	{
		this.cost = this.g + this.h;
	}
	public void calcG(double g, double price)
	{
		this.g = g+ price;
	}
	public ArrayList<State> stringArraytoStateArray (ArrayList<String> pArray)
	{
		ArrayList<State> sArray = new ArrayList<State>();
		for (Iterator<String> iterator = pArray.iterator(); iterator.hasNext();) 
		{
			String string1 = (String) iterator.next();
			State sTemp = new State(string1);
			sTemp.toString();
			sArray.add(sTemp);
		}
		return sArray;
	}

	public Position toPositionGeneric (String posInString)
	{
		Position p = new Position();
		String[] seperatedArray = posInString.split(",");
		p.setX(Integer.parseInt(seperatedArray[0]));
		p.setZ(Integer.parseInt(seperatedArray[1]));
		p.setY(Integer.parseInt(seperatedArray[2]));
		return p;
	}
}
