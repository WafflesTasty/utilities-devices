package zeno.util.gfx.memory;

/**
 * The {@code Generator} interface creates data objects in the {@code GFXMemory}.
 *
 * @author Zeno
 * @since 12 May 2020
 * @version 1.0
 */
public interface Generator
{
	/**
	 * Creates a data object through the {@code Generator}.
	 * 
	 * @param data  a parameter set
	 * @return  a data object
	 * 
	 * 
	 * @see Object
	 */
	public abstract Object create(Object... data);
}