package waffles.utils.sys.utilities.errors;

/**
 * A {@code ScriptingError} is thrown during shader scripting errors.
 *
 * @author Waffles
 * @since 09 Jun 2025
 * @version 1.1
 *
 * 
 * @see RuntimeException
 */
public class ScriptingError extends RuntimeException
{
	private static final long serialVersionUID = 1867096748477719454L;
	
	
	/**
	 * Creates a new {@code ScriptingError}.
	 * 
	 * @param desc  a description text
	 */
	public ScriptingError(String desc)
	{
		super(desc);
	}
}