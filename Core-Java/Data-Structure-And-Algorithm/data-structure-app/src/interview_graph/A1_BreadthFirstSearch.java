package interview_graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class A1_BreadthFirstSearch {
	public static void main(String[] args) {
		
		Graph1 graph = new Graph1(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		graph.BFS(2);
		graph.display();
	}
	
	
}

class Graph1 {
	private int V;
	private LinkedList<Integer> adj[];
	
	Graph1(int v)	{
		V = v;
		adj = new LinkedList[v];
		
		for(int i = 0; i < v; i++)	{
			adj[i] = new LinkedList<>();
		}
	}
	
	void addEdge(int vertex, int w)	{
		adj[vertex].add(w);
	}
	
	void display() {
		Arrays.stream(adj).forEach(a -> System.out.print(a + " "));
	}
	
	void BFS(int s)	{
		boolean visited[] = new boolean[V];
		
		LinkedList<Integer> queue = new LinkedList<>();
		
		visited[s] = true;
		queue.add(s);
		
		while(queue.size() != 0)	{
			s = queue.poll();
			System.out.println(s + " ");
			
			Iterator<Integer> i = adj[s].listIterator();
			while(i.hasNext())	{
				int n = i.next();
				if(!visited[n])	{
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
}
