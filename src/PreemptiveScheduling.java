import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class PreemptiveScheduling {

	public static void main(String[] args) {
		int s[] = {2,4,5,1,7,4,3};
		int p[] = {2,3,8,9,3,6,1};
		PriorityQueue<Task> pq = new PriorityQueue<Task>(11, new TaskComparator());
		Map<Integer,ArrayList<Task>> tasks = new HashMap<Integer,ArrayList<Task>>();
		List<Character> tasksDone = new ArrayList<Character>();
		int totaltime = 0;
		
		for(int i =0;i<p.length;i++)
		{
			Task t = new Task();
			t.start = s[i];
			t.processingTime = p[i];
			totaltime+=t.processingTime;
			t.id = (char)('A'+i);
			if(tasks.containsKey(t.start))
			{
				ArrayList<Task> l = tasks.get(t.start);
				l.add(t);
			}
			else
			{
				ArrayList<Task> l = new ArrayList<Task>();
				l.add(t);
				tasks.put(t.start, l);
			}
			
		}
		
		
		for(int i=0;i<totaltime;i++)
		{
			List<Task> listOfTasks = tasks.get(i);
			if(listOfTasks != null)
			{
				for(Task t:listOfTasks)
				{
					pq.add(t);
				}
			}
			
			if(!pq.isEmpty())
			{
				Task t =pq.poll();
				t.processingTime--;
				tasksDone.add(t.id);
				if(t.processingTime >0)
				{
					pq.add(t);
				}
			}
			
		}
		
		
		for(char c:tasksDone)
		{
			System.out.print(c);
		}
		
		
		

	}
	
}

	class Task
	{	
		char id;
		int start;
		int processingTime;
	}
	
	class TaskComparator implements Comparator<Task>
	{


		@Override
		public int compare(Task o1, Task o2) {
			return o1.processingTime-o2.processingTime;
		}
		
	}
