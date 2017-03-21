package zeno.util.gfx.utilities.color;

import zeno.util.calc._deprecated.Interpolation;
import zeno.util.gfx.utilities.Color;

/**
 * The {@code ColorFade} class interpolates the alpha value of a {@link Color}.
 * 
 * @since Sep 22, 2016
 * @author Zeno
 * 
 * @see Interpolation
 */
public class ColorFade extends Interpolation
{	
	/**
	 * The {@code State} enum defines states of a {@code ColorFade}.
	 * 
	 * @since Sep 22, 2016
	 * @author Zeno
	 * 
	 * @see ColorFade
	 */
	public static enum State
	{
		/**
		 * The color fades out to minimum alpha.
		 */
		FADE_OUT,
		/**
		 * The color fades in to maximum alpha.
		 */
		FADE_IN,
		/**
		 * The color does not change value.
		 */
		IDLE;
	}
	
	
	private Color color;
	private State state;
	
	/**
	 * Creates a new {@code ColorFade}.
	 * 
	 * @param color  a fade color to use
	 * @param ival  a timer interval
	 * @see Color
	 */
	public ColorFade(Color color, long ival)
	{
		super(ival);

		this.color = color;
		state = State.IDLE;
	}
	
	/**
	 * Creates a new {@code ColorFade}.
	 * 
	 * @param color  a fade color to use
	 * @see Color
	 */
	public ColorFade(Color color)
	{
		this.color = color;
		state = State.IDLE;
	}
	
	/**
	 * Creates a new {@code ColorFade}.
	 * 
	 * @param ival  a timer interval
	 */
	public ColorFade(long ival)
	{
		this(Color.BLACK, ival);
	}
	
	/**
	 * Creates a new {@code ColorFade}.
	 * <br> The fade color used is black.
	 */
	public ColorFade()
	{
		this(Color.BLACK);
	}
	
	
	/**
	 * Returns the color of the {@code ColorFade}.
	 * 
	 * @return  a faded color
	 * @see Color
	 */
	public Color getColor()
	{
		float alpha = getValue();
		if(state == State.FADE_IN)
		{
			alpha = 1 - alpha;
		}
		
		float[] comps = color.RGBA();
		return new Color
		(
			comps[0],
			comps[1],
			comps[2],
			alpha
		);
	}
	
	/**
	 * Changes the color of the {@code ColorFade}.
	 * 
	 * @param color  a new color
	 * @see Color
	 */
	public void setColor(Color color)
	{
		this.color = color;
	}
	
	/**
	 * Changes the state of the {@code ColorFade}.
	 * 
	 * @param state  a new state
	 * @see State
	 */
	public void setState(State state)
	{
		this.state = state;
	}
}