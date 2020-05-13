package zeno.util.gfx.system.memory.groups;

import zeno.util.gfx.system.GFXMemory;
import zeno.util.gfx.system.memory.buffers.GFXBuffer;

/**
 * The {@code GFXFormat} interface defines a data format for a {@code GFXBuffer}.
 * 
 * @author Zeno
 * @since Sep 8, 2016
 * @version 1.0
 * 
 * 
 * @see GFXMemory
 */
public interface GFXFormat extends GFXMemory.Data
{
	/**
	 * Adds a data field to the {@code GFXFormat}.
	 * 
	 * @param field  a data field
	 * 
	 * 
	 * @see GFXField
	 */
	public abstract void add(GFXField field);
	
	/**
	 * Changes the data buffer of the {@code GFXFormat}.
	 * 
	 * @param buffer  a data buffer
	 * 
	 * 
	 * @see GFXBuffer
	 */
	public abstract void setBuffer(GFXBuffer buffer);
	
	/**
	 * Returns the size of the {@code GFXFormat}.
	 * 
	 * @return  a byte size
	 */
	public abstract int ByteSize();
}