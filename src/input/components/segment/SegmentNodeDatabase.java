package input.components.segment;

import input.components.point.PointNode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SegmentNodeDatabase {

	Map<PointNode, Set<PointNode>> _adjLists;
	
	public SegmentNodeDatabase() {
		_adjLists = new HashMap<PointNode, Set<PointNode>>();
	}
	
	public void SegmntNodeDatabase(Map<PointNode, Set<PointNode>> adjLists) {
		_adjLists = adjLists;
	}
	
	public int numUndirectedEdges() {
		return _adjLists.size();
	}
	
	public void addDirectedEdge(PointNode point1, PointNode point2) {
		Set<PointNode> connectedPoints = _adjLists.get(point1);
		if(connectedPoints == null) {
			LinkedHashSet<PointNode> newPoint = new LinkedHashSet<PointNode>();
			newPoint.add(point2);
			_adjLists.put(point1, newPoint);
		}
		else {
			connectedPoints.add(point2);
		}
	}
	
	public void addUndirectedEdge(PointNode point1, PointNode point2) {
		addDirectedEdge(point1, point2);
		addDirectedEdge(point2, point1);
	}
	
	public void addAdjacencyList(PointNode point, List<PointNode> adjPoints) {
		for(PointNode connectedPoint : adjPoints) {
			addUndirectedEdge(point, connectedPoint);
		}
	}
	
	public List<SegmentNode> asSegmentList() {
		return null;
	}
	
	public List<SegmentNode> asUniqueSegmentList() {
		return null;
	}
	
}