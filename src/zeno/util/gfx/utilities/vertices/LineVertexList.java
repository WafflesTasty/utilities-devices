package zeno.util.gfx.utilities.vertices;

import zeno.util.algebra.linear.vector.fixed.Vector2;
import zeno.util.algebra.linear.vector.fixed.Vector3;
import zeno.util.geom.collidables.geometry.generic.ISegment;
import zeno.util.geom.collidables.geometry.planar.Segment2D;
import zeno.util.geom.collidables.geometry.spatial.Segment3D;
import zeno.util.gfx.utilities.VertexList;

/**
 * The {@code LineVertexList} class defines a generator for line vertices.
 * 
 * @since Mar 22, 2017
 * @author Zeno
 * 
 * @see VertexList
 * @see ISegment
 */
public class LineVertexList extends VertexList<ISegment>
{
	/**
	 * The {@code OrderBy} class defines all vertex order methods.
	 *
	 * @since Apr 9, 2016
	 * @author Zeno
	 * 
	 * @see VertexList
	 * @see ISegment
	 */
	public class OrderBy extends VertexList<ISegment>.OrderBy
	{
		@Override
		public int[] LineStripAdjacency(ISegment l)
		{
			return LinesAdjacency(l);
		}
		
		@Override
		public int[] LinesAdjacency(ISegment l)
		{
			return new int[]
			{
				1, 0, 1, 0	
			};
		}
		
		
		@Override
		public int[] LineStrip(ISegment l)
		{
			return Lines(l);
		}
		
		@Override
		public int[] Lines(ISegment l)
		{
			return new int[]
			{
				0, 1	
			};
		}
	}
	
		
	/**
	 * Generates vertices for a {@code Segment2D}.
	 * 
	 * @param l  a line to generate
	 * @return  a list of vertices
	 * @see Vector2
	 * @see Segment2D
	 */
	public Vector2[] generate(Segment2D l)
	{
		return new Vector2[]
		{
			(Vector2) l.P1(), (Vector2) l.P2()
		};
	}
	
	/**
	 * Generates vertices for a {@code Segment3D}.
	 * 
	 * @param l  a line to generate
	 * @return  a list of vertices
	 * @see Vector3
	 * @see Segment3D
	 */
	public Vector3[] generate(Segment3D l)
	{
		return new Vector3[]
		{
			(Vector3) l.P1(), (Vector3) l.P2()
		};
	}
		

	@Override
	public int Count(ISegment l)
	{
		return 2;
	}
	
	@Override
	public OrderBy OrderBy()
	{
		return new OrderBy();
	}
}