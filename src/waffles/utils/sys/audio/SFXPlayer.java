package waffles.utils.sys.audio;

import javax.sound.sampled.AudioFormat;

import waffles.utils.sys.IODevice;

/**
 * An {@code SFXPlayer} handles sound playback in an {@link IODevice}.
 *
 * @author Waffles
 * @since 21 Mar 2025
 * @version 1.1
 */
public interface SFXPlayer
{
	/**
	 * Returns the audio format of the {@code SFXPlayer}.
	 * 
	 * @return  an audio format
	 * 
	 * 
	 * @see AudioFormat
	 */
	public abstract AudioFormat Format();
	
	/**
	 * Returns the chunk size of the {@code SFXPlayer}.
	 * 
	 * @return  a chunk size
	 */
	public abstract int ChunkSize();
}