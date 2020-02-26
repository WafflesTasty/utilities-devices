package zeno.util.gfx.frame.graphics;

import zeno.util.gfx.utilities.Color;
import zeno.util.tools.patterns.manipulators.Resettable;

/**
 * The {@code GFXBlending} interface defines configurations for color blending.
 * <br> Blending can be activated separately for color and alpha values.
 * Both source and destination values are first multiplied by their
 * respective factors, and then blended using the provided method.
 * 
 * @since Sep 12, 2016
 * @author Zeno
 */
public interface GFXBlending extends Resettable
{
	/**
	 * The {@code Method} enum defines the blending operators.
	 * 
	 * @since Sep 12, 2016
	 * @author Zeno
	 * 
	 * @see GFXBlending
	 */
	public static enum Method
	{
		/**
		 * The results are the source subtracted from the destination.
		 */
		REVERSE_SUBTRACT,
		/**
		 * The results are the destination subtracted from the source.
		 */
		SUBTRACT,
		/**
		 * The results are the sum of source and destination.
		 */
		ADD,
		
		/**
		 * The results are the minimum of source and destination.
		 */
		MIN,
		/**
		 * The results are the maximum of source and destination.
		 */
		MAX;
	}
	
	/**
	 * The {@code Factor} enum defines the blending factors.
	 * 
	 * @since Sep 12, 2016
	 * @author Zeno
	 * 
	 * @see GFXBlending
	 */
	public static enum Factor
	{
		/**
		 * The minimum percentage between source and one minus the destination.
		 */
		SRC_ALPHA_SATURATE,
		
		/**
		 * One minus a constant alpha.
		 */
		ONE_MINUS_CONSTANT_ALPHA,
		/**
		 * One minus a constant color.
		 */
		ONE_MINUS_CONSTANT_COLOR,

		/**
		 * One minus the source alpha percentage.
		 */
		ONE_MINUS_SRC1_ALPHA,
		/**
		 * One minus the source color percentage.
		 */
		ONE_MINUS_SRC1_COLOR,
		
		/**
		 * One minus the destination alpha.
		 */
		ONE_MINUS_DST_ALPHA,
		/**
		 * One minus the destination color.
		 */
		ONE_MINUS_DST_COLOR,
		/**
		 * One minus the source alpha.
		 */
		ONE_MINUS_SRC_ALPHA,
		/**
		 * One minus the source color.
		 */
		ONE_MINUS_SRC_COLOR,
		
		/**
		 * A constant alpha.
		 */
		CONSTANT_ALPHA,
		/**
		 * A constant color.
		 */
		CONSTANT_COLOR,

		/**
		 * The source alpha percentage.
		 */
		SRC1_ALPHA,
		/**
		 * The source color percentage.
		 */
		SRC1_COLOR,
			
		/**
		 * The destination alpha.
		 */
		DST_ALPHA,
		/**
		 * The destination color.
		 */
		DST_COLOR,
		/**
		 * The source alpha.
		 */
		SRC_ALPHA,
		/**
		 * The source color.
		 */
		SRC_COLOR,
		
		/**
		 * The constant zero.
		 */
		ZERO,
		/**
		 * The constant one.
		 */
		ONE;
	}
	
	
	/**
	 * Changes the method of the {@code GFXBlend}.
	 * 
	 * @param method  a blending method
	 * @param src  a source multiplication factor
	 * @param dst  a destination multiplication factor
	 */
	public default void setMethod(Method method, Factor src, Factor dst)
	{
		setAlphaMethod(method, src, dst);
		setColorMethod(method, src, dst);
	}
	
	/**
	 * Changes the alpha method of the {@code GFXBlend}.
	 * 
	 * @param method  an alpha blending method
	 * @param src  a source multiplication factor
	 * @param dst  a destination multiplication factor
	 */
	public abstract void setAlphaMethod(Method method, Factor src, Factor dst);
	
	/**
	 * Changes the color method of the {@code GFXBlend}.
	 * 
	 * @param method  an color blending method
	 * @param src  a source multiplication factor
	 * @param dst  a destination multiplication factor
	 */
	public abstract void setColorMethod(Method method, Factor src, Factor dst);
	
	/**
	 * Changes the color of the {@code GFXBlend}.
	 * 
	 * @param color  a color constant
	 * @see Color
	 */
	public abstract void setColor(Color color);
}
