package waffles.utils.sys.memory.buffer.hints;

/**
 * The {@code BufferRate} enum defines rate hints for a {@code GFXBuffer}.
 * 
 * @author Waffles
 * @since Sep 15, 2016
 * @version 1.0
 */
public enum BufferRate
{
	/**
	 * The buffer is only updated once.
	 */
	STATIC,
	/**
	 * The buffer is updated occasionally.
	 */
	DYNAMIC,
	/**
	 * The buffer is constantly updated.
	 */
	STREAM;
}