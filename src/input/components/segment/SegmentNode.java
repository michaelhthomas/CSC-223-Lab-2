package input.components.segment;

import input.components.point.PointNode;

/**
 * A 2D line segment (x1, y1), (x2, y2)
 * <p>The order of the points does not matter.
 *
 * @author Michael Thomas, Jake Shore
 * @date 1/26/2022
 */
public class SegmentNode
{
	protected PointNode _point1;
	protected PointNode _point2;
	
	public PointNode getPoint1() { return _point1; }
	public PointNode getPoint2() { return _point2; }
	
	public SegmentNode(PointNode pt1, PointNode pt2) {
		_point1 = pt1;
		_point2 = pt2;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		SegmentNode other = (SegmentNode) obj;
		return (_point1.equals(other._point1)  && _point2.equals(other._point2)) ||
			   (_point1.equals(other._point2)  && _point2.equals(other._point1));
	}
	
	@Override
	public String toString() {
		return "Segment ["+ _point1 + ", " + _point2 + "]";
	}
}
