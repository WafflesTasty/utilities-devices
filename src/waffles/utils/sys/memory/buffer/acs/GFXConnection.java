package waffles.utils.sys.memory.buffer.acs;

import waffles.utils.dacs.db.AccessOps;
import waffles.utils.dacs.db.Connection;

/**
 * A {@code GFXConnection} manages the connection with a buffer in the GPU.
 * A connection can be established through the {@code GFXAccess} interface.
 *
 * @author Waffles
 * @since 29 Nov 2023
 * @version 1.1
 * 
 * 
 * @see Connection
 * @see GFXAccess
 */
public interface GFXConnection extends Connection<GFXAccess, Boolean>
{
	/**
	 * Opens a connection to the full {@code GFXBuffer}.
	 * 
	 * @param ops  an access operation
	 * @return {@code true} if connecting was successful
	 * 
	 * 
	 * @see AccessOps
	 */
	public default Boolean connect(AccessOps ops)
	{
		return connect(() -> ops);		
	}
}