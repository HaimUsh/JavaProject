package algorithms.mazeGenerators;

public class Position {
	int x,z,y;
	
	public Position(int x,int y,int z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public Position(Position p) {
		this.x=p.x;
		this.z=p.z;
		this.y=p.y;
	}

	public Position(){
		this.x=0;
		this.z=0;
		this.y=0;
	}
	@Override
	public String toString(){
		
		return "{"+this.x+","+this.y+","+this.z+"}";
	}

	public int getX() {
		return x;
	}

	public int getZ() {
		return z;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setPositin(int x, int y, int z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public void copyPosition(Position p){
		this.x=p.x;
		this.y=p.y;
		this.z=p.z;
	}

	
	public boolean isEqual(Position p) {
		if ((this.x == p.x) && (this.y == p.y) && (this.z == p.z))
		{
			return true;
		}
		return false;
	}
	

}

