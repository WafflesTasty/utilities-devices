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