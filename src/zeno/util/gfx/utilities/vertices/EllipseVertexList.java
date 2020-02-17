package zeno.util.gfx.utilities.vertices;

import zeno.util.algebra.linear.vector.fixed.Vector2;
import zeno.util.algebra.linear.vector.fixed.Vector3;
import zeno.util.geom.collidables.geometry.generic.IEllipsoid;
import zeno.util.geom.collidables.geometry.planar.Ellipse;
import zeno.util.geom.collidables.geometry.spatial.Ellipsoid;
import zeno.util.gfx.utilities.VertexList;
import zeno.util.tools.Floats;

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
			int[] order = new int[60];
			
			order[ 0] =  0; order[ 1] =  4; order[ 2] =  1;
			order[ 3] =  0; order[ 4] =  9; order[ 5] =  4;
			order[ 6] =  9; order[ 7] =  5; order[ 8] =  4;
			order[ 9] =  4; order[10] =  5; order[11] =  8;
			order[12] =  4; order[13] =  8; order[14] =  1;
			order[15] =  8; order[16] = 10; order[17] =  1;
			order[18] =  8; order[19] =  3; order[20] = 10;
			order[21] =  5; order[22] =  3; order[23] =  8;
			order[24] =  5; order[25] =  2; order[26] =  3;
			order[27] =  2; order[28] =  7; order[29] =  3;
			order[30] =  7; order[31] = 10; order[32] =  3;
			order[33] =  7; order[34] =  6; order[35] = 10;
			order[36] =  7; order[37] = 11; order[38] =  6;
			order[39] = 11; order[40] =  0; order[41] =  6;
			order[42] =  0; order[43] =  1; order[44] =  6;
			order[45] =  6; order[46] =  1; order[47] = 10;
			order[48] =  9; order[49] =  0; order[50] = 11;
			order[51] =  9; order[52] = 11; order[53] =  2;
			order[54] =  9; order[55] =  2; order[56] =  5;
			order[57] =  7; order[58] =  2; order[59] = 11;
			
//			int vcount = Count(e) - 1;
//			int[] order = new int[3 * vcount];
			
//			for(int i = 0; i < vcount; i++)
//			{
//				order[3 * i + 0] = vcount;
//				order[3 * i + 1] = (i + 0) % vcount;
//				order[3 * i + 2] = (i + 1) % vcount;
//			}
			
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
	 * Changes the vertex count of an {@code Ellipse}.
	 * 
	 * @param count  a new vertex count
	 */
	public void setVCount(int count)
	{
		vCount = count;
	}
	
	/**
	 * Generates vertices for an {@code Ellipsoid}.
	 * 
	 * @param e  an ellipsoid to generate
	 * @return  a list of vertices
	 * @see Ellipsoid
	 * @see Vector3
	 */
	public Vector3[] generate(Ellipsoid e)
	{
		Vector3[] vertices = new Vector3[12];
		
		float x = .525731112119133606f;
		float z = .850650808352039932f;
		
		vertices[ 0] = new Vector3(-x, 0f, z);
		vertices[ 1] = new Vector3( x, 0f, z);
		vertices[ 2] = new Vector3(-x, 0f,-z);
		vertices[ 3] = new Vector3( x, 0f,-z);
		
		vertices[ 4] = new Vector3(0f, z, x);
		vertices[ 5] = new Vector3(0f, z,-x);
		vertices[ 6] = new Vector3(0f,-z, x);
		vertices[ 7] = new Vector3(0f,-z,-x);
		
		vertices[ 8] = new Vector3( z, x, 0f);
		vertices[ 9] = new Vector3(-z, x, 0f);
		vertices[10] = new Vector3( z,-x, 0f);
		vertices[11] = new Vector3(-z,-x, 0f);
		
		return vertices;
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
			float angle = 2 * Floats.PI * i / vCount;
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