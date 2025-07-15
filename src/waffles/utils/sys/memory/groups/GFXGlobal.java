package waffles.utils.sys.memory.groups;

import waffles.utils.tools.patterns.semantics.Countable;

/**
 * A {@code GFXGlobal} defines a global data field for a {@code GFXGroup}.
 * 
 * @author Waffles
 * @since Sep 17, 2016
 * @version 1.0
 * 
 * 
 * @param <O>  a data type
 * @see Countable
 * @see GFXValue
 */
public interface GFXGlobal<O> extends GFXValue<O>, Countable
{	
	/**
	 * Changes the value of the {@code GFXGlobal}.
	 * 
	 * @param i  an array index
	 * @param value  a value array
	 */
	public abstract void set(long i, O... value);
	

	@Override
	public default void set(O... value)
	{
		set(0, value);
	}
}