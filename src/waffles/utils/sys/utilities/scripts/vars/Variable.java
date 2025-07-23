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
	 * A {@code Cast} defines {@code Variable} casters.
	 *
	 * @author Waffles
	 * @since 23 Jul 2025
	 * @version 1.1
	 */
	public static class Cast
	{
		private Variable var;
		
		/**
		 * Creates a new {@code Cast}.
		 * 
		 * @param v  a variable
		 * 
		 * 
		 * @see Variable
		 */
		public Cast(Variable v)
		{
			var = v;
		}
		
		/**
		 * Casts the {@code Variable} to another dimension.
		 * 
		 * @param dim  a field dimension
		 * @return  a cast string
		 */
		public String to(int dim)
		{
			return to(dim, true);
		}
				
		/**
		 * Casts the {@code Variable} to another dimension.
		 * 
		 * @param dim  a field dimension
		 * @param isAffine  an affine state
		 * @return  a cast string
		 */
		public String to(int dim, boolean isAffine)
		{
			if(var.Dimension() == dim)
				return var.Label();
			

			String src = var.Label();
			ValueType type = var.Field().cast(dim);
			if(var.Field().Type() != GFXValue.Type.MATRIX)
			{
				for(int i = var.Dimension(); i < dim; i++)
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
		 * Casts the {@code Variable} to another field type.
		 * 
		 * @param field  a field type
		 * @param isAffine  an affine state
		 * @return  a cast string
		 * 
		 * 
		 * @see ValueType
		 */
		public String to(ValueType field, boolean isAffine)
		{
			String cast = to(field.Dimension(), isAffine);
			if(field.Type() != var.Field().Type())
			{
				cast = field.declare() + "(" + cast + ")";
			}
			
			return cast;
		}

		/**
		 * Casts the {@code Variable} to another value type.
		 * 
		 * @param type  a value type
		 * @param dim   a value dimension
		 * @param isAffine  an affine state
		 * @return  a cast string
		 */
		public String to(GFXValue.Type type, int dim, boolean isAffine)
		{
			return to(new ValueType.Base(type, dim), isAffine);
		}
		
		/**
		 * Casts the {@code Variable} to another value type.
		 * 
		 * @param type  a value type
		 * @param dim   a value dimension
		 * @return  a cast string
		 */
		public String to(GFXValue.Type type, int dim)
		{
			return to(type, dim, true);
		}
		
		/**
		 * Casts the {@code Variable} to another field type.
		 * 
		 * @param field  a field type
		 * @return  a cast string
		 * 
		 * 
		 * @see ValueType
		 */
		public String to(ValueType field)
		{
			return to(field, true);
		}
	}
	
	
	/**
	 * Casts the {@code Variable} to a type.
	 * 
	 * @return  a cast object
	 * 
	 * 
	 * @see Cast
	 */
	public default Cast Cast()
	{
		return new Cast(this);
	}
	
	/**
	 * Indexes the {@code Variable} with a color.
	 * 
	 * @param index  a vector index
	 * @return  an indexed string
	 */
	public default String col(int index)
	{
		if(index < 0)
			throw new ScriptingError("An index < 0 was passed.");
		if(index > 3)
			throw new ScriptingError("An index > 3 was passed.");
		
		switch(index)
		{
		case 0:
			return Label() + ".r";
		case 1:
			return Label() + ".g";
		case 2:
			return Label() + ".b";
		case 3:
			return Label() + ".a";
		default:
			return "";
		}
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