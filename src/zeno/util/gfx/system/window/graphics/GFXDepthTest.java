package zeno.util.gfx.system.window.graphics;

import zeno.util.tools.patterns.manipulators.Resettable;

/**
 * The {@code GFXDepthTest} interface defines depth test options for {@code GFXGraphics}.
 * Every vertex fragment that fails the depth test method within the defined bounds,
 * is disregarded by the renderer and not displayed on screen.
 * 
 * @author Zeno
 * @since Sep 12, 2016
 * @version 1.0
 * 
 * 
 * @see Resettable
 */
public interface GFXDepthTest extends Resettable
{
	/**
	 * The {@code Method} enum defines depth test methods.
	 * 
	 * @author Zeno
	 * @since Sep 12, 2016
	 * @version 1.0
	 * 
	 * 
	 * @see GFXDepthTest
	 */
	public static enum Method
	{
		/**
		 * Fragments must be greater or equal to buffer depth.
		 */
		GEQUAL,
		/**
		 * Fragments must be lower or equal to buffer depth.
		 */
		LEQUAL,
		
		/**
		 * Fragments must be different from buffer depth.
		 */
		NOTEQUAL,
		/**
		 * Fragments must be equal to buffer depth.
		 */
		EQUAL,
		
		/**
		 * Fragments must be greater than buffer depth.
		 */
		GREATER,
		/**
		 * Fragments must be lower than buffer depth.
		 */
		LESS,
		
		/**
		 * Fragments always pass the depth test.
		 */
		ALWAYS,
		/**
		 * Fragments never pass the depth test.
		 */
		NEVER;
	}

	
	/**
	 * Changes the writeability of the {@code GFXDepthTest}.
	 * 
	 * @param isReadOnly  a writeability state
	 */
	public abstract void setReadOnly(boolean isReadOnly);
	
	/**
	 * Changes the bound values of the {@code GFXDepthTest}.
	 * Fragments will be disregarded if they fall outside
	 * these bounds, which must be within the
	 * range of [0.0, 1.0].
	 * 
	 * @param min  a minimum depth value
	 * @param max  a maximum depth value
	 */
	public abstract void setBounds(float min, float max);
	
	/**
	 * Changes the method of the {@code GFXDepthTest}.
	 * 
	 * @param method  a depth test method
	 * 
	 * 
	 * @see Method
	 */
	public abstract void setMethod(Method method);
}