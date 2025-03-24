package waffles.utils.sys.input;

import waffles.utils.sys.input.keyboard.KeyCode;

/**
 * An {@code IOKeyboard} handles keyboard input for an {@code IODevice}.
 *
 * @author Waffles
 * @since 24 Mar 2025
 * @version 1.1
 */
public interface IOKeyboard
{
	/**
	 * An {@code Event} is raised by input from an {@code IOKeyboard}.
	 *
	 * @author Waffles
	 * @since Oct 26, 2015
	 * @version 1.0
	 */
	public static class Event
	{
		private char value;
		private KeyCode code;
		
		/**
		 * Creates a new {@code Event}.
		 * 
		 * @param c  a character
		 */
		public Event(char c)
		{
			value = c;
		}

		/**
		 * Creates a new {@code Event}.
		 * 
		 * @param c  a key code
		 * 
		 * 
		 * @see KeyCode
		 */
		public Event(KeyCode c)
		{
			code = c;
		}
		
		
		/**
		 * Returns the character of the {@code Event}.
		 * 
		 * @return  the event's character
		 */
		public char Character()
		{
			return value;
		}
		
		/**
		 * Returns the key code of the {@code Event}.
		 * 
		 * @return  the event's key code
		 */
		public KeyCode KeyCode()
		{
			return code;
		}
	}
	
	
	/**
	 * An event raised when a key is pressed.
	 * 
	 * @param c  a key code
	 * 
	 * 
	 * @see KeyCode
	 */
	public abstract void press(KeyCode c);
	
	/**
	 * An event raised when a key is released.
	 * 
	 * @param c  a key code
	 * 
	 * 
	 * @see KeyCode
	 */
	public abstract void release(KeyCode c);
	
	/**
	 * An event raised when a  key is typed.
	 * 
	 * @param c  a key char
	 */
	public abstract void type(char c);
}