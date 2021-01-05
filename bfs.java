import java.util.*;

class Gbfs 
{
	int V;
	int A[][];
	Gbfs(int v)
	{
		Scanner sc = new Scanner(System.in);
		V = v;
		A = new int[v][v];
		System.out.println("Enter the graph in the form of adjacency matrix :");
		for(int i = 0; i < v; i++)
		{
			for(int j = 0; j < v; j++)
			{
				A[i][j] = sc.nextInt();
			}
		}
	}
	
	void BFS(int vstart)
	{
		int x;
		int status[] = new int[V];
		for(int i = 0; i < V; i++)
		{
			status[i] = 0; // 0 = unvisited
		}
		LinkedList<Integer> Queue = new LinkedList<Integer>();
		Queue.add(vstart); //ENQUE
		status[vstart] = 1; //1 = visited
		while(Queue.size() != 0)
		{
			x = Queue.poll(); //DELQUE
			for(int i = 0; i < V; i++)
			{
				if(status[i] == 0)
				{
					if(A[x][i] == 1)
					{
						System.out.println(x+","+i);
						status[i] = 1;
						Queue.add(i);
					}
				}
			}
			status[x] = 2; // 2 = explored
		}
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no. of vertices in the graph :");
		int ver = sc.nextInt();
		Gbfs ob = new Gbfs(ver);
		System.out.println("Enter the source vertex :");
		int source = sc.nextInt();
		System.out.println("Breadth First Traversal :");
		ob.BFS(source);
	}
}