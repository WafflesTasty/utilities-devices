package waffles.utils.sys.utilities.video;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector2;

/**
 * A {@code VideoMode} defines a {@code GFXWindow} configuration.
 *
 * @author Waffles
 * @since Dec 19, 2015
 * @version 1.0
 */
public class VideoMode
{
	private Vector2 size;
	private int depth, refresh;
	private boolean isFullScreen;

	
	/**
	 * Changes the full screen of the {@code VideoMode}.
	 * 
	 * @param mode  a full screen mode
	 */
	public void setFullScreen(boolean mode)
	{
		isFullScreen = mode;
	}
	
	/**
	 * Changes the refresh rate of the {@code VideoMode}.
	 * 
	 * @param rate  a refresh rate
	 */
	public void setRefreshRate(int rate)
	{
		refresh = rate;
	}
	
	/**
	 * Changes the window size of the {@code VideoMode}.
	 * 
	 * @param w  a window width
	 * @param h  a window height
	 */
	public void setSize(int w, int h)
	{
		setSize(new Vector2(w, h));
	}
	
	/**
	 * Changes the window size of the {@code VideoMode}.
	 * 
	 * @param size  a window size
	 * 
	 * 
	 * @see Vector2
	 */
	public void setSize(Vector2 size)
	{
		this.size = size;
	}
	
	/**
	 * Changes the bit depth of the {@code VideoMode}.
	 * 
	 * @param depth  a bit depth
	 */
	public void setBitDepth(int depth)
	{
		this.depth = depth;
	}
		
		
	/**
	 * Returns the full screen of the {@code VideoMode}.
	 * 
	 * @return  a full screen mode
	 */
	public boolean isFullScreen()
	{
		return isFullScreen;
	}
		
	/**
	 * Returns the refresh rate of the {@code VideoMode}.
	 * 
	 * @return  a refresh rate
	 */
	public int RefreshRate()
	{
		return refresh;
	}

	/**
	 * Returns the bit depth of the {@code VideoMode}.
	 * 
	 * @return  a bit depth
	 */
	public int BitDepth()
	{
		return depth;
	}
	
	/**
	 * Returns the height of the {@code VideoMode}.
	 * 
	 * @return  a window height
	 */
	public int Height()
	{
		return (int) size.Y();
	}
	
	/**
	 * Returns the width of the {@code VideoMode}.
	 * 
	 * @return  a window width
	 */
	public int Width()
	{
		return (int) size.X();
	}
}