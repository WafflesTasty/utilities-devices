package waffles.utils.sys;

import waffles.utils.sys.audio.SFXPlayer;
import waffles.utils.sys.input.IOInput;
import waffles.utils.sys.memory.GFXMemory;
import waffles.utils.sys.network.IONetwork;
import waffles.utils.sys.video.GFXWindow;

/**
 * The {@code IODevice} interface encapsulates all peripherals of a user device.
 *
 * @author Waffles
 * @since 12 Mar 2025
 * @version 1.0
 */
public interface IODevice
{
	/**
	 * Returns the audio of the {@code IODevice}.
	 * 
	 * @return  a system audio
	 * 
	 * 
	 * @see SFXPlayer
	 */
	public abstract SFXPlayer Audio();
	
	/**
	 * Returns the memory of the {@code IODevice}.
	 * 
	 * @return  a system memory
	 * 
	 * 
	 * @see GFXMemory
	 */
	public abstract GFXMemory Memory();
	
	/**
	 * Returns the network of the {@code IODevice}.
	 * 
	 * @return  a system network
	 * 
	 * 
	 * @see IONetwork
	 */
	public abstract IONetwork Network();
	
	/**
	 * Returns the window of the {@code IODevice}.
	 * 
	 * @return  a rendering window
	 * 
	 * 
	 * @see GFXWindow
	 */
	public abstract GFXWindow Window();
	
	/**
	 * Returns the input of the {@code IODevice}.
	 * 
	 * @return  an input handler
	 * 
	 * 
	 * @see IOInput
	 */
	public abstract IOInput Input();
	
	
	/**
	 * An event raised to check if the {@code IODevice} is valid.
	 * 
	 * @return  {@code true} if the device is valid
	 */
	public default boolean onValidate()
	{
		return true;
	}
}