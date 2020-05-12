package zeno.util.gfx;

/**
 * The {@code GFXProperties} interface defines static properties of its respective {@link GFXSystem}.
 * 
 * @author Zeno
 * @since Sep 12, 2016
 * @version 1.0
 */
public interface GFXProperties
{
	/**
	 * Returns a driver description of the {@link GFXSystem}.
	 * 
	 * @return  a driver description
	 * 
	 * 
	 * @see String
	 */
	public abstract String DriverDescription();
}