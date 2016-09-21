package zeno.util.gfx.memory.formats;

import zeno.util.gfx.memory.GFXData;
import zeno.util.tools.generic.properties.Discernible;

/**
 * The {@code GFXGlobal} class defines a global field in a {@link GFXData} object.
 * 
 * @param <O>  the type of the global
 * 
 * @since Sep 17, 2016
 * @author Zeno
 * 
 * @see Discernible
 */
public abstract class GFXGlobal<O> implements Discernible
{
	private int id;
	
	/**
	 * Creates a new {@code GFXGlobal}.
	 * 
	 * @param data  a data source
	 * @see GFXData
	 */
	public GFXGlobal(GFXData data)
	{
		id = data.generateGlobalID();
	}
	
	/**
	 * Changes the values of the {@code Global}.
	 * 
	 * @param value  a new value
	 */
	public abstract void set(O... value);

	@Override
	public int getID()
	{
		return id;
	}
}