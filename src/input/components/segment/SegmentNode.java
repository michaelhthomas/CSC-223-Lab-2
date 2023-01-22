package input.components.segment;

import java.util.Objects;

import input.components.point.PointNode;
import utilities.math.MathUtilities;

/**
 * A utility class only for representing ONE segment
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SegmentNode other = (SegmentNode) obj;
		return MathUtilities.doubleEquals(_point1.getX(), other._point1.getX()) &&
			   MathUtilities.doubleEquals(_point1.getY(), other._point1.getY()) &&
			   MathUtilities.doubleEquals(_point2.getX(), other._point2.getX()) &&
			   MathUtilities.doubleEquals(_point2.getY(), other._point2.getY());
	}

	
	
}