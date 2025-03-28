package waffles.utils.sys.input;

import waffles.utils.sys.input.mouse.MouseButton;
import waffles.utils.sys.video.graphics.GFXCursor;

/**
 * An {@code IOMouse} handles mouse input for an {@code IODevice}.
 *
 * @author Waffles
 * @since 24 Mar 2025
 * @version 1.1
 */
public interface IOMouse
{
	/**
	 * An {@code Event} is raised by input from an {@code IOMouse}.
	 *
	 * @author Waffles
	 * @since Oct 26, 2015
	 * @version 1.0
	 */
	public static class EventOld
	{
		private float x, y, value;
		private MouseButton button;
		
				
		/**
		 * Creates a new {@code Event}.
		 * 
		 * @param x    an x-coordinate
		 * @param y    an y-coordinate
		 * @param btn  a mouse button
		 * 
		 * 
		 * @see MouseButton
		 */
		public EventOld(float x, float y, MouseButton btn)
		{
			this(x, y);	button = btn;
		}

		/**
		 * Creates a new {@code Event}.
		 * 
		 * @param x    an x-coordinate
		 * @param y    an y-coordinate
		 * @param val  a scroll value
		 */
		public EventOld(float x, float y, float val)
		{
			this(x, y); value = val;
		}
		
		/**
		 * Creates a new {@code Event}.
		 * 
		 * @param x    an x-coordinate
		 * @param y    an y-coordinate
		 */
		public EventOld(float x, float y)
		{
			this.x = x;
			this.y = y;
		}
		
		
		/**
		 * Returns the button of the {@code Event}.
		 * 
		 * @return  a mouse button
		 * 
		 * 
		 * @see MouseButton
		 */
		public MouseButton Button()
		{
			return button;
		}
		
		/**
		 * Returns the value of the {@code Event}.
		 * 
		 * @return  a scroll value
		 */
		public float Value()
		{
			return value;
		}
		
		/**
		 * Returns the x-coordinate of the {@code Event}.
		 * 
		 * @return  an x-coordinate
		 */
		public float X()
		{
			return x;
		}
		
		/**
		 * Returns the y-coordinate of the {@code Event}.
		 * 
		 * @return  an y-coordinate
		 */
		public float Y()
		{
			return y;
		}
	}

	
	/**
	 * Changes the cursor of the mouse.
	 * 
	 * @param c  a mouse cursor
	 * 
	 * 
	 * @see GFXCursor
	 */
	public abstract void set(GFXCursor c);
	
	/**
	 * An event raised when the mouse is scrolled.
	 * 
	 * @param x    an x-coordinate
	 * @param y    an y-coordinate
	 * @param val  a scroll value
	 */
	public abstract void scroll(float x, float y, float val);
	
	/**
	 * An event raised when the mouse is released.
	 * 
	 * @param x     an x-coordinate
	 * @param y     an y-coordinate
	 * @param btn   a mouse button
	 * 
	 * 
	 * @see MouseButton
	 */
	public abstract void release(float x, float y, MouseButton btn);
		
	/**
	 * An event raised when the mouse is pressed.
	 * 
	 * @param x     an x-coordinate
	 * @param y     an y-coordinate
	 * @param btn   a mouse button
	 * 
	 * 
	 * @see MouseButton
	 */
	public abstract void press(float x, float y, MouseButton btn);
	
	/**
	 * An event raised when the mouse is moved.
	 * 
	 * @param x     an x-coordinate
	 * @param y     an y-coordinate
	 */
	public abstract void move(float x, float y);
}