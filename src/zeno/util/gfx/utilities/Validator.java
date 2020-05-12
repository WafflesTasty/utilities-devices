package zeno.util.gfx.utilities;

/**
 * The {@code Validator} interface checks parameter sets in the {@code GFXMemory}.
 *
 * @author Zeno
 * @since 12 May 2020
 * @version 1.0
 */
public interface Validator
{
	/**
	 * Validates a parameter set through the {@code Validator}.
	 * 
	 * @param data  a parameter set
	 * @return  {@code true} if the set is valid
	 * 
	 * 
	 * @see Object
	 */
	public abstract boolean check(Object... data);
}