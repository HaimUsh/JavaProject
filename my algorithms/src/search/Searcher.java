package search;
import solution.Solution;


public interface Searcher
{
	public Solution search(Searchable s);
	public int getNumberOfNodesEvaluated();
}
