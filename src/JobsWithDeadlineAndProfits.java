
public class JobsWithDeadlineAndProfits {

	public static void main(String[] args) {
		
		int p[] = {100,19,27,25,15};
		char id[] = new char[p.length];
		int d[] = {2,1,2,1,3};
		for(int i=0;i<p.length;i++)
		{
			id[i] = (char)(i+'a');
		}
		quickSort(p, 0, p.length-1,id,d);
	
		
		int maxtimeLine = 0;
		for(int i:d)
		{
			maxtimeLine = Math.max(maxtimeLine, i);
		}
		
		char[] timeLine = new char[maxtimeLine+1];
		
		for(int i=0;i<p.length;i++)
		{
			int deadline = d[i];
			int t = deadline;
			while(t >0 &&timeLine[t] != '\0')
			{
				t--;
			}
			if(t>0)
			timeLine[t] = id[i];
		}
		
		
		for(char c:timeLine)
		{
			if(c != '\0')
			System.out.println(c+",");
		}
		
		
			

	}
	
	private static void quickSort(int a[],int start,int end, char[] id, int[] d)
	{
		int i= start;
		int j=end;
		int pivot = a[(i+j)/2];
		
		while(i<=j)
		{
			while(a[i]> pivot)
			{
				i++;
			}
			while(a[j]<pivot)
			{
				j--;
			}
			
			if(i<=j)
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				
				char jn = id[i];
				id[i] = id[j];
				id[j] = jn;
				
				int dt = d[i];
				d[i] = d[j];
				d[j] = dt;
				
				
				i++;
				j--;
			}
		}
		
		if(start < i-1)
			quickSort(a, start, i-1,id,d);
		if(end >i)
			quickSort(a, i, end,id,d);
		
		
	}

}
