
public class Room extends MapSite{//might be abstract class
	
	//fields
	public int roomNumber;
	public Wall sides;
	public MapSite[] mapsites;
	
	public Room() {//constructor
		
	}
	
	public Wall getSide(int n) {//getter
		
		return sides;//because we need to return something
	}
	
	public void setSide(int n, Wall w) {//setter
		
	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub
		
	}
	
}
