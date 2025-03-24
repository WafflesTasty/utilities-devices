package waffles.utils.sys.input;

/**
 * The {@code IOInput} interface encapsulates input for a {@code IODevice}.
 *
 * @author Waffles
 * @since 24 Mar 2025
 * @version 1.1
 */
public interface IOInput
{
	/**
	 * Returns the keyboard of the {@code IOInput}.
	 * 
	 * @return  a keyboard
	 * 
	 * 
	 * @see IOKeyboard
	 */
	public abstract IOKeyboard Keyboard();
	
	/**
	 * Returns the mouse of the {@code IOInput}.
	 * 
	 * @return  a mouse
	 * 
	 * 
	 * @see IOMouse
	 */
	public abstract IOMouse Mouse();
}