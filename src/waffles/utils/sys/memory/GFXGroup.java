package waffles.utils.sys.memory;

import waffles.utils.sys.memory.buffer.GFXBuffer;
import waffles.utils.tools.patterns.semantics.Activator;

/**
 * A {@code GFXGroup} defines a vertex format group for a {@code GFXProgram}.
 * 
 * @author Waffles
 * @since Sep 8, 2016
 * @version 1.0
 * 
 * 
 * @see Activator
 * @see GFXMemory
 */
public interface GFXGroup extends GFXMemory.Data, Activator
{		
	/**
	 * Changes the index buffer of the {@code GFXGroup}.
	 * 
	 * @param b  an index buffer
	 * 
	 * 
	 * @see GFXBuffer
	 */
	public abstract void setIndex(GFXBuffer b);
}