package waffles.utils.sys.video.graphics.cmds;

import waffles.utils.geom.utilities.VChain.Mode;
import waffles.utils.tools.patterns.semantics.Resettable;

/**
 * The {@code GFXRenderer} executes draw commands for the {@code GFXGraphics}.
 *
 * @author Waffles
 * @since 12 Mar 2025
 * @version 1.1
 * 
 * 
 * @see Resettable
 */
public interface GFXRenderer extends Resettable
{
	/**
	 * Draws vertices in order as they appear in the index buffer.
	 * Instancing is disabled through this command.
	 * 
	 * @param mode     a vertex draw mode
	 * @param vCount   a set of vertex draw counts
	 * @param vFirst   a set of vertex draw offsets
	 * @param vOffset  a set of index draw offsets
	 * 
	 * 
	 * @see Mode
	 */
	public abstract void indices(Mode mode, int[] vCount, int[] vFirst, int[] vOffset);
			
	/**
	 * Draws vertices in order as they appear in the index buffer.
	 * Instancing is enabled through this command.
	 * 
	 * @param mode     a vertex draw mode
	 * @param vCount   a vertex draw count
	 * @param vFirst   a vertex draw offset
	 * @param vOffset  an index draw offset
	 * @param iCount   an instance draw count
	 * @param iOffset  an instance draw offset
	 * 
	 * 
	 * @see Mode
	 */
	public abstract void indices(Mode mode, int vCount, int vFirst, int vOffset, int iCount, int iOffset);
	
	/**
	 * Draws vertices in order as they appear in the index buffer.
	 * Instancing is enabled through this command, which is
	 * initiated at the beginning of the instance buffer.
	 * 
	 * @param mode     a vertex draw mode
	 * @param vCount   a vertex draw count
	 * @param vFirst   a vertex draw offset
	 * @param vOffset  an index draw offset
	 * @param iCount   an instance draw count
	 * 
	 * 
	 * @see Mode
	 */
	public default void indices(Mode mode, int vCount, int vFirst, int vOffset, int iCount)
	{
		indices(mode, vCount, vFirst, vOffset, iCount, 0);
	}
	
	/**
	 * Draws vertices in order as they appear in the index buffer.
	 * Instancing is disabled through this command.
	 * 
	 * @param mode     a vertex draw mode
	 * @param vCount   a vertex draw count
	 * @param vFirst   a vertex draw offset
	 * @param vOffset  an index draw offset
	 * 
	 * 
	 * @see Mode
	 */
	public default void indices(Mode mode, int vCount, int vFirst, int vOffset)
	{
		indices(mode, vCount, vFirst, vOffset, 0);
	}
	
	/**
	 * Draws vertices in order as they appear in the index buffer.
	 * Instancing is disabled through this command.
	 * 
	 * @param mode    a vertex draw mode
	 * @param vCount  a vertex draw count
	 * @param vFirst  a vertex draw offset
	 * 
	 * 
	 * @see Mode
	 */
	public default void indices(Mode mode, int vCount, int vFirst)
	{
		indices(mode, vCount, vFirst, 0);
	}
	
	/**
	 * Draws vertices in order as they appear in the index buffer.
	 * Instancing is disabled through this command, which is
	 * initiated at the beginning of the vertex buffer.
	 * 
	 * @param mode    a vertex draw mode
	 * @param vCount  a vertex draw count
	 * 
	 * 
	 * @see Mode
	 */
	public default void indices(Mode mode, int vCount)
	{
		indices(mode, vCount, 0);
	}
	
	
	/**
	 * Draws vertices in order as they appear in the vertex buffer.
	 * Instancing is disabled through this command.
	 * 
	 * @param mode    a vertex draw mode
	 * @param vCount  a set of vertex draw counts
	 * @param vFirst  a set of vertex draw offsets
	 * 
	 * 
	 * @see Mode
	 */
	public abstract void vertices(Mode mode, int[] vCount, int[] vFirst);
	
	/**
	 * Draws vertices in order as they appear in the vertex buffer.
	 * Instancing is enabled through this command.
	 * 
	 * @param mode     a vertex draw mode
	 * @param vCount   a vertex draw count
	 * @param vFirst   a vertex draw offset
	 * @param iCount   an instance draw count
	 * @param iOffset  an instance draw offset
	 * 
	 * 
	 * @see Mode
	 */
	public abstract void vertices(Mode mode, int vCount, int vFirst, int iCount, int iOffset);
	
	/**
	 * Draws vertices in order as they appear in the vertex buffer.
	 * Instancing is enabled through this command, which is
	 * initiated at the beginning of the instance buffer.
	 * 
	 * @param mode    a vertex draw mode
	 * @param vCount  a vertex draw count
	 * @param vFirst  a vertex draw offset
	 * @param iCount  an instance draw count
	 * 
	 * 
	 * @see Mode
	 */
	public default void vertices(Mode mode, int vCount, int vFirst, int iCount)
	{
		vertices(mode, vCount, vFirst, iCount, 0);
	}
	
	/**
	 * Draws vertices in order as they appear in the vertex buffer.
	 * Instancing is disabled through this command.
	 * 
	 * @param mode    a vertex draw mode
	 * @param vCount  a vertex draw count
	 * @param vFirst  a vertex draw offset
	 * 
	 * 
	 * @see Mode
	 */
	public default void vertices(Mode mode, int vCount, int vFirst)
	{
		vertices(mode, vCount, vFirst, 0);
	}
	
	/**
	 * Draws vertices in order as they appear in the vertex buffer.
	 * Instancing is disabled through this command, which is
	 * initiated at the beginning of the vertex buffer.
	 * 
	 * @param mode    a vertex draw mode
	 * @param vCount  a vertex draw count
	 * 
	 * 
	 * @see Mode
	 */
	public default void vertices(Mode mode, int vCount)
	{
		vertices(mode, vCount, 0);
	}
}