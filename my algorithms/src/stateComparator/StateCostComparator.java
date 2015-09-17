package stateComparator;

import states.State;


public class StateCostComparator implements StateComparator
{
	@Override
	public int compare(State s1, State s2)
	{
		return (int) ((s1.getCost())-(s2.getCost()));
	}

}
