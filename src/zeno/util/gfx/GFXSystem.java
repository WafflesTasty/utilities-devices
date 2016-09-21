package zeno.util.gfx;

/**
 * The {@code GFXSystem} interface defines the core functionality of a graphics system.
 * 
 * @since Sep 12, 2016
 * @author Zeno
 */
public interface GFXSystem
{
	/**
	 * Returns the properties of the {@code GFXSystem}.
	 * 
	 * @return  the system's properties
	 * @see GFXProperties
	 */
	public abstract GFXProperties Properties();
	
	/**
	 * Returns the memory of the {@code GFXSystem}.
	 * 
	 * @return  the system's memory
	 * @see GFXMemory
	 */
	public abstract GFXMemory Memory();
	
	/**
	 * Returns the frame of the {@code GFXSystem}.
	 * 
	 * @return  the system's frame
	 * @see GFXFrame
	 */
	public abstract GFXFrame Window();
}