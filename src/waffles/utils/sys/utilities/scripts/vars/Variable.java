package waffles.utils.sys.utilities.scripts.vars;

import waffles.utils.sys.memory.groups.GFXValue;
import waffles.utils.sys.memory.shaders.GFXShader.Type;
import waffles.utils.sys.utilities.errors.ScriptingError;
import waffles.utils.sys.utilities.scripts.Allocation;
import waffles.utils.sys.utilities.scripts.Declarative;
import waffles.utils.sys.utilities.scripts.Definitive;

/**
 * A {@code Variable} defines a {@code Declarative} representing a field.
 * 
 * @author Waffles
 * @since 06 Jun 2025
 * @version 1.1
 * 
 * 
 * @see Declarative
 * @see Allocation
 */
public interface Variable extends Allocation, Declarative
{
	/**
	 * A {@code Variable.Base} implements a basic {@code Variable}.
	 *
	 * @author Waffles
	 * @since 10 Jun 2025
	 * @version 1.1
	 *
	 * 
	 * @see Allocation
	 * @see Variable
	 */
	public static class Base extends Allocation.Base implements Variable
	{
		/**
		 * Creates a new {@code Variable}.
		 * 
		 * @param t  a variable type
		 * @param d  a variable dimension
		 * @param l  a variable label
		 * 
		 * 
		 * @see GFXValue
		 */
		public Base(GFXValue.Type t, int d, String l)
		{
			this(new ValueType.Base(t, d), l);
		}
		
		/**
		 * Creates a new {@code Variable}.
		 * 
		 * @param t  a variable type
		 * @param l  a variable label
		 * 
		 * 
		 * @see ValueType
		 */
		public Base(ValueType t, String l)
		{
			super(t, l);
		}
	}
	
	/**
	 * A {@code Binding} defines a {@code Variable} that can
	 * be bound to the input and output of shader stages.
	 *
	 * @author Waffles
	 * @since 10 Jun 2025
	 * @version 1.1
	 *
	 * 
	 * @see Definitive
	 * @see Variable
	 */
	public static class Binding extends Base implements Definitive
	{
		private int index;
		
		/**
		 * Creates a new {@code Binding}.
		 * 
		 * @param v  a binding value
		 * @param l  a binding label
		 * @param i  a binding index
		 * 
		 * 
		 * @see ValueType
		 */
		public Binding(ValueType v, String l, int i)
		{
			super(v, l);
			index = i;
		}
		
		/**
		 * Returns the index of the {@code Binding}.
		 * 
		 * @return  a binding index
		 */
		public int Index()
		{
			return index;
		}

		
		@Override
		public String define(Type type)
		{
			return "layout(location = " + Index() + ")";
		}
	}
	
	
	/**
	 * Casts the {@code Variable} to another dimension.
	 * 
	 * @param dim  a field dimension
	 * @return  a cast string
	 */
	public default String cast(int dim)
	{
		return cast(dim, true);
	}
	
	/**
	 * Casts the {@code Variable} to another dimension.
	 * 
	 * @param dim  a field dimension
	 * @param isAffine  an affine state
	 * @return  a cast string
	 */
	public default String cast(int dim, boolean isAffine)
	{
		if(Dimension() == dim)
			return Label();
		

		String src = Label();
		ValueType type = Field().cast(dim);
		if(Field().Type() != GFXValue.Type.MATRIX)
		{
			for(int i = Dimension(); i < dim; i++)
			{
				if(i == 3 && isAffine)
					src += ", 1.0";
				else
					src += ", 0.0";
			}
		}
		
		return type + "(" + src + ")";
	}
	
	/**
	 * Indexes the {@code Variable} with a letter.
	 * 
	 * @param index  a vector index
	 * @return  an indexed string
	 */
	public default String get(int index)
	{
		if(index < 0)
			throw new ScriptingError("An index < 0 was passed.");
		if(index > 3)
			throw new ScriptingError("An index > 3 was passed.");
		
		switch(index)
		{
		case 0:
			return Label() + ".x";
		case 1:
			return Label() + ".y";
		case 2:
			return Label() + ".z";
		case 3:
			return Label() + ".w";
		default:
			return "";
		}
	}
	
	
	@Override
	public default String declare()
	{
		return Field() + " " + Label();
	}
}