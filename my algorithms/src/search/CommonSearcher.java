package search;

import java.util.Comparator;
import java.util.PriorityQueue;

import solution.Solution;
import stateComparator.StateComparator;
import stateComparator.StateCostComparator;
import states.State;
public abstract class CommonSearcher implements Searcher {

	protected PriorityQueue<State> openList;
	private int evaluatedNodes;

	@Override
	public abstract Solution search(Searchable s);

	@Override
	public int getNumberOfNodesEvaluated()
	{
		return evaluatedNodes;
	}
	public CommonSearcher()
	{
		StateComparator sc = new StateCostComparator();
		Comparator<State> comparator = (Comparator<State>)sc;
		openList=new PriorityQueue<State>(1, comparator);
		setEvaluatedNodes(0);
	}
	public CommonSearcher(StateComparator sc)
	{
		Comparator<State> comparator = (Comparator<State>)sc;
		openList=new PriorityQueue<State>(1, comparator);
		setEvaluatedNodes(0);
	}
	protected State popOpenList()
	{
		evaluatedNodes++;
		return openList.poll();
	}
	public int getEvaluatedNodes() 
	{
		return evaluatedNodes;
	}
	public void setEvaluatedNodes(int evaluatedNodes)
	{
		this.evaluatedNodes = evaluatedNodes;
	}
	public void addToOpenList(State s1)
	{
		State s2 = new State(s1);
		s2.toString();
		openList.add(s2);
	}
	protected Solution backTrace(State goalState, State startState) 
	{
		State s1 = new State(startState);
		State s2 = new State(goalState);

		Solution solution1 = new Solution();
		while (!s2.equals(s1)) 
		{
			solution1.getSolutionList().add(s2.getStateString());
			State sTemp = new State (s2);
			s2 = new State(sTemp.getPreviousState());
		}
		solution1.getSolutionList().add(startState.getStateString());
		solution1.sortback();
		solution1.print();
		return solution1;
	}
}
