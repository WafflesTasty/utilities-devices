package waffles.utils.sys.memory.config;

import waffles.utils.algebra.elements.linear.matrix.Matrices;
import waffles.utils.algebra.elements.linear.matrix.fixed.Matrix4x4;
import waffles.utils.sys.video.frames.GFXFrame;
import waffles.utils.sys.video.graphics.GFXGraphics;

/**
 * The {@code WindowConfig} manages the creation of various
 * hardware-accelerated objects for a {@code GFXWindow}.
 *
 * @author Waffles
 * @since 14 Mar 2025
 * @version 1.1
 */
public interface WindowConfig
{		
	/**
	 * Creates a new {@code GFXFrame}.
	 * 
	 * @return  a graphics frame
	 * 
	 * 
	 * @see GFXFrame
	 */
	public abstract GFXFrame createFrame();
	
	/**
	 * Creates new {@code GFXGraphics}.
	 * 
	 * @return  a graphics object
	 * 
	 * 
	 * @see GFXGraphics
	 */
	public abstract GFXGraphics createGraphics();

	
	/**
	 * Creates a new NDC {@code Matrix4x4}.
	 * 
	 * @return  an ndc matrix
	 * 
	 * 
	 * @see Matrix4x4
	 */
	public default Matrix4x4 NDCMatrix()
	{
		return Matrices.identity(4);
	}
}