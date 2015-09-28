import java.util.ArrayList;
import java.util.List;


public class DivideSongsIntoCDs {

	public static void main(String[] args) {
		int songs[] = {20,10,11,45,23,7,12,7,33,18,34,15,41,9};
		int m=46;
		List<ArrayList<Integer>> cds = new ArrayList<ArrayList<Integer>>();
		
		int filledTillNow = 0;
		ArrayList<Integer> cd = new ArrayList<Integer>();
		cd.add(1);
		filledTillNow = songs[0];
		for(int i=1;i<songs.length;i++)
		{
			if(filledTillNow+songs[i] < m)
			{
				cd.add(i+1);
				filledTillNow+=songs[i];
			}
			else
			{
				cds.add(cd);
				cd = new ArrayList<Integer>();
				filledTillNow = 0;
				i--;
			}
		}
		
		if(cd.size() > 0)
			cds.add(cd);
		
		for(List<Integer> p: cds)
		{
			for(int n:p)
				System.out.print(songs[n-1]+",");
			System.out.println();
		}
		

	}

}
