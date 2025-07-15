package waffles.utils.sys.utilities.scripts.vars;

import waffles.utils.sys.memory.shaders.GFXShader.Type;
import waffles.utils.sys.utilities.scripts.Definitive;
import waffles.utils.sys.utilities.scripts.Labelled;

/**
 * A {@code Function} defines a local function in a shader program.
 *
 * @author Waffles
 * @since 11 Jun 2025
 * @version 1.1
 *
 * 
 * @see Definitive
 * @see Labelled
 */
public interface Function extends Definitive, Labelled
{
	/**
	 * Returns the body of the {@code Function}.
	 * 
	 * @param vars  input variables
	 * @return  a body string
	 * 
	 * 
	 * @see Variable
	 */
	public abstract String Body(Variable... vars);
	
	/**
	 * Returns the parameters of the {@code Function}.
	 * 
	 * @return  a parameter array
	 * 
	 * 
	 * @see Variable
	 */
	public abstract Variable[] Parameters();
	
	
	/**
	 * Returns the header of the {@code Function}.
	 * 
	 * @return  a header string
	 */
	public default String Header()
	{
		String src = "";
		for(Variable v : Parameters())
		{
			if(src.isEmpty())
				src += Return() + " " + Label() + "(";
			else
				src += ", ";

			src += "in " + v.declare();
		}
		return src + ")";
	}
	
	/**
	 * Returns a variable call of the {@code Function}.
	 * 
	 * @param vars  a variable set
	 * @return  a function call string
	 * 
	 * 
	 * @see Variable
	 */
	public default String call(Variable... vars)
	{
		String src = "";
		for(Variable v : vars)
		{
			if(!src.isEmpty())
				src += ", " + v.Label();
			else
			{
				src = Label() + "(";
				src += v.Label();
			}
		}
		src += ")";
		return src;
	}
		
	/**
	 * Returns the value type of the {@code Function}.
	 * 
	 * @return  a return type
	 * 
	 * 
	 * @see ValueType
	 */
	public default ValueType Return()
	{
		return new ValueType.Void();
	}
			
	
	@Override
	public default String define(Type type)
	{
		String src = "\r\n";
		src += Header() + "\r\n";
		src += "{" + "\r\n";
		src += Body(Parameters());
		src += "}" + "\r\n";
		src += "\r\n";
		return src;
	}
}