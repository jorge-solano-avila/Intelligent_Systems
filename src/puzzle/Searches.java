package puzzle;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Searches
{
	public static void ManhattanHeuristic( HashMap<Node, HashMap<Node, Byte>> tree, Node root )
	{
		PriorityQueue<Node> queue = new PriorityQueue<>( 2 * tree.keySet().size(), new Comparator<Node>()
		{
			public int compare( Node node1, Node node2 )
			{
				if( node1.getWeight() > node2.getWeight() )
					return -1;
				if( node1.getWeight() < node2.getWeight() )
					return 1;
				return 0;
		    }
		} );

		queue.add( root );
		while( !queue.isEmpty() )
		{
			//System.out.println( queue );
			Node node = queue.poll();
			System.out.println( node );
			if( tree.containsKey( node ) )
				for( Node children: tree.get( node ).keySet() )
					queue.add( children );
		}
	}
}