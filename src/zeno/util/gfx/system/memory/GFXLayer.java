package zeno.util.gfx.system.memory;

import zeno.util.gfx.system.GFXMemory;
import zeno.util.tools.patterns.manipulators.Activator;
import zeno.util.tools.patterns.manipulators.Loadable;

/**
 * The {@code GFXLayer} interface defines a window layer to draw into.
 *
 * @author Zeno
 * @since 20 Jan 2021
 * @version 1.0
 * 
 * 
 * @see GFXMemory
 * @see Activator
 * @see Loadable
 */
public interface GFXLayer extends GFXMemory.Data, Activator, Loadable
{			
	/**
	 * Attaches a renderable asset into in the {@code GFXLayer}.
	 * 
	 * @param asset  a target asset
	 * @param index  a target index
	 * 
	 * 
	 * @see GFXAsset
	 */
	public abstract void attach(GFXAsset asset, int index);
	
	/**
	 * Changes the active target of the {@code GFXLayer}.
	 * 
	 * @param index  a target index
	 */
	public abstract void setTarget(int index);
	
	/**
	 * Clears the {@code GFXLayer}.
	 */
	public abstract void clear();
}