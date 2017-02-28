package puzzle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Searches
{
	public static void BFS( HashMap<Node, HashMap<Node, Byte>> tree, Node root, Node goal )
	{
		System.out.println( "BFS" );
		ArrayList<Node> queue = new ArrayList<>();

		queue.add( root );
		while( !queue.isEmpty() )
		{
			Node node = queue.remove( 0 );
			System.out.println( node );
			if( node.toString().equals( goal.toString() ) )
				break;
			if( tree.containsKey( node ) )
				for( Node children: tree.get( node ).keySet() )
					queue.add( children );
		}
		System.out.println();
	}
	
	public static void DFS( HashMap<Node, HashMap<Node, Byte>> tree, Node root, Node goal )
	{
		System.out.println( "DFS" );
		ArrayList<Node> stack = new ArrayList<>();

		stack.add( root );
		while( !stack.isEmpty() )
		{
			Node node = stack.remove( stack.size() - 1 );
			System.out.println( node );
			if( node.toString().equals( goal.toString() ) )
				break;
			if( tree.containsKey( node ) )
				for( Node children: tree.get( node ).keySet() )
					stack.add( children );
		}
		System.out.println();
	}
	
	public static void DFSIterative( HashMap<Node, HashMap<Node, Byte>> tree, HashMap<Node, Integer> depths, Node root, Node goal )
	{
		System.out.println( "DFS Iterative" );
		ArrayList<Node> stack = new ArrayList<>();

		for( int i = 0; i < 11; ++i )
		{
			System.out.println( "Limit " + i );
			stack.add( root );
			while( !stack.isEmpty() )
			{
				Node node = stack.remove( stack.size() - 1 );
				if( depths.get( node ) == i + 1 )
					continue;
				else if( depths.get( node ) == i + 2 )
					continue;
				System.out.println( node );
				if( node.toString().equals( goal.toString() ) )
					break;
				if( tree.containsKey( node ) )
					for( Node children: tree.get( node ).keySet() )
						stack.add( children );
			}
			System.out.println();
		}
	}

	public static void ManhattanHeuristic( HashMap<Node, HashMap<Node, Byte>> tree, Node root, Node goal )
	{
		System.out.println( "Manhattan heuristic" );
		PriorityQueue<Node> queue = new PriorityQueue<>( tree.keySet().size(), new Comparator<Node>()
		{
			public int compare( Node node1, Node node2 )
			{
				if( node1.getWeight() < node2.getWeight() )
					return -1;
				if( node1.getWeight() > node2.getWeight() )
					return 1;
				return 0;
		    }
		} );

		queue.add( root );
		while( !queue.isEmpty() )
		{
			Node node = queue.poll();
			System.out.println( node );
			if( node.toString().equals( goal.toString() ) )
				break;
			if( tree.containsKey( node ) )
				for( Node children: tree.get( node ).keySet() )
					queue.add( children );
		}
		System.out.println();
	}
}