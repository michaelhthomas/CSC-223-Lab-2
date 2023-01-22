package input.components.segment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import input.components.point.PointNode;

public class SegmentNodeTest {

	@Test
	void segmentNodeTest() {
		PointNode point1 = new PointNode(0,0);
		PointNode point2 = new PointNode(1,1);
		SegmentNode segment = new SegmentNode(point1, point2);
		
		assertEquals(point1, segment.getPoint1());
		assertEquals(point2, segment.getPoint2());
	}
	
	@Test
	void segmentNodeNullPointsTest() {
		SegmentNode segment = new SegmentNode(null, null);
		
		assertEquals(null, segment.getPoint1());
		assertEquals(null, segment.getPoint2());
	}
	
	@Test
	void equalsNotEqual() {
		SegmentNode segment1 = new SegmentNode(new PointNode(0,0), new PointNode(1,1));
		SegmentNode segment2 = new SegmentNode(new PointNode(2,2), new PointNode(3,3));
		
		assertEquals(false, segment1.equals(segment2));
	}
	
	@Test
	void equalsSame() {
		SegmentNode segment1 = new SegmentNode(new PointNode(0,0), new PointNode(1,1));
		SegmentNode segment2 = new SegmentNode(new PointNode(0,0), new PointNode(1,1));
		
		assertEquals(true, segment1.equals(segment2));
	}
	
	@Test
	void equalsFlipped() {
		SegmentNode segment1 = new SegmentNode(new PointNode(0,0), new PointNode(1,1));
		SegmentNode segment2 = new SegmentNode(new PointNode(1,1), new PointNode(0,0));
		
		assertEquals(true, segment1.equals(segment2));
	}
	
	@Test
	void equalsOtherType() {
		SegmentNode segment = new SegmentNode(new PointNode(0,0), new PointNode(1,1));
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		assertEquals(false, segment.equals(map));
	}
	
	@Test
	void equalsSelf() {
		SegmentNode segment = new SegmentNode(new PointNode(0,0), new PointNode(1,1));
		
		assertEquals(true, segment.equals(segment));
	}
	
	@Test
	void equalsNull() {
		SegmentNode segment1 = new SegmentNode(new PointNode(0,0), new PointNode(1,1));
		SegmentNode segment2 = null;
		
		assertEquals(false, segment1.equals(segment2));
	}
}
