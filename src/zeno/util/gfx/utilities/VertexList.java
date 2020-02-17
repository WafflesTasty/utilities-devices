package zeno.util.gfx.utilities;

import zeno.util.geom.collidables.IGeometry;

/**
 * The {@code VertexList} class defines a generator for ordered vertices.
 * 
 * @param <G>  the type of geometry generated
 * @since Aug 22, 2015
 * @author Zeno
 * 
 * @see IGeometry
 */
public abstract class VertexList<G extends IGeometry>
{		
	/**
	 * The {@code OrderBy} class defines vertex order methods.
	 *
	 * @author Zeno
	 * @since Apr 9, 2016
	 */
	public class OrderBy
	{		
		/**
		 * Returns a vertex order as points.
		 * 
		 * @param geom  a geometry to order
		 * @return  a points order
		 * @see Integer
		 */
		public final int[] Points(G geom)
		{
			int[] order = new int[Count(geom)];
			for(int i = 0; i < Count(geom); i++)
			{
				order[i] = i;
			}
			
			return order;
		}
		
		
		/**
		 * Returns a vertex order as an adjacency triangle strip.
		 * 
		 * @param geom  a geometry to order
		 * @return  an adjacency triangle strip order
		 * @see Integer
		 */
		public int[] TriangleStripAdjacency(G geom)
		{
			throw new UnsupportedOperationException("IGeometry unfit to order by triangle strip (adjacency).");
		}
		
		/**
		 * Returns a vertex order as adjacency triangles.
		 * 
		 * @param geom  a geometry to order
		 * @return  an adjacency triangles order
		 * @see Integer
		 */
		public int[] TrianglesAdjacency(G geom)
		{
			throw new UnsupportedOperationException("IGeometry unfit to order by triangles (adjacency).");
		}
		
		
		/**
		 * Returns a vertex order as an adjacency line strip.
		 * 
		 * @param geom  a geometry to order
		 * @return  an adjacency line strip order
		 * @see Integer
		 */
		public int[] LineStripAdjacency(G geom)
		{
			throw new UnsupportedOperationException("IGeometry unfit to order by line strip (adjacency).");
		}
		
		/**
		 * Returns a vertex order as adjacency lines.
		 * 
		 * @param geom  a geometry to order
		 * @return  an adjacency lines order
		 * @see Integer
		 */
		public int[] LinesAdjacency(G geom)
		{
			throw new UnsupportedOperationException("IGeometry unfit to order by lines (adjacency).");
		}
		
		
		/**
		 * Returns a vertex order as a triangle strip.
		 * 
		 * @param geom  a geometry to order
		 * @return  a triangle strip order
		 * @see Integer
		 */
		public int[] TriangleStrip(G geom)
		{
			throw new UnsupportedOperationException("IGeometry unfit to order by triangle strip.");
		}
		
		/**
		 * Returns a vertex order as a triangle fan.
		 * 
		 * @param geom  a geometry to order
		 * @return  a triangle fan order
		 * @see Integer
		 */
		public int[] TriangleFan(G geom)
		{
			throw new UnsupportedOperationException("IGeometry unfit to order by triangle fan.");
		}
		
		/**
		 * Returns a vertex order as triangles.
		 * 
		 * @param geom  a geometry to order
		 * @return  a triangles order
		 * @see Integer
		 */
		public int[] Triangles(G geom)
		{
			throw new UnsupportedOperationException("IGeometry unfit to order by triangles.");
		}
		
		
		/**
		 * Returns a vertex order as a line strip.
		 * 
		 * @param geom  a geometry to order
		 * @return  a line strip order
		 * @see Integer
		 */
		public int[] LineStrip(G geom)
		{
			throw new UnsupportedOperationException("IGeometry unfit to order by line strip.");
		}
		
		/**
		 * Returns a vertex order as a line loop.
		 * 
		 * @param geom  a geometry to order
		 * @return  a line loop order
		 * @see Integer
		 */
		public int[] LineLoop(G geom)
		{
			throw new UnsupportedOperationException("IGeometry unfit to order by line loop.");
		}
		
		/**
		 * Returns a vertex order as lines.
		 * 
		 * @param geom  a geometry to order
		 * @return  a lines order
		 * @see Integer
		 */
		public int[] Lines(G geom)
		{
			throw new UnsupportedOperationException("IGeometry unfit to order by lines.");
		}
	}

	
	/**
	 * Returns the vertex order methods of the {VertexList}.
	 * 
	 * @return  the generator's order methods
	 * @see OrderBy
	 */
	public OrderBy OrderBy()
	{
		return new OrderBy();
	}
	
	/**
	 * Returns the vertex count of the {@code VertexList}.
	 * 
	 * @param geom  a geometry to generate for
	 * @return  the generator's vertex count
	 */
	public abstract int Count(G geom);
}