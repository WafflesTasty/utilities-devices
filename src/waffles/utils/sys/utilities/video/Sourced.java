package waffles.utils.sys.utilities.video;

/**
 * A {@code Sourced} object defines a source {@code String}.
 *
 * @author Waffles
 * @since 18 Mar 2025
 * @version 1.1
 */
@FunctionalInterface
public interface Sourced
{
	/**
	 * Returns the source of the {@code Sourcable}.
	 * 
	 * @return  a source string
	 * 
	 * 
	 * @see String
	 */
	public abstract String Source();
}