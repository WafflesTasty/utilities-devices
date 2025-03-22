package waffles.utils.sys.memory.buffer;

import waffles.utils.dacs.utilities.Volatile;
import waffles.utils.sys.memory.GFXMemory;
import waffles.utils.sys.memory.buffer.acs.GFXConnection;
import waffles.utils.sys.memory.buffer.hints.BufferHints;

/**
 * A {@code GFXBuffer} handles raw byte data in a buffer for the GPU.
 * A connection is established through the {@code GFXConnection} interface.
 * 
 * @author Waffles
 * @since Sep 15, 2016
 * @version 1.0
 * 
 * 
 * @see GFXMemory
 * @see GFXConnection
 * @see Volatile
 */
public interface GFXBuffer extends GFXMemory.Data, GFXConnection, Volatile
{		
	/**
	 * Returns the creation hints of the {@code GFXBuffer}.
	 * 
	 * @return  buffer hints
	 * 
	 * 
	 * @see BufferHints
	 */
	public abstract BufferHints Hints();
	
	
	@Override
	public default void clear()
	{
		Delegate().clear();
	}
}