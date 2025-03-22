package waffles.utils.sys.memory.buffer.acs;

import waffles.utils.dacs.db.AccessOps;

/**
 * A {@code GFXSubAccess}
 *
 * @author Waffles
 * @since 15 Mar 2025
 * @version 1.1
 *
 *
 */
public class GFXSubAccess implements GFXAccess
{
	private AccessOps acs;
	private int start, size;
	
	/**
	 * Creates a new {@code GFXSubAccess}.
	 * 
	 * @param acs    an access operation
	 * @param start  a buffer start
	 * @param size   a buffer size
	 * 
	 * 
	 * @see AccessOps
	 */
	public GFXSubAccess(AccessOps acs, int start, int size)
	{
		this.start = start;
		this.size = size;
		this.acs = acs;
	}
	
	/**
	 * Creates a new {@code GFXSubAccess}.
	 * 
	 * @param acs   an access operation
	 * @param size  a buffer size
	 * 
	 * 
	 * @see AccessOps
	 */
	public GFXSubAccess(AccessOps acs, int size)
	{
		this(acs, 0, size);
	}
	
	
	/**
	 * Returns the start of the {@code GFXSubAccess}.
	 * 
	 * @return  a buffer start
	 */
	public int Start()
	{
		return start;
	}
	
	/**
	 * Returns the size of the {@code GFXSubAccess}.
	 * 
	 * @return  a buffer size
	 */
	public int Size()
	{
		return size;
	}


	@Override
	public AccessOps Ops()
	{
		return acs;
	}

	@Override
	public Type Type()
	{
		return Type.SUBSET;
	}
}