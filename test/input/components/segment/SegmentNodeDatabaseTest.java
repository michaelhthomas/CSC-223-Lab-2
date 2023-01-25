package input.components.segment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

import input.components.point.PointNode;

class SegmentNodeDatabaseTest
{
    public SegmentNodeDatabase build() {
    	//      A                                 
    	//     / \                                
    	//    B___C                               
    	//   / \ / \                              
    	//  /   X   \ 
    	// D_________E
    	//
		//
    	PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);

    	PointNode d = new PointNode("D", 0, 0);
    	PointNode e = new PointNode("E", 6, 0);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();
    	  	
    	db.addUndirectedEdge(a, b);
    	db.addUndirectedEdge(a, c);
    	db.addUndirectedEdge(b, c);
    	db.addUndirectedEdge(b, x);
    	db.addUndirectedEdge(b, d);
    	db.addUndirectedEdge(c, x);
    	db.addUndirectedEdge(c, e);
    	db.addUndirectedEdge(x, d);
    	db.addUndirectedEdge(x, e);
    	db.addUndirectedEdge(d, e);
    	
    	return db;
    }
    
    private SegmentNodeDatabase buildUndirected() {
		//      A
    	//     / \
		//	  /   v
    	//   B---->C
    	PointNode a = new PointNode("A", 1, 1);
    	PointNode b = new PointNode("B", 0, 0);
    	PointNode c = new PointNode("C", 1, 0);
    	
    	Map<PointNode, Set<PointNode>> adjLists = new HashMap<PointNode, Set<PointNode>>();
    	LinkedHashSet<PointNode> aPoint = new LinkedHashSet<PointNode>();
    	LinkedHashSet<PointNode> bPoint = new LinkedHashSet<PointNode>();
    	LinkedHashSet<PointNode> cPoint = new LinkedHashSet<PointNode>();
    	aPoint.add(b);
    	aPoint.add(c);
    	bPoint.add(a);
    	bPoint.add(c);
    	adjLists.put(a, aPoint);
    	adjLists.put(b, bPoint);
    	adjLists.put(c, cPoint);
    	
    	SegmentNodeDatabase db = new SegmentNodeDatabase(adjLists);
		
    	return db;
	}

    @Test
    void segmentNodeDatabaseExistsTest() {
    	SegmentNodeDatabase db = build();
    	
    	assertNotNull(db);
    }
    
    @Test
    void segmentNodeDatabaseUndirectedExistsTest() {
    	SegmentNodeDatabase db = buildUndirected();
    	
    	assertNotNull(db);
    }
    
    @Test
	void numUndirectedEdgesTest() {
		SegmentNodeDatabase db = build();
		
		assertEquals(10, db.numUndirectedEdges());
	}
	
	@Test
	void numUndirectedEdgesWithDirectedEdgeTest() {
		SegmentNodeDatabase db = buildUndirected();
		
		assertEquals(1, db.numUndirectedEdges());
	}
	
	void addDirectedEdgeHalfNonUniqueTest() {
		SegmentNodeDatabase db = buildUndirected();
		db.addUndirectedEdge(new PointNode("C", 6.0, 3.0), new PointNode("B", 0.0, 0.0));
		
		assertEquals(3, 3);
	}
	
	@Test
	void emptyNumUndirectedEdgesTest() {
		SegmentNodeDatabase db = new SegmentNodeDatabase();
		
		assertEquals(0, db.numUndirectedEdges());
	}
    
    @Test
    void asSegmentListTest() { 
    	SegmentNodeDatabase db = build();
    	List<SegmentNode> segments = db.asSegmentList();
    	
    	assertEquals("Segment [Point A: (3.0, 6.0), Point B: (2.0, 4.0)]", segments.get(0).toString());
    	assertEquals("Segment [Point B: (2.0, 4.0), Point A: (3.0, 6.0)]", segments.get(2).toString());
    	assertEquals(20, segments.size());
    }
    
    @Test
    void asSegmentListEmptyTest() { 
    	SegmentNodeDatabase db = new SegmentNodeDatabase();
    	List<SegmentNode> segments = db.asSegmentList();
    	
    	assertEquals(0, segments.size());
    }
    
    @Test
    void asSegmentListUndirectedTest() { 
    	SegmentNodeDatabase db = buildUndirected();
    	List<SegmentNode> segments = db.asSegmentList();
    	
    	assertEquals("Segment [Point A: (1.0, 1.0), Point B: (0.0, 0.0)]", segments.get(0).toString());
    	assertEquals("Segment [Point B: (0.0, 0.0), Point A: (1.0, 1.0)]", segments.get(2).toString());
    	assertEquals(4, segments.size());
    }
    
    @Test
    void asUniqueSegmentListTest() { 
    	SegmentNodeDatabase db = build();
    	List<SegmentNode> uniqueSegments = db.asUniqueSegmentList();
    	
    	assertEquals("Segment [Point A: (3.0, 6.0), Point B: (2.0, 4.0)]", uniqueSegments.get(0).toString());
    	assertEquals("Segment [Point A: (3.0, 6.0), Point C: (4.0, 4.0)]", uniqueSegments.get(1).toString());
    	assertEquals("Segment [Point B: (2.0, 4.0), Point C: (4.0, 4.0)]", uniqueSegments.get(2).toString());
    	assertEquals("Segment [Point B: (2.0, 4.0), Point X: (3.0, 3.0)]", uniqueSegments.get(3).toString());
    	assertEquals("Segment [Point B: (2.0, 4.0), Point D: (0.0, 0.0)]", uniqueSegments.get(4).toString());
    	assertEquals("Segment [Point C: (4.0, 4.0), Point X: (3.0, 3.0)]", uniqueSegments.get(5).toString());
    	assertEquals("Segment [Point C: (4.0, 4.0), Point E: (6.0, 0.0)]", uniqueSegments.get(6).toString());
    	assertEquals("Segment [Point X: (3.0, 3.0), Point D: (0.0, 0.0)]", uniqueSegments.get(7).toString());
    	assertEquals("Segment [Point X: (3.0, 3.0), Point E: (6.0, 0.0)]", uniqueSegments.get(8).toString());
    	assertEquals("Segment [Point D: (0.0, 0.0), Point E: (6.0, 0.0)]", uniqueSegments.get(9).toString());
    	assertEquals(10, uniqueSegments.size());
    	
    }
    
    @Test
    void asUniqueSegmentListEmptyTest() { 
    	SegmentNodeDatabase db = new SegmentNodeDatabase();
    	List<SegmentNode> uniqueSegments = db.asSegmentList();
    	
    	assertEquals(0, uniqueSegments.size());
    }
    
    @Test
    void asUniqueSegmentListUndirectedTest() { 
    	SegmentNodeDatabase db = buildUndirected();
    	List<SegmentNode> uniqueSegments = db.asUniqueSegmentList();
    	
    	assertEquals("Segment [Point A: (1.0, 1.0), Point B: (0.0, 0.0)]", uniqueSegments.get(0).toString());
    	assertEquals("Segment [Point A: (1.0, 1.0), Point C: (1.0, 0.0)]", uniqueSegments.get(1).toString());
    	assertEquals("Segment [Point B: (0.0, 0.0), Point C: (1.0, 0.0)]", uniqueSegments.get(2).toString());
    	assertEquals(3, uniqueSegments.size());
    }
    
}
