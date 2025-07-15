package waffles.utils.sys.utilities.scripts;

/**
 * A {@code Declarative} object can declare itself in a string.
 *
 * @author Waffles
 * @since 09 Jun 2025
 * @version 1.1
 */
@FunctionalInterface
public interface Declarative
{
	/**
	 * Returns a string for the {@code Declarative}.
	 * 
	 * @return  a declarative string
	 */
	public abstract String declare();
}