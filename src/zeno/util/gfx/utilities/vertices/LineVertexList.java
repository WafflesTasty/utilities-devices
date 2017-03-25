package zeno.util.gfx.utilities.vertices;

import zeno.util.algebra.tensors.vectors.fixed.Vector2;
import zeno.util.algebra.tensors.vectors.fixed.Vector3;
import zeno.util.geom.shapes.lines.Line;
import zeno.util.geom.shapes.lines.Line2D;
import zeno.util.geom.shapes.lines.Line3D;
import zeno.util.gfx.utilities.VertexList;

/**
 * The {@code LineVertexList} class defines a generator for line vertices.
 * 
 * @since Mar 22, 2017
 * @author Zeno
 * 
 * @see VertexList
 * @see Line
 */
public class LineVertexList extends VertexList<Line>
{
	/**
	 * The {@code OrderBy} class defines all vertex order methods.
	 *
	 * @since Apr 9, 2016
	 * @author Zeno
	 * 
	 * @see VertexList
	 * @see Line
	 */
	public class OrderBy extends VertexList<Line>.OrderBy
	{
		@Override
		public int[] LineStripAdjacency(Line l)
		{
			return LinesAdjacency(l);
		}
		
		@Override
		public int[] LinesAdjacency(Line l)
		{
			return new int[]
			{
				1, 0, 1, 0	
			};
		}
		
		
		@Override
		public int[] LineStrip(Line l)
		{
			return Lines(l);
		}
		
		@Override
		public int[] Lines(Line l)
		{
			return new int[]
			{
				0, 1	
			};
		}
	}
	
		
	/**
	 * Generates vertices for a {@code Line2D}.
	 * 
	 * @param l  a line to generate
	 * @return  a list of vertices
	 * @see Vector2
	 * @see Line2D
	 */
	public Vector2[] generate(Line2D l)
	{
		return new Vector2[]
		{
			l.P1(), l.P2()	
		};
	}
	
	/**
	 * Generates vertices for a {@code Line3D}.
	 * 
	 * @param l  a line to generate
	 * @return  a list of vertices
	 * @see Vector3
	 * @see Line3D
	 */
	public Vector3[] generate(Line3D l)
	{
		return new Vector3[]
		{
			l.P1(), l.P2()	
		};
	}
		

	@Override
	public int Count(Line l)
	{
		return 2;
	}
	
	@Override
	public OrderBy OrderBy()
	{
		return new OrderBy();
	}
}