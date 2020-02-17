package zeno.util.gfx.memory.formats;

import zeno.util.gfx.memory.GFXData;
import zeno.util.tools.patterns.properties.Discernible;

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
	private GFXData parent;
	
	/**
	 * Creates a new {@code GFXGlobal}.
	 * 
	 * @param data  a data source
	 * @see GFXData
	 */
	public GFXGlobal(GFXData data)
	{
		id = data.generateGlobalID();
		parent = data;
	}
	
	/**
	 * Returns the parent of the {@code GFXGlobal}.
	 * 
	 * @return  a parent data
	 * 
	 * 
	 * @see GFXData
	 */
	public GFXData Parent()
	{
		return parent;
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