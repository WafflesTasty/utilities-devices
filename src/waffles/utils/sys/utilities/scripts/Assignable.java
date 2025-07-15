package waffles.utils.sys.utilities.scripts;

import waffles.utils.sys.memory.shaders.GFXShader.Type;

/**
 * An {@code Assignable} object constructs assignment strings.
 *
 * @author Waffles
 * @since 10 Jun 2025
 * @version 1.1
 */
@FunctionalInterface
public interface Assignable
{
	/**
	 * Constructs an assignment from the {@code Assignable}.
	 * 
	 * @param type  a shader type
	 * @return  an assignment string
	 */
	public abstract String assign(Type type);
}