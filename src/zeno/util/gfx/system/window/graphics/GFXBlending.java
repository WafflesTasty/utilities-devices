package zeno.util.gfx.system.window.graphics;

import zeno.util.gfx.utilities.Color;
import zeno.util.tools.patterns.manipulators.Resettable;

/**
 * The {@code GFXBlending} interface defines blending options for {@code GFXGraphics}.
 * Blending can be activated separately for color and alpha values. Both source and
 * destination values are first multiplied by their respective factors,
 * and then blended using the provided method.
 * 
 * @author Zeno
 * @since Sep 12, 2016
 * @version 1.0
 * 
 * 
 * @see Resettable
 */
public interface GFXBlending extends Resettable
{
	/**
	 * The {@code Factor} enum defines blending factors.
	 * 
	 * @author Zeno
	 * @since Sep 12, 2016
	 * @version 1.0
	 * 
	 * 
	 * @see GFXBlending
	 */
	public static enum Factor
	{
		/**
		 * The minimum between source and one minus destination.
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
	 * The {@code Method} enum defines blending methods.
	 * 
	 * @author Zeno
	 * @since Sep 12, 2016
	 * @version 1.0
	 * 
	 * 
	 * @see GFXBlending
	 */
	public static enum Method
	{
		/**
		 * The source is subtracted from the destination.
		 */
		REVERSE_SUBTRACT,
		/**
		 * The destination is subtracted from the source.
		 */
		SUBTRACT,
		/**
		 * The source and destination are added together.
		 */
		ADD,
		/**
		 * The minimum of source and destination.
		 */
		MIN,
		/**
		 * The maximum of source and destination.
		 */
		MAX;
	}
	

	/**
	 * Changes the method of the {@code GFXBlending}.
	 * 
	 * @param method  a blending method
	 * @param src  a source factor
	 * @param dst  a destination factor
	 * 
	 * 
	 * @see Factor
	 * @see Method
	 */
	public default void setMethod(Method method, Factor src, Factor dst)
	{
		setAlphaMethod(method, src, dst);
		setColorMethod(method, src, dst);
	}
	
	/**
	 * Changes the alpha method of the {@code GFXBlending}.
	 * 
	 * @param method  a blending method
	 * @param src  a source factor
	 * @param dst  a destination factor
	 * 
	 * 
	 * @see Factor
	 * @see Method
	 */
	public abstract void setAlphaMethod(Method method, Factor src, Factor dst);
	
	/**
	 * Changes the color method of the {@code GFXBlending}.
	 * 
	 * @param method  a blending method
	 * @param src  a source factor
	 * @param dst  a destination factor
	 * 
	 * 
	 * @see Factor
	 * @see Method
	 */
	public abstract void setColorMethod(Method method, Factor src, Factor dst);
	
	/**
	 * Changes the color of the {@code GFXBlending}.
	 * 
	 * @param color  a blending color
	 * 
	 * 
	 * @see Color
	 */
	public abstract void setColor(Color color);
}
