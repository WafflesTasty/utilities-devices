package zeno.util.gfx.system.memory;

import zeno.util.gfx.system.GFXMemory;
import zeno.util.gfx.system.memory.buffers.GFXBuffer;
import zeno.util.tools.patterns.manipulators.Activator;

/**
 * The {@code GFXGroup} interface defines a vertex format group used in a {@code GFXProgram}.
 * 
 * @author Zeno
 * @since Sep 8, 2016
 * @version 1.0
 * 
 * 
 * @see GFXMemory
 * @see Activator
 */
public interface GFXGroup extends GFXMemory.Data, Activator
{		
	/**
	 * Changes the index buffer of the {@code GFXGroup}.
	 * 
	 * @param b  a target buffer
	 */
	public abstract void setIndex(GFXBuffer b);
}