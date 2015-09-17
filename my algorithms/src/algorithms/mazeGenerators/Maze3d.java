package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Arrays;

import states.State;


public class Maze3d {

	private int[][][] maze3d;
	private boolean[][][] visitArr;
	private int rows /*x*/,cols/*z*/,levels/*y*/;
	private Position startPosition;
	private Position goalPosition;
	private Position currentPosition;

	public Maze3d(int rows,int cols,int levels){
		this.rows=rows;
		this.cols=cols;
		this.levels=levels;
		this.maze3d=new int[rows][cols][levels]; 
		this.startPosition= new Position(0, 0, 0);
		this.goalPosition= new Position(5, 7, 3);
		this.currentPosition = new Position(0, 0, 0);
		this.visitArr = new boolean[rows][cols][levels];
		for (int[][] square : maze3d){
			for (int[] line : square){
				Arrays.fill(line, 1);
			}
		}
	}
	
	public Maze3d(Maze3d m)
	{
		this.rows = m.rows;
		this.cols = m.cols;
		this.levels = m.levels;
		this.goalPosition = new Position(m.goalPosition);
		this.startPosition = new Position(m.startPosition);
		this.currentPosition = new Position(m.currentPosition);
		this.maze3d = m.maze3d;
	}
	


	public Position getStartPosition() {
		return startPosition;
	}

	public Position getGoalPosition() {
		return goalPosition;
	}

	public void setStartPosition(int x,int z,int y) {
		this.startPosition.x =x;
		this.startPosition.z =z;
		this.startPosition.y =y;
	}

	public void setGoalPosition(int x,int z,int y) {
		this.goalPosition.x =x;
		this.goalPosition.z =z;
		this.goalPosition.y =y;

	}

	public int[][][] getMaze3d() {
		return maze3d;
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	public int getLevels() {
		return levels;
	}

	public void setMaze3d(int[][][] maze3d) {
		this.maze3d=maze3d;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public void setLevels(int levels) {
		this.levels = levels;
	}


	public Position getCurrentPosition() {
		return currentPosition;
	}


	public void setCurrentPosition(int x,int z,int y) {
		this.currentPosition.x =x;
		this.currentPosition.z =z;
		this.currentPosition.y =y;
	}
	public void setValue(int x,int z,int y,int value){
		this.maze3d[x][z][y]=value;
	}
	public int getValue(int x,int z,int y){
		return maze3d[x][z][y];
	}
	public int getValueByPosition(Position p)
	{
		return this.maze3d[p.getX()][p.getZ()][p.getY()];
	}
	public void setValueByPosition(Position p,int value)
	{
		this.maze3d[p.getX()][p.getZ()][p.getY()] = value;
	}
	public String[] getPossibleMoves(Position p){

		String moves= new String();

		if (isAvailable(Moves.RIGHT, p)) {

			moves = moves + "RIGHT,";
		}
		if (isAvailable(Moves.LEFT, p)) {

			moves= moves+ "LEFT,";
		}
		if (isAvailable(Moves.FORWARD, p)) {

			moves= moves+ "FORWARD,";
		}
		if (isAvailable(Moves.BACK, p)) {

			moves= moves+ "BACK,";
		}
		if (isAvailable(Moves.UP, p)) {

			moves= moves+ "UP,";
		}
		if (isAvailable(Moves.DOWN, p)) {

			moves= moves+ "DOWN,";
		}
		return moves.split(",");
	}
	public boolean isInBound(Moves move, Position p){
		switch (move){
		case UP:{
			if (p.y +1 < this.getLevels())
			{
				return true;	
			}
			break;
		}
		case DOWN:{
			if (p.y -1 >= 0)
			{
				return true;	
			}
			break;
		}
		case RIGHT:{
			if (p.x +1 < this.getRows())
			{
				return true;	
			}
			break;
		}

		case LEFT:{
			if (p.x -1 >= 0)
			{
				return true;	
			}
			
			break;
		}

		case FORWARD:{
			if (p.z +1 < this.getCols())
			{
				return true;	
			}
			break;
		}

		case BACK:{
			if (p.z -1 >= 0)
			{
				return true;	
			}
			break;
		}


		}
		return false;

	}

	public boolean isOutOfBound(int x, int z, int y) {
		if(x < 0 || x > this.rows)
			return true;
		if(z < 0 || z > this.cols)
			return true;
		if(y < 0 || y > this.levels)
			return true;
		return false;
	}


	public boolean isAvailable(Moves move, Position p)
	{
		switch (move)
		{

		case UP:{
			if(isInBound(move,p))
				if(this.maze3d[p.x][p.z][p.y+1]==0)
					return true;
		}
		case DOWN:{
			if(isInBound(move,p))
				if(this.maze3d[p.x][p.z][p.y-1]==0)
					return true;
		}

		case LEFT:{
			if(isInBound(move,p))
				if(this.maze3d[p.x-1][p.z][p.y]==0)
					return true;
		}

		case RIGHT:{
			if(isInBound(move,p))
				if(this.maze3d[p.x+1][p.z][p.y]==0)
					return true;
		}

		case FORWARD:{
			if(isInBound(move,p))
				if(this.maze3d[p.x][p.z+1][p.y]==0)
					return true;
		}

		case BACK:{
			if(isInBound(move,p))
				if(this.maze3d[p.x][p.z-1][p.y]==0)
					return true;
		}

		
		}
		return false;

	}
	public int[][] getCrossSectionByX(int x) {
		int[][] m1 = new int[cols][levels];
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < levels; j++) {
				m1[i][j] = maze3d[x][i][j];
			}
		}
		return m1;
	}

	public int[][] getCrossSectionByY(int y) {
		int[][] m2 = new int[rows][levels];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < levels; j++) {
				m2[i][j] = maze3d[y][i][j];
			}
		}
		return m2;
	}

	public int[][] getCrossSectionByZ(int z) {
		int[][] m3 = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				m3[i][j] = maze3d[z][i][j];
			}
		}
		return m3;


	}

	public boolean isVisited(int x, int z, int y){
		return visitArr[x][z][y];
	}

	public void setVisited(int x, int z, int y){

		this.visitArr[x][z][y]=true;
	}

	public void print2dMaze(int[][] crossSection)
	{
		System.out.println("Your CrossSection:");
		System.out.println();
		for (int i = 0; i < crossSection.length; i++)
		{
			System.out.print("    ");
			for (int j = 0; j < crossSection.length; j++)
			{

				System.out.print(crossSection[j][crossSection.length-i-1]);
				if (j+1 < crossSection.length)
				{
					System.out.print(",");
				}
			}
			System.out.println();
		}
		System.out.println();
	}



	public void movePosition(Position p, Moves m){

		switch (m){
		case UP: 
			p.y=p.y+1;
			break;
		case DOWN: 
			p.y=p.y-1;
			break;
		case RIGHT: 
			p.x=p.x+1;
			break;
		case LEFT: 
			p.x=p.x-1;
			break;
		case FORWARD: 
			p.z=p.z+1;
			break;
		case BACK: 
			p.z=p.z-1;
			break;


		}
	}
	public ArrayList<String> getPossibleMovesInArrayList(State s1)
	{
		Position p2 = new Position();
		p2 = s1.toPositionGeneric(s1.getStateString());
		ArrayList<String> movesArrayList = new ArrayList<String>();
		String[] stringSet = getPossibleMoves(p2);
		for (int i = 0; i < stringSet.length; i++)
		{
			movesArrayList.add(stringSet[i]);
		}
		return movesArrayList;
	}
}
