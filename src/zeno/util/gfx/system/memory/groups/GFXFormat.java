package zeno.util.gfx.system.memory.groups;

import zeno.util.gfx.system.GFXMemory;
import zeno.util.gfx.system.memory.data.GFXBuffer;

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
	 * Changes the data buffer of the {@code GFXFormat}.
	 * 
	 * @param buffer  a data buffer
	 * 
	 * 
	 * @see GFXBuffer
	 */
	public abstract void setBuffer(GFXBuffer buffer);
	
	/**
	 * Adds a data field to the {@code GFXFormat}.
	 * 
	 * @param field  a data field
	 * 
	 * 
	 * @see GFXField
	 */
	public abstract void addField(GFXField field);
}