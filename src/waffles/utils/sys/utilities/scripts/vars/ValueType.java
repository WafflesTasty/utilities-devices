package waffles.utils.sys.utilities.scripts.vars;

import waffles.utils.geom.utilities.Dimensional;
import waffles.utils.sys.memory.groups.GFXValue;
import waffles.utils.sys.memory.groups.GFXValue.Type;
import waffles.utils.sys.utilities.errors.ScriptingError;
import waffles.utils.sys.utilities.scripts.Declarative;

/**
 * A {@code ValueType} declares field types for {@code Shader} scripting.
 *
 * @author Waffles
 * @since 09 Jun 2025
 * @version 1.1
 *
 * 
 * @see Declarative
 * @see Dimensional
 */
public interface ValueType extends Declarative, Dimensional
{
	/**
	 * A {@code ValueType.Base} implements a {@code ValueType}.
	 *
	 * @author Waffles
	 * @since 09 Jun 2025
	 * @version 1.1
	 *
	 * 
	 * @see ValueType
	 */
	public static class Base implements ValueType
	{
		private int dim;
		private Type type;
		
		/**
		 * Creates a new {@code DataType}.
		 * 
		 * @param t  a field type
		 * @param d  a field dimension
		 */
		public Base(Type t, int d)
		{
			type = t;
			dim = d;
		}

				
		@Override
		public String toString()
		{
			return declare();
		}
		
		@Override
		public int Dimension()
		{
			return dim;
		}
		
		@Override
		public Type Type()
		{
			return type;
		}
	}
	
	/**
	 * A {@code ValueType.Void} serves as a void type.
	 *
	 * @author Waffles
	 * @since 11 Jun 2025
	 * @version 1.1
	 *
	 * 
	 * @see Base
	 */
	public static class Void extends Base
	{
		/**
		 * Creates a new {@code Void}.
		 */
		public Void()
		{
			super(Type.INTEGER, 0);
		}
		
		
		@Override
		public String declare()
		{
			return "void";
		}
	}


	/**
	 * Returns the type of the {@code ValueType}.
	 * 
	 * @return  a field type
	 * 
	 * 
	 * @see Type
	 */
	public abstract GFXValue.Type Type();
	
	/**
	 * Casts the dimension of the {@code ValueType}.
	 * 
	 * @param dim  a field dimension
	 * @return  a value type
	 */
	public default ValueType cast(int dim)
	{
		return new Base(Type(), dim);
	}
	

	@Override
	public default String declare()
	{
		if(Dimension() < 1)
			throw new ScriptingError("A data type has dimension < 1.");
		if(Dimension() > 4)
			throw new ScriptingError("A data type has dimension > 4.");
		
		if(Dimension() == 1)
		{
			switch(Type())
			{
			case FLOAT:
			case MATRIX:
				return "float";
			case DOUBLE:
				return "double";
			case INTEGER:
				return "int";
			default:
				break;
			}
		}
		
		switch(Type())
		{
		case FLOAT:
			return "vec"  + Dimension();
		case MATRIX:
			return "mat"  + Dimension();
		case DOUBLE:
			return "dvec" + Dimension();	
		case INTEGER:
			return "ivec" + Dimension();
		case SAMPLER:
		{
			switch(Dimension())
			{
			case 1:
				return "sampler1D";
			case 2:
				return "sampler2D";
			case 3:
				return "samplerCube";
			default:
				break;
			}
		}
		default:
			return "";
		}
	}
}