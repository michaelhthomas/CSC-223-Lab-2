package input.components.segment;

import input.components.point.PointNode;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SegmentNodeDatabase {

	Map<PointNode, Set<PointNode>> _adjLists;
	
	public SegmentNodeDatabase() {	
	}
	
	public void SegmntNodeDatabase(Map<PointNode, Set<PointNode>> adjList) {
	}
	
	public int numUndirectedEdges() {
		return 0;
	}
	
	public void addDirectedEdge(PointNode point1, PointNode point2) {
	}
	
	public void addUndirectedEdge(PointNode point1, PointNode point2) {
	}
	
	public void addAdjacencyList(PointNode point, List<PointNode>adjPoints) {
	}
	
	public List<SegmentNode> asSegmentList() {
		return null;
	}
	
	public List<SegmentNode> asUniqueSegmentList() {
		return null;
	}
	
}