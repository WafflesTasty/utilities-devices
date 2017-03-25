package zeno.util.gfx.utilities.vertices;

import zeno.util.algebra.tensors.vectors.fixed.Vector2;
import zeno.util.geom.shapes.IEllipsoid;
import zeno.util.geom.shapes.surfaces.Ellipse;
import zeno.util.gfx.utilities.VertexList;
import zeno.util.tools.primitives.Floats;

/**
 * The {@code CuboidVertexList} class defines a generator for cuboid vertices.
 * 
 * @since Mar 22, 2017
 * @author Zeno
 * 
 * @see VertexList
 * @see IEllipsoid
 */
public class EllipseVertexList extends VertexList<IEllipsoid>
{
	private static final int DEF_COUNT = 64;
	
	/**
	 * The {@code OrderBy} class defines all vertex order methods.
	 *
	 * @since Apr 9, 2016
	 * @author Zeno
	 * 
	 * @see VertexList
	 */
	public class OrderBy extends VertexList<IEllipsoid>.OrderBy
	{
		@Override
		public int[] LineStripAdjacency(IEllipsoid e)
		{
			int vcount = Count(e) - 1;
			int[] order = new int[vcount + 3];
			
			for(int i = 0; i < vcount + 3; i++)
			{
				order[i] = i % vcount;
			}
			
			return order;
		}
		
		@Override
		public int[] LinesAdjacency(IEllipsoid e)
		{
			int vcount = Count(e) - 1;
			int[] order = new int[4 * vcount];
			
			for(int i = 0; i < vcount; i++)
			{
				order[4 * i + 0] = (i + 0) % vcount;
				order[4 * i + 1] = (i + 1) % vcount;
				order[4 * i + 2] = (i + 2) % vcount;
				order[4 * i + 3] = (i + 3) % vcount;
			}
			
			return order;
		}
		
		
		@Override
		public int[] TriangleFan(IEllipsoid e)
		{
			int vcount = Count(e) - 1;
			int[] order = new int[vcount + 2];
			
			order[0] = vcount;
			for(int i = 0; i <= vcount; i++)
			{
				order[i + 1] = i % vcount;
			}
			
			return order;
		}
		
		@Override
		public int[] Triangles(IEllipsoid e)
		{
			int vcount = Count(e) - 1;
			int[] order = new int[3 * vcount];
			
			for(int i = 0; i < vcount; i++)
			{
				order[3 * i + 0] = vcount;
				order[3 * i + 1] = (i + 0) % vcount;
				order[3 * i + 2] = (i + 1) % vcount;
			}
			
			return order;
		}
		
		
		@Override
		public int[] LineStrip(IEllipsoid e)
		{
			int vcount = Count(e) - 1;
			int[] order = new int[vcount + 1];
			
			for(int i = 0; i <= vcount; i++)
			{
				order[i] = i % vcount;
			}
			
			return order;
		}
		
		@Override
		public int[] LineLoop(IEllipsoid e)
		{
			int vcount = Count(e) - 1;
			int[] order = new int[vcount];
			
			for(int i = 0; i < vcount; i++)
			{
				order[i] = i % vcount;
			}
			
			return order;
		}
			
		@Override
		public int[] Lines(IEllipsoid e)
		{
			int vcount = Count(e) - 1;
			int[] order = new int[2 * vcount];
			
			for(int i = 0; i < vcount; i++)
			{
				order[i + 0] = (i + 0) % vcount;
				order[i + 1] = (i + 1) % vcount;
			}
			
			return order;
		}
	}
	
	
	
	private int vCount;
	
	/**
	 * Creates a new {@code EllipseVertexList}.
	 */
	public EllipseVertexList()
	{
		this(DEF_COUNT);
	}
	
	/**
	 * Creates a new {@code EllipseVertexList}.
	 * 
	 * @param count  the vertex count
	 */
	public EllipseVertexList(int count)
	{
		vCount = count;
	}
	
	
	/**
	 * Generates vertices for an {@code Ellipse}.
	 * 
	 * @param e  an ellipse to generate
	 * @return  a list of vertices
	 * @see Ellipse
	 * @see Vector2
	 */
	public Vector2[] generate(Ellipse e)
	{
		Vector2[] vertices = new Vector2[vCount + 1];
		for(int i = 0; i < vCount; i++)
		{
			float angle = i * 2 * Floats.PI / vCount;
			float x = Floats.cos(angle) * e.Width() / 2;
			float y = Floats.sin(angle) * e.Height() / 2;
			
			vertices[i] = new Vector2(x + e.X(), y + e.Y());
		}
		
		vertices[vCount] = e.Center();
		return vertices;
	}
	
	
	@Override
	public int Count(IEllipsoid c)
	{
		return vCount + 1;
	}
		
	@Override
	public OrderBy OrderBy()
	{
		return new OrderBy();
	}
}