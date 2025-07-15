package waffles.utils.sys.utilities.scripts.vars;

import waffles.utils.sys.memory.groups.GFXValue;
import waffles.utils.sys.utilities.scripts.Definitive;

/**
 * A {@code Parameter} defines a {@code Variable} that can be used as a shader field.
 *
 * @author Waffles
 * @since 09 Jun 2025
 * @version 1.1
 *
 * 
 * @see Definitive
 * @see Variable
 */
public interface Parameter extends Definitive, Variable
{		
	/**
	 * A {@code Parameter.Base} implements a basic {@code Parameter}.
	 *
	 * @author Waffles
	 * @since 10 Jun 2025
	 * @version 1.1
	 *
	 * 
	 * @see Parameter
	 * @see Variable
	 */
	public static abstract class Base extends Variable.Base implements Parameter
	{
		/**
		 * Creates a new {@code Parameter}.
		 * 
		 * @param v  a parameter value
		 * @param l  a parameter label
		 * 
		 * 
		 * @see GFXValue
		 */
		public Base(GFXValue<?> v, String l)
		{
			super(v, l);
		}

		
		@Override
		public GFXValue<?> Field()
		{
			return (GFXValue<?>) super.Field();
		}
	}
	
	
	@Override
	public abstract GFXValue<?> Field();
}