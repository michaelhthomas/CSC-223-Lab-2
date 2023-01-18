package input.components.point;

import java.util.List;
import java.util.Set;

public class PointNodeDatabase {

	Set<PointNode> _points;
	
	public PointNodeDatabase() {
	}
	
	public PointNodeDatabase(List<PointNode> list) {
	}
	
	public void put(PointNode point) {
	}
	
	public boolean contains(PointNode point) {
		return false;
	}
	
	public boolean contains(double x, double y) {
		return false;
	}
	
	public String getName(PointNode point) {
		return null;
	}
	
	public String getName(double x, double y) {
		return null;
	}
	
	public PointNode getPoint(PointNode point) {
		return null;
	}
	
	public PointNode getPoint(double x, double y) {
		return null;
	}
	
}
