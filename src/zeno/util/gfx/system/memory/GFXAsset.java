package zeno.util.gfx.system.memory;

import zeno.util.algebra.linear.vector.Vector;
import zeno.util.gfx.system.GFXMemory;

/**
 * The {@code GFXAsset} interface defines a generic asset generated in {@code GFXMemory}.
 * 
 * @author Zeno
 * @since Sep 18, 2016
 * @version 1.0
 * 
 * 
 * @see GFXMemory
 */
public interface GFXAsset extends GFXMemory.Data
{	
	/**
	 * Returns the size of the {@code GFXAsset}.
	 * 
	 * @return  a size vector
	 * 
	 * 
	 * @see Vector
	 */
	public abstract Vector Size();
}