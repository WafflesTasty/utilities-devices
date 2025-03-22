package waffles.utils.sys.memory.buffer.acs;

import waffles.utils.dacs.db.AccessOps;

/**
 * A {@code GFXAccess} defines the access parameters for a {@code GFXBuffer}.
 *
 * @author Waffles
 * @since 15 Mar 2025
 * @version 1.1
 */
@FunctionalInterface
public interface GFXAccess
{
	/**
	 * Creates a new {@code GFXAccess} for a subset of a {@code GFXBuffer}.
	 * 
	 * @param acs    an access operation
	 * @param start  a buffer start
	 * @param size   a buffer size
	 * @return  a buffer access
	 * 
	 * 
	 * @see GFXAccess
	 */
	public static GFXAccess create(AccessOps acs, int start, int size)
	{
		return new GFXSubAccess(acs, start, size);
	}

	/**
	 * A {@code GFXAccess.Type} defines the type of {@code GFXAccess}.
	 *
	 * @author Waffles
	 * @since 15 Mar 2025
	 * @version 1.1
	 */
	public static enum Type
	{
		/**
		 * Access to a buffer subset.
		 */
		SUBSET,
		/**
		 * Access to a full buffer.
		 */
		FULL;
	}
	

	/**
	 * Returns the operation of the {@code GFXAccess}.
	 * 
	 * @return  an access operation
	 * 
	 * 
	 * @see AccessOps
	 */
	public abstract AccessOps Ops();

	/**
	 * Returns the type of the {@code GFXAccess}.
	 * 
	 * @return  an access type
	 * 
	 * 
	 * @see Type
	 */
	public default Type Type()
	{
		return Type.FULL;
	}
}
