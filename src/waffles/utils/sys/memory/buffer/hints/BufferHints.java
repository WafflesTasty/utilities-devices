package waffles.utils.sys.memory.buffer.hints;

import waffles.utils.dacs.db.AccessOps;

/**
 * The {@code BufferHints} interface defines settings for a {@code GFXBuffer}.
 *
 * @author Waffles
 * @since 12 May 2020
 * @version 1.0
 */
@FunctionalInterface
public interface BufferHints
{	
	/**
	 * Returns the buffer rate of the {@code BufferHints}.
	 * 
	 * @return  a buffer rate
	 * 
	 * 
	 * @see BufferRate
	 */
	public default BufferRate Rate()
	{
		return BufferRate.DYNAMIC;
	}
	
	/**
	 * Returns the access operation of the {@code BufferHints}.
	 * 
	 * @return  an access operation
	 * 
	 * 
	 * @see AccessOps
	 */
	public default AccessOps Ops()
	{
		return AccessOps.READ_WRITE;
	}
	
	/**
	 * Returns the byte size of the {@code BufferHints}.
	 * 
	 * @return  a byte size
	 */
	public abstract int ByteSize();
}