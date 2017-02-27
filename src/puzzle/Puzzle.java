package puzzle;

public class Puzzle
{
	private byte[][] initial;
	private int size;
	
	public Puzzle( int size )
	{
		this.size = size;
		this.initial = new byte[this.size][this.size];
	}
	
	public byte[][] getInitialConfiguration()
	{
		byte count = 0;
		for( int i = 0; i < size; ++i )
			for( int j = 0; j < size; ++j )
				this.initial[i][j] = ++count;
		this.initial[size - 1][size - 1] = 0;
		
		return this.initial;
	}
}