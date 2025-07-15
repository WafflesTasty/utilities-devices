package waffles.utils.sys.utilities.scripts;

import waffles.utils.sys.memory.shaders.GFXShader.Type;

/**
 * A {@code Definitive} object can define itself in a string.
 *
 * @author Waffles
 * @since 09 Jun 2025
 * @version 1.1
 */
@FunctionalInterface
public interface Definitive
{
	/**
	 * Returns a string for the {@code Definitive}.
	 * 
	 * @param type  a shader type
	 * @return  a definition string
	 * 
	 * 
	 * @see Type
	 */
	public abstract String define(Type type);
}