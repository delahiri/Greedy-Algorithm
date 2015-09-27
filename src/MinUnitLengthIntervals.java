import java.util.ArrayList;
import java.util.List;


public class MinUnitLengthIntervals {

	public static void main(String[] args) {
		double []a = {0.7,1.0,1.5,2.0,2.3,2.6,3.1,3.6,3.9,4.2,4.7,5.2,5.5};
		quickSort(a,0,a.length-1);
		List<ArrayList<Double>> lines = new ArrayList<ArrayList<Double>>();
		
		ArrayList<Double> oneLine = new ArrayList<Double>();
		double upto = a[0]+1.0f;
		oneLine.add(a[0]);
		for(int i= 1;i<a.length;i++)
		{
			if(a[i]<=upto)
			{
				oneLine.add(a[i]);
			}
			else
			{
				lines.add(oneLine);
				oneLine = new ArrayList<Double>();
				upto = a[i]+1.0f;
				oneLine.add(a[i]);
			}
		}
		lines.add(oneLine);
		
		
		for(List<Double> p:lines)
		{
			for(Double n: p)
				System.out.print(n+",");
			System.out.println();
		}
		
		
		
	}

	private static void quickSort(double[] a,int start, int end)
	{
		int i = start, j=end;
		double pivot = a[(i+j)/2];
		
		while(i<=j)
		{
			while(a[i]<pivot)
			{
				i++;
			}
			
			while(a[j]>pivot)
			{
				j--;
			}
			
			if(i<=j)
			{
				double temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}	
		}
		
		if(start < i-1)
			quickSort(a, start, i-1);
		if(end > i)
			quickSort(a, i, end);
		
		
		
	}

}
