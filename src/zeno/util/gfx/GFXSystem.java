package zeno.util.gfx;

/**
 * The {@code GFXSystem} interface defines the core functionality of a graphics system.
 * 
 * 
 * @author Zeno
 * @since Sep 12, 2016
 * @version 1.0
 */
public interface GFXSystem
{	
	/**
	 * Returns the memory of the {@code GFXSystem}.
	 * 
	 * @return  a system memory
	 * 
	 * 
	 * @see GFXMemory
	 */
	public abstract GFXMemory Memory();
	
	/**
	 * Returns the properties of the {@code GFXSystem}.
	 * 
	 * @return  system properties
	 * 
	 * 
	 * @see GFXProperties
	 */
	public abstract GFXProperties Properties();
	
	/**
	 * Returns the window of the {@code GFXSystem}.
	 * 
	 * @return  a rendering window
	 * 
	 * 
	 * @see GFXFrame
	 */
	public abstract GFXFrame Window();
}