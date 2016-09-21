package zeno.util.gfx.frame.graphics;

/**
 * The {@code GFXDepthTest} interface defines configurations of the depth test.
 * 
 * @since Sep 12, 2016
 * @author Zeno
 */
public interface GFXDepthTest
{
	/**
	 * The {@code Method} enum defines depth validation operators.
	 * 
	 * @since Sep 12, 2016
	 * @author Zeno
	 * 
	 * @see GFXDepthTest
	 */
	public static enum Method
	{
		/**
		 * Pass the depth test if fragment depth is greater or equal to buffer depth.
		 */
		GEQUAL,
		/**
		 * Pass the depth test if fragment depth is lower or equal to buffer depth.
		 */
		LEQUAL,
		
		/**
		 * Pass the depth test if fragment depth is not equal to buffer depth.
		 */
		NOTEQUAL,
		/**
		 * Pass the depth test if fragment depth is equal to buffer depth.
		 */
		EQUAL,
		
		/**
		 * Pass the depth test if fragment depth is greater than buffer depth.
		 */
		GREATER,
		/**
		 * Pass the depth test if fragment depth is less than buffer depth.
		 */
		LESS,
		
		/**
		 * Always pass the depth test.
		 */
		ALWAYS,
		/**
		 * Never pass the depth test.
		 */
		NEVER;
	}

	
	/**
	 * Changes the currently used bounds of the depth test.
	 * <br> Draw calls will scale the depth of fragments between
	 * these values. A full depth buffer is defined in 
	 * the interval [0.0, 1.0].
	 * 
	 * @param min  the minimum depth buffer value
	 * @param max  the maximum depth buffer value
	 */
	public abstract void setBounds(float min, float max);
	
	/**
	 * Changes the active {@code Method} of the depth test.
	 * <br> This method defines the conditional comparison
	 * between the source and target depth.
	 * 
	 * @param method  a new method
	 * @see Method
	 */
	public abstract void setMethod(Method method);
}