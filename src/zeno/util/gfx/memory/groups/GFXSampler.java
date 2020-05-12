package zeno.util.gfx.memory.groups;

import zeno.util.gfx.GFXMemory;
import zeno.util.gfx.memory.data.GFXAsset;

/**
 * The {@code GFXSampler} interface defines a sampler in a {@code GFXGroup}.
 *
 * @author Zeno
 * @since 12 May 2020
 * @version 1.0 
 * 
 * 
 * @see GFXMemory
 */
public interface GFXSampler extends GFXMemory.Data
{
	/**
	 * Changes the value of the {@code GFXSampler}.
	 * 
	 * @param asset  a target asset
	 * 
	 * 
	 * @see GFXAsset
	 */
	public abstract void set(GFXAsset asset);
}