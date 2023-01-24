package input.components.segment;

import input.components.point.PointNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SegmentNodeDatabase {

	Map<PointNode, Set<PointNode>> _adjLists;
	
	/**
	 * Constructs a new empty PointSegmentDatabase.
	 */
	public SegmentNodeDatabase() {
		_adjLists = new HashMap<PointNode, Set<PointNode>>();
	}
	
	/**
	 * Constructs a new PointSegmentDatabase, using a new map of adjacency lists.
	 * @param adjLists
	 */
	public void SegmntNodeDatabase(Map<PointNode, Set<PointNode>> adjLists) {
		_adjLists = adjLists;
	}
	
	/**
	 * returns the number of undirected edges in the SegmentNodeDatabase.
	 * @return number of undirected edges
	 */
	public int numUndirectedEdges() {
		return _adjLists.size() / 2;
	}
	
	/**
	 * Adds a directed edge to the SegmentNodeDatabase.
	 * @param point1
	 * @param point2
	 */
	private void addDirectedEdge(PointNode point1, PointNode point2) {
		Set<PointNode> connectedPoints = _adjLists.get(point1);
		if(connectedPoints == null) {
			// creates adjacency list with one edge and adds to adjacency lists
			LinkedHashSet<PointNode> newPoint = new LinkedHashSet<PointNode>();
			newPoint.add(point2);
			_adjLists.put(point1, newPoint);
		}
		else {
			connectedPoints.add(point2);
		}
	}
	
	/**
	 * Adds an undirected edge to the SegmentNodeDatabase.
	 * @param point1
	 * @param point2
	 */
	public void addUndirectedEdge(PointNode point1, PointNode point2) {
		addDirectedEdge(point1, point2);
		addDirectedEdge(point2, point1);
	}
	
	/**
	 * Adds a new adjacency list to the SegmentNodeDatabase.
	 * @param point
	 * @param adjPoints
	 */
	public void addAdjacencyList(PointNode point, List<PointNode> adjPoints) {
		for(PointNode connectedPoint : adjPoints) {
			addUndirectedEdge(point, connectedPoint);
		}
	}
	
	/**
	 * returns a list of segmentNodes for each directed edge in the adjacency list.
	 * @return List of SegmentNodes
	 */
	public List<SegmentNode> asSegmentList() {
		List<SegmentNode> segmentList = new ArrayList<SegmentNode>();
		
		// adds undirected edge to list of segment nodes
		for(Entry<PointNode, Set<PointNode>> e : _adjLists.entrySet()) {
			for(PointNode point : e.getValue()) {
				segmentList.add(new SegmentNode(e.getKey(), point));
			}
		}
		return segmentList;
	}
	
	/**
	 * returns a list of segmentNodes from the SegmentNodeDatabase only
	 * counting each undirected edge once.
	 * @return
	 */
	public List<SegmentNode> asUniqueSegmentList() {
		
		List<SegmentNode> segmentList = new ArrayList<SegmentNode>();
		SegmentNode segment;
		
		// adds undirected edge to list of segment nodes if not already in it
		for(Entry<PointNode, Set<PointNode>> e : _adjLists.entrySet()) {
			for(PointNode point : e.getValue()) {
				segment = new SegmentNode(e.getKey(), point);
				if(segmentList.contains(segment)) {
					segmentList.add(segment);
				}
			}
		}
		return segmentList;
	}
	
}
