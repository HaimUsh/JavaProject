package solution;

import java.util.ArrayList;
import java.util.Collections;
public class Solution
{

	private ArrayList<String> solutionList;

	public Solution()
	{
		super();
		this.solutionList = new ArrayList<String>();
	}
	public ArrayList<String> getSolutionList()
	{
		return solutionList;
	}
	public void setSolutionList(ArrayList<String> solutionList)
	{
		this.solutionList = new ArrayList<String>(solutionList);
	}

	public void sortback()
	{
		Collections.reverse(solutionList);

	}
	public void print()
	{
		if (solutionList.size() == 0)
		{
			System.out.println("Start point = Finish point, no rout calculated");
		}
		else
		{
			int i = 0;
			int k = 0;
			if (!solutionList.isEmpty()) {

				for (String string : solutionList) {
					if	(k == 9){
						System.out.println();
						k = 0;
					}
					if(i==solutionList.size()-1){
						System.out.print(string);
						continue;
					}
					System.out.print(string + " -> ");
					i++;
					k++;
				}
			}
			System.out.println("\nNodes to solution: " + (i+1));
		}
	}
}


