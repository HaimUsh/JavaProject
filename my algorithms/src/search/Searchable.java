package search;

import java.util.ArrayList;
import states.State;



public interface Searchable 
{
	State getStartState();
	State getGoalState();
	ArrayList<State> getAllPossibleStates(State s);
	double getPrice (State s1, State s2);
}
