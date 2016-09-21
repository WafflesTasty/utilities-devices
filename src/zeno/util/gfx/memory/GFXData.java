package zeno.util.gfx.memory;

import zeno.util.gfx.GFXMemory;
import zeno.util.tools.generic.manipulators.Activator;
import zeno.util.tools.generic.manipulators.Disposable;
import zeno.util.tools.generic.properties.Discernible;

/**
 * The {@code GFXData} interface defines a data object generated in {@link GFXMemory}.
 * 
 * @since Sep 8, 2016
 * @author Zeno
 * 
 * @see Discernible
 * @see Disposable
 * @see Activator
 */
public interface GFXData extends Activator, Discernible, Disposable
{	
	/**
	 * Generates a unique id for a {@code GFXGlobal}.
	 * 
	 * @return  a unique global id
	 */
	public abstract int generateGlobalID();
	
	/**
	 * Generates a unique id for a {@code GFXFormat}.
	 * 
	 * @return  a unique format id
	 */
	public abstract int generateFormatID();
	
	/**
	 * Generates a unique id for a {@code GFXField}.
	 * 
	 * @return  a unique field id
	 */
	public abstract int generateFieldID();
}