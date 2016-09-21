package zeno.util.gfx;

import zeno.util.gfx.memory.GFXData;

/**
 * The {@code GFXProperties} interface defines static properties of its respective {@link GFXSystem}.
 * 
 * @since Sep 12, 2016
 * @author Zeno
 */
public interface GFXProperties
{
	/**
	 * Returns the maximum global fields in one {@link GFXData} object.
	 * 
	 * @return  the maximum global field count
	 */
	public abstract int getMaximumGlobalFields();
	
	/**
	 * Returns the maximum data formats in one {@link GFXData} object.
	 * 
	 * @return  the maximum data format count
	 */
	public abstract int getMaximumDataFormats();
	
	/**
	 * Returns the maximum data fields in one {@link GFXData} object.
	 * 
	 * @return  the maximum data field count
	 */
	public abstract int getMaximumDataFields();
	
	/**
	 * Returns the driver description of the {@link GFXSystem}.
	 * 
	 * @return  a system driver description
	 * @see String
	 */
	public abstract String getDriver();

	/**
	 * Returns the last error thrown by the {@link GFXSystem}.
	 * 
	 * @return  an error message
	 * @see String
	 */
	public abstract String getError();
}