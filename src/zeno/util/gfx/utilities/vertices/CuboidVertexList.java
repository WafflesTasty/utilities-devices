package zeno.util.gfx.utilities.vertices;

import java.util.ArrayList;
import java.util.List;

import zeno.util.algebra.linear.vector.Vector;
import zeno.util.algebra.linear.vector.Vectors;
import zeno.util.algebra.linear.vector.fixed.Vector2;
import zeno.util.algebra.linear.vector.fixed.Vector3;
import zeno.util.geom.collidables.geometry.generic.ICuboid;
import zeno.util.geom.collidables.geometry.planar.Rectangle;
import zeno.util.geom.collidables.geometry.spatial.Cuboid;
import zeno.util.gfx.utilities.VertexList;
import zeno.util.tools.Integers;

/**
 * The {@code CuboidVertexList} class defines a generator for cuboid vertices.
 * 
 * @since Mar 22, 2017
 * @author Zeno
 * 
 * @see VertexList
 * @see ICuboid
 */
public class CuboidVertexList extends VertexList<ICuboid>
{
	/**
	 * The {@code OrderBy} class defines all vertex order methods.
	 *
	 * @since Apr 9, 2016
	 * @author Zeno
	 * 
	 * @see VertexList
	 */
	public class OrderBy extends VertexList<ICuboid>.OrderBy
	{
		@Override
		public int[] LineStripAdjacency(ICuboid c)
		{
			if(c.Dimension() == 2)
			{
				return new int[]
				{
					1,
					0, 2, 3, 1, 0,
					2
				};
			}
			
			return new int[0];
		}
		
		@Override
		public int[] LinesAdjacency(ICuboid c)
		{
			if(c.Dimension() == 2)
			{
				return new int[]
				{
					1, 0, 2, 3,
					0, 2, 3, 1,
					2, 3, 1, 0,
					3, 1, 0, 2
				};
			}
			
			return new int[0];
		}
		
		
		@Override
		public int[] TriangleStrip(ICuboid c)
		{
			if(c.Dimension() == 2)
			{
				return new int[]
				{
					0, 2, 1, 3
				};
			}
			
			if(c.Dimension() == 3)
			{
				return new int[]
				{
					2, 0, 3, 1, 7, 5,
					1, 0, 5, 4, 7, 6,
					4, 0, 6, 2, 7, 3
				};
			}
			
			return new int[0];
		}
		
		@Override
		public int[] Triangles(ICuboid c)
		{
			if(c.Dimension() == 2)
			{
				return new int[]
				{
					0, 2, 3,
					0, 1, 3
				};
			}
			
			if(c.Dimension() == 3)
			{
				return new int[]
				{
					2, 0, 3,  0, 1, 3,
					3, 1, 7,  1, 5, 7,
					5, 4, 7,  4, 6, 7,
					6, 2, 7,  2, 3, 7,
					1, 0, 5,  0, 4, 5,
					4, 0, 6,  0, 2, 6
				};
			}
			
			return new int[0];
		}
		
		
		@Override
		public int[] LineStrip(ICuboid c)
		{
			if(c.Dimension() == 2)
			{
				return new int[]
				{
					0, 2, 3, 1, 0
				};
			}
			
			return new int[0];
		}
		
		@Override
		public int[] LineLoop(ICuboid c)
		{
			if(c.Dimension() == 2)
			{
				return new int[]
				{
					0, 2, 3, 1
				};
			}
			
			return new int[0];
		}
			
		@Override
		public int[] Lines(ICuboid c)
		{
			if(c.Dimension() == 2)
			{
				return new int[]
				{
					0, 2,
					2, 3,
					3, 1,
					1, 0
				};
			}
			
			if(c.Dimension() == 3)
			{
				return new int[]
				{
					2, 0,  0, 1,  1, 3,  3, 2,
					3, 1,  1, 5,  5, 7,  7, 3,
					1, 0,  0, 4,  4, 5,  5, 1,
					5, 4,  4, 6,  6, 7,  7, 5,
					4, 0,  0, 2,  2, 6,  6, 4,
					6, 2,  2, 3,  3, 7,  7, 6
				};
			}
			
			return new int[0];
		}
	}
	
		
	/**
	 * Generates vertices for a {@code Cuboid}.
	 * 
	 * @param c  a cuboid to generate
	 * @return  a list of vertices
	 * @see Vector3
	 * @see Cuboid
	 */
	public Vector3[] generate(Cuboid c)
	{
		List<Vector> list = vertexlist(c);
		return list.toArray(new Vector3[0]);
	}
	
	/**
	 * Generates vertices for a {@code Rectangle}.
	 * 
	 * @param r  a rectangle to generate
	 * @return  a list of vertices
	 * @see Rectangle
	 * @see Vector2
	 */
	public Vector2[] generate(Rectangle r)
	{
		List<Vector> list = vertexlist(r);
		return list.toArray(new Vector2[0]);
	}

	
	List<Vector> vertexlist(ICuboid c)
	{
		Vector min = c.Minimum();
		Vector max = c.Maximum();

		List<Vector> list = new ArrayList<>();
		for(int i = 0; i < Count(c); i++)
		{
			Vector v = Vectors.create(c.Dimension());
			for(int j = 0; j < c.Dimension(); j++)
			{
				if(Integers.bitAt(i, j) == 0)
					v.set(min.get(j), j);
				else
					v.set(max.get(j), j);
			}
			
			list.add(v);
		}
		
		return list;
	}
	
	@Override
	public int Count(ICuboid c)
	{
		return Integers.pow(2, c.Dimension());
	}
		
	@Override
	public OrderBy OrderBy()
	{
		return new OrderBy();
	}
}