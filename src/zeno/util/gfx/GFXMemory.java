package zeno.util.gfx;

import zeno.util.coll.hashed.dict.ClassMap;
import zeno.util.gfx.memory.Generator;
import zeno.util.gfx.memory.Validator;
import zeno.util.tools.patterns.manipulators.Disposable;
import zeno.util.tools.patterns.properties.Discernible;

/**
 * The {@code GFXMemory} interface handles the allocation of graphics memory.
 * 
 * @author Zeno
 * @since Sep 12, 2016
 * @version 1.0
 */
public interface GFXMemory
{		
	/**
	 * The {@code Allocator} class handles the allocation of memory objects.
	 *
	 * @author Zeno
	 * @since 12 May 2020
	 * @version 1.0
	 */
	public static class Allocator
	{
		private Validator validator;
		private Generator generator;
		
		/**
		 * Creates a new {@code Allocator}.
		 * 
		 * @param v  a memory validator
		 * @param g  a memory generator
		 * 
		 * 
		 * @see Generator
		 * @see Validator
		 */
		public Allocator(Validator v, Generator g)
		{
			validator = v;
			generator = g;
		}
		
		/**
		 * Creates a new {@code Allocator}.
		 * 
		 * @param g  a memory generator
		 * 
		 * 
		 * @see Generator
		 */
		public Allocator(Generator g)
		{
			this((data) -> true, g);
		}
		
		
		/**
		 * Returns the generator of the {@code Allocator}.
		 * 
		 * @return  a memory generator
		 * 
		 * 
		 * @see Generator
		 */
		public Generator Generator()
		{
			return generator;
		}

		/**
		 * Returns the validator of the {@code Allocator}.
		 * 
		 * @return  a memory allocator
		 * 
		 * 
		 * @see Validator
		 */
		public Validator Validator()
		{
			return validator;
		}
	}
	
	/**
	 * The {@code Data} interface defines data in the {@code GFXMemory}.
	 *
	 * @author Zeno
	 * @since 12 May 2020
	 * @version 1.0
	 * 
	 * 
	 * @see Discernible
	 * @see Disposable
	 */
	public static interface Data extends Discernible, Disposable
	{
		@Override
		public default void dispose()
		{
			// NOT APPLICABLE
		}
	}
	
	
	/**
	 * Generates a discernible data object in the {@code GFXMemory}.
	 * 
	 * @param <D>   a data memory class type
	 * @param type  a data memory class
	 * @param data  a parameter set
	 * @return  a data object
	 * 
	 * 
	 * @see Object
	 * @see Class
	 * @see Data
	 */
	public default <D extends Data> D generate(Class<D> type, Object... data)
	{
		Allocator alloc = Allocators().get(type);
		if(alloc.Validator().check(data))
		{
			return (D) alloc.Generator().create(data);
		}
		
		return null;
	}

	/**
	 * Returns the allocators in the {@code GFXMemory}.
	 * 
	 * @return  an allocator map
	 * 
	 * 
	 * @see Allocator
	 * @see ClassMap
	 */
	public abstract ClassMap<Allocator> Allocators();
}