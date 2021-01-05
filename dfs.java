import java.util.*;

class Gdfs 
{
	int V;
	int A[][];
	Gdfs(int v)
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
	
	void DFS(int vstart)
	{
		int sum = 0;
		int vertex;
		boolean Found;
		int status[] = new int[V];
		for(int i = 0; i < V; i++)
		{
			status[i] = 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		status[vstart] = 1;
		sum++;
		vertex = vstart;
		while(sum != V)
		{
			Found = false;
			for(int i = 0; i < V; i++)
			{
				if(status[i] == 0)
				{
					if(A[vertex][i] == 1)
					{
						Found = true;
						System.out.println(vertex+","+i);
						status[i] = 1;
						sum++;
						stack.push(vertex);
						vertex = i;
						break;
					}
				}
			}
			if(Found == false)
				vertex = stack.pop();
		}
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no. of vertices in the graph :");
		int ver = sc.nextInt();
		Gdfs ob = new Gdfs(ver);
		System.out.println("Enter the source vertex :");
		int source = sc.nextInt();
		System.out.println("Depth First Traversal :");
		ob.DFS(source);
	}
}