package waffles.utils.sys.utilities.scripts;

import waffles.utils.geom.utilities.Dimensional;
import waffles.utils.sys.utilities.scripts.vars.ValueType;

/**
 * An {@code Allocation} defines a {@code Declarative} with a type and a label.
 * 
 * @author Waffles
 * @since 06 Jun 2025
 * @version 1.1
 * 
 * 
 * @see Dimensional
 * @see Labelled
 */
public interface Allocation extends Dimensional, Labelled
{
	/**
	 * An {@code Allocation.Base} implements a basic {@code Allocation}.
	 *
	 * @author Waffles
	 * @since 06 Jun 2025
	 * @version 1.1
	 *
	 * 
	 * @see Allocation
	 */
	public static class Base implements Allocation
	{
		private String label;
		private ValueType type;
		
		/**
		 * Creates a new {@code Allocation}.
		 * 
		 * @param t  a declaration type
		 * @param l  a declaration label
		 */
		public Base(ValueType t, String l)
		{
			label = l;
			type = t;
		}


		@Override
		public ValueType Field()
		{
			return type;
		}
		
		@Override
		public String Label()
		{
			return label;
		}
	}


	/**
	 * Returns the field type of the {@code Variable}.
	 * 
	 * @return  a field type
	 */
	public abstract ValueType Field();
		
	
	@Override
	public default int Dimension()
	{
		return Field().Dimension();
	}
}