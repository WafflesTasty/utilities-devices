package waffles.utils.sys.memory.groups;

import waffles.utils.geom.utilities.Dimensional;
import waffles.utils.sys.memory.GFXMemory;

/**
 * A {@code GFXGlobal} defines a global data field for a {@code GFXGroup}.
 * 
 * @author Waffles
 * @since Sep 17, 2016
 * @version 1.0
 * 
 * 
 * @param <O>  a data type
 * @see Dimensional
 * @see GFXMemory
 */
public interface GFXGlobal<O> extends GFXMemory.Data, Dimensional
{
	/**
	 * Changes the value of the {@code GFXGlobal}.
	 * 
	 * @param value  a value array
	 */
	public abstract void set(O... value);
}