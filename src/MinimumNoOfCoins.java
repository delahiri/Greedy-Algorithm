
public class MinimumNoOfCoins {

	public static void main(String[] args) {
		int d[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
		int m=675;
		quickSort(d,0,d.length-1);
		int total=0;
		
		for(int i=0;i<d.length && m>0;i++)
		{
			if(d[i] <= m)
			{
				int noOfCoins = m/d[i];
				System.out.println(d[i] +"X" + noOfCoins);
				total+=noOfCoins;
				m%=d[i];
			}
		}
		
		
		System.out.println("Total coins "+total);
		
	}

	private static void quickSort(int[] a, int start, int end) 
	{
		int i = start;
		int j= end;
		int pivot = a[(i+j)/2];
		
		while(i<=j)
		{
			while(a[i] > pivot)
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
				i++;
				j--;
			}
			
			
		}
		
		if(start <i-1)
		quickSort(a, start, i-1);
		if(end >i)
		quickSort(a, i, end);
		
	}

}
