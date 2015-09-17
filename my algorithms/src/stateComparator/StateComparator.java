package stateComparator;

import java.util.Comparator;

import states.State;


public interface StateComparator extends Comparator<State> 
{
	public int compare(State s1, State s2);
}
