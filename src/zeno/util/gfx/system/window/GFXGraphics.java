package zeno.util.gfx.system.window;

import zeno.util.geom.utilities.VChain.Mode;
import zeno.util.gfx.system.window.graphics.GFXBlending;
import zeno.util.gfx.system.window.graphics.GFXDepthTest;
import zeno.util.gfx.system.window.graphics.GFXScissorTest;
import zeno.util.gfx.system.window.graphics.GFXTesselation;
import zeno.util.gfx.system.window.graphics.GFXViewports;
import zeno.util.gfx.utilities.Color;
import zeno.util.tools.patterns.manipulators.Resettable;

/**
 * The {@code GFXGraphics} interface executes draw commands on a {@code GFXWindow}.
 * 
 * @author Zeno
 * @since Sep 12, 2016
 * @version 1.0
 * 
 * 
 * @see Resettable
 */
public interface GFXGraphics extends Resettable
{
	/**
	 * Returns blending options of the {@code GFXGraphics}.
	 * 
	 * @return  a set of blending options
	 * 
	 * 
	 * @see GFXBlending
	 */
	public abstract GFXBlending Blending();

	/**
	 * Returns depth test options of the {@code GFXGraphics}.
	 * 
	 * @return  a set of depth test options
	 * 
	 * 
	 * @see GFXDepthTest
	 */
	public abstract GFXDepthTest DepthTest();
		
	/**
	 * Returns scissor test options of the {@code GFXGraphics}.
	 * 
	 * @return  a set of scissor test options
	 * 
	 * 
	 * @see GFXScissorTest
	 */
	public abstract GFXScissorTest ScissorTest();

	/**
	 * Returns tesselation options of the {@code GFXGraphics}.
	 * 
	 * @return  a set of tesselation options
	 * 
	 * 
	 * @see GFXTesselation
	 */
	public abstract GFXTesselation Tesselation();
		
	/**
	 * Returns viewport options of the {@code GFXGraphics}.
	 * 
	 * @return  a set of viewport options
	 * 
	 * 
	 * @see GFXViewports
	 */
	public abstract GFXViewports Viewports();
	
	
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
	public abstract void drawIndices(Mode mode, int[] vCount, int[] vFirst, int[] vOffset);
		
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
	public abstract void drawVertices(Mode mode, int[] vCount, int[] vFirst);
	
	
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
	public abstract void drawIndices(Mode mode, int vCount, int vFirst, int vOffset, int iCount, int iOffset);
	
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
	public default void drawIndices(Mode mode, int vCount, int vFirst, int vOffset, int iCount)
	{
		drawIndices(mode, vCount, vFirst, vOffset, iCount, 0);
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
	public default void drawIndices(Mode mode, int vCount, int vFirst, int vOffset)
	{
		drawIndices(mode, vCount, vFirst, vOffset, 0);
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
	public default void drawIndices(Mode mode, int vCount, int vFirst)
	{
		drawIndices(mode, vCount, vFirst, 0);
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
	public default void drawIndices(Mode mode, int vCount)
	{
		drawIndices(mode, vCount, 0);
	}
	
	
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
	public abstract void drawVertices(Mode mode, int vCount, int vFirst, int iCount, int iOffset);
	
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
	public default void drawVertices(Mode mode, int vCount, int vFirst, int iCount)
	{
		drawVertices(mode, vCount, vFirst, iCount, 0);
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
	public default void drawVertices(Mode mode, int vCount, int vFirst)
	{
		drawVertices(mode, vCount, vFirst, 0);
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
	public default void drawVertices(Mode mode, int vCount)
	{
		drawVertices(mode, vCount, 0);
	}
	
	
	/**
	 * Clears the {@code GFXGraphics}.
	 * 
	 * @param c  a base color
	 * 
	 * 
	 * @see Color
	 */
	public abstract void clear(Color c);
	
	/**
	 * Clears the {@code GFXGraphics}.
	 */
	public default void clear()
	{
		clear(new Color(0f, 0f, 0f, 0f));
	}
	
	
	@Override
	public default void reset()
	{
		Blending().reset();
		DepthTest().reset();
		ScissorTest().reset();
		Tesselation().reset();
		Viewports().reset();
	}
}