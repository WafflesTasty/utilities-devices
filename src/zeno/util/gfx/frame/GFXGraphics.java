package zeno.util.gfx.frame;

import java.nio.ByteBuffer;

import zeno.util.gfx.GFXFrame;
import zeno.util.gfx.frame.graphics.GFXBlending;
import zeno.util.gfx.frame.graphics.GFXDepthTest;
import zeno.util.gfx.frame.graphics.GFXScissorTest;
import zeno.util.gfx.frame.graphics.GFXViewports;

/**
 * The {@code GFXGraphics} interface defines an object that executes draw calls on the active {@link GFXFrame}.
 * 
 * @since Sep 12, 2016
 * @author Zeno
 */
public interface GFXGraphics
{
	/**
	 * The {@code Mode} enum defines the modes of primitive construction.
	 * 
	 * @since Sep 11, 2016
	 * @author Zeno
	 * 
	 * @see GFXGraphics
	 */
	public static enum Mode
	{
		/**
		 * Each vertex is handled as a separate point.
		 */
		POINTS,
		
		/**
		 * Each vertex is connected with the last in a line.
		 */
		LINE_STRIP,
		/**
		 * Each vertex is connected with the last in a line.
		 * <br> The first and the last connect to make a closed loop.
		 */
		LINE_LOOP,
		/**
		 * Each pair of two separate vertices form a line.
		 */
		LINES,
		
		/**
		 * Adjacent version of {@code LINE_STRIP} for use
		 * with geometry shaders.
		 */
		LINE_STRIP_ADJ,
		/**
		 * Adjacent version of {@code LINES} for use
		 * with geometry shaders.
		 */
		LINES_ADJ,
		
		/**
		 * Each pair of three adjacent vertices form a triangle.
		 */
		TRIANGLE_STRIP,
		/**
		 * Each pair of two adjacent vertices form a triangle
		 * with the first vertex as its third.
		 */
		TRIANGLE_FAN,
		/**
		 * Each pair of three separate vertices form a triangle.
		 */
		TRIANGLES,
		
		/**
		 * Adjacent version of {@code TRIANGLE_STRIP} for use
		 * with geometry shaders.
		 */
		TRIANGLE_STRIP_ADJ,
		/**
		 * Adjacent version of {@code TRIANGLES} for use
		 * with geometry shaders.
		 */
		TRIANGLES_ADJ,
		
		/**
		 * Vertices are handled by the tesselation shaders.
		 */
		PATCHES;
	}
	
	
	/**
	 * Performs multiple draw commands ordering vertices according to the active index buffer.
	 * 
	 * @param mode  the primitive creation mode of the command
	 * @param vCount  a list of index counts to pass to each draw call
	 * @param vFirst  a list of initial indices to pass to each draw call
	 * @param vOffset  a list of index offsets to pass to each draw call
	 * @param mCount  the amount of elements in each list
	 * @see ByteBuffer
	 */
	public abstract void drawIndices(Mode mode, ByteBuffer vCount, ByteBuffer vFirst, ByteBuffer vOffset, int mCount);
		
	/**
	 * Performs multiple draw commands ordering vertices as they appear in their buffer.
	 * 
	 * @param mode  the primitive creation mode of the command
	 * @param vCount  a list of vertex counts to pass to each draw call
	 * @param vFirst  a list of initial indices to pass to each draw call
	 * @param mCount  the amount of elements in each list
	 * @see ByteBuffer
	 */
	public abstract void drawVertices(Mode mode, ByteBuffer vCount, ByteBuffer vFirst, int mCount);
	
	
	/**
	 * Performs a draw command ordering vertices according to the active index buffer.
	 * 
	 * @param mode  the primitive creation mode of the command
	 * @param vCount  the total amount of indices being processed
	 * @param vFirst  the initial index to use in the draw command
	 * @param vOffset  an offset to add to every processed index
	 * @param iCount  the total amount of instances to draw
	 * @param iOffset  an offset to apply to each instance
	 */
	public abstract void drawIndices(Mode mode, int vCount, int vFirst, int vOffset, int iCount, int iOffset);
	
	/**
	 * Performs a draw command ordering vertices according to the active index buffer.
	 * <br> The instance offset is defaulted to zero.
	 * 
	 * @param mode  the primitive creation mode of the command
	 * @param vCount  the total amount of indices being processed
	 * @param vFirst  the initial index to use in the draw command
	 * @param vOffset  an offset to add to every processed index
	 * @param iCount  the total amount of instances to draw
	 */
	public default void drawIndices(Mode mode, int vCount, int vFirst, int vOffset, int iCount)
	{
		drawIndices(mode, vCount, vFirst, vOffset, iCount, 0);
	}
	
	/**
	 * Performs a draw command ordering vertices according to the active index buffer.
	 * <br> Instancing is completely disabled through this command.
	 * 
	 * @param mode  the primitive creation mode of the command
	 * @param vCount  the total amount of indices being processed
	 * @param vFirst  the initial index to use in the draw command
	 * @param vOffset  an offset to add to every processed index
	 */
	public default void drawIndices(Mode mode, int vCount, int vFirst, int vOffset)
	{
		drawIndices(mode, vCount, vFirst, vOffset, 0);
	}
	
	/**
	 * Performs a draw command ordering vertices according to the active index buffer.
	 * <br> Instancing is completely disabled through this command, and the vertex
	 * offset is defaulted to zero.
	 * 
	 * @param mode  the primitive creation mode of the command
	 * @param vCount  the total amount of indices being processed
	 * @param vFirst  the initial index to use in the draw command
	 */
	public default void drawIndices(Mode mode, int vCount, int vFirst)
	{
		drawIndices(mode, vCount, vFirst, 0);
	}
	
	/**
	 * Performs a draw command ordering vertices according to the active index buffer.
	 * <br> Instancing is completely disabled through this command, and the command
	 * is initiated at the beginning of the index buffer.
	 * 
	 * @param mode  the primitive creation mode of the command
	 * @param vCount  the total amount of indices being processed
	 */
	public default void drawIndices(Mode mode, int vCount)
	{
		drawIndices(mode, vCount, 0);
	}
	
	
	/**
	 * Performs a draw command ordering vertices as they appear in their buffer.
	 * 
	 * @param mode  the primitive creation mode of the command
	 * @param vCount  the total amount of vertices being processed
	 * @param vFirst  the initial vertex to use in the draw command
	 * @param iCount  the total amount of instances to draw
	 * @param iOffset  an offset to apply to each instance
	 */
	public abstract void drawVertices(Mode mode, int vCount, int vFirst, int iCount, int iOffset);
	
	/**
	 * Performs a draw command ordering vertices as they appear in their buffer.
	 * <br> The instance offset is defaulted to zero.
	 * 
	 * @param mode  the primitive creation mode of the command
	 * @param vCount  the total amount of vertices being processed
	 * @param vFirst  the initial vertex to use in the draw command
	 * @param iCount  the total amount of instances to draw
	 */
	public default void drawVertices(Mode mode, int vCount, int vFirst, int iCount)
	{
		drawVertices(mode, vCount, vFirst, iCount, 0);
	}
	
	/**
	 * Performs a draw command ordering vertices as they appear in their buffer.
	 * <br> Instancing is completely disabled through this command.
	 * 
	 * @param mode  the primitive creation mode of the command
	 * @param vCount  the total amount of vertices being processed
	 * @param vFirst  the initial vertex to use in the draw command
	 */
	public default void drawVertices(Mode mode, int vCount, int vFirst)
	{
		drawVertices(mode, vCount, vFirst, 0);
	}
	
	/**
	 * Performs a draw command ordering vertices as they appear in their buffer.
	 * <br> Instancing is completely disabled through this command, and the command
	 * is initiated at the beginning of the vertex buffer.
	 * 
	 * @param mode  the primitive creation mode of the command
	 * @param vCount  the total amount of vertices being processed
	 */
	public default void drawVertices(Mode mode, int vCount)
	{
		drawVertices(mode, vCount, 0);
	}
	
	
	/**
	 * Returns the blending of the {@code GFXGraphics}.
	 * 
	 * @return  the graphics' blending
	 * @see GFXBlending
	 */
	public abstract GFXBlending Blending();

	/**
	 * Returns the depth test of the {@code GFXGraphics}.
	 * 
	 * @return  the graphics' depth test
	 * @see GFXDepthTest
	 */
	public abstract GFXDepthTest DepthTest();
	
	/**
	 * Returns the scissor test of the {@code GFXGraphics}.
	 * 
	 * @return  the graphics' scissor test
	 * @see GFXScissorTest
	 */
	public abstract GFXScissorTest ScissorTest();
	
	/**
	 * Returns the viewport of the {@code GFXGraphics}.
	 * 
	 * @return  the graphics' viewport
	 * @see GFXViewports
	 */
	public abstract GFXViewports Viewports();
}