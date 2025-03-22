package waffles.utils.sys.memory.groups;

import waffles.utils.sets.CountableSet;
import waffles.utils.sys.memory.GFXMemory;
import waffles.utils.sys.memory.buffer.GFXBuffer;

/**
 * A {@code GFXFormat} defines a data format for a {@code GFXGroup}.
 * 
 * @author Waffles
 * @since Sep 8, 2016
 * @version 1.0
 * 
 * 
 * @see CountableSet
 * @see GFXMemory
 */
public interface GFXFormat extends GFXMemory.Data, CountableSet
{
	/**
	 * Adds a data field to the {@code GFXFormat}.
	 * 
	 * @param field  a data field
	 * 
	 * 
	 * @see GFXField
	 */
	public abstract void add(GFXField<?> field);
			
	/**
	 * Changes the data buffer of the {@code GFXFormat}.
	 * 
	 * @param b  a data buffer
	 * 
	 * 
	 * @see GFXBuffer
	 */
	public abstract void setData(GFXBuffer b);
}