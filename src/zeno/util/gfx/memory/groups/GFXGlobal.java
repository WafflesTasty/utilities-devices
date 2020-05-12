package zeno.util.gfx.memory.groups;

import zeno.util.gfx.GFXMemory;

/**
 * The {@code GFXGlobal} interface defines a global field in a {@code GFXGroup}.
 * 
 * @author Zeno
 * @since Sep 17, 2016
 * @version 1.0
 * 
 * 
 * @param <O>  a data type
 * @see GFXMemory
 */
public interface GFXGlobal<O> extends GFXMemory.Data
{
	/**
	 * Changes the value of the {@code GFXGlobal}.
	 * 
	 * @param value  a data value
	 */
	public abstract void set(O... value);
}