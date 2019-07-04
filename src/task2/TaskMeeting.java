package task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TaskMeeting {

	public static void main(String[] args) throws IOException {
		String line;
		File inp= new File("input2.txt");
		BufferedReader br = new BufferedReader(new FileReader(inp));
		StringTokenizer tk;

	//	long unixTime = System.currentTimeMillis() / 1000L;
	//	System.out.println(unixTime);
		List<Meeting> ListMeeting=new ArrayList<>();

		int NRequest = Integer.parseInt(br.readLine());
		for (int i = 0; i < NRequest; ++i)
		{
			line = br.readLine();
			tk = new StringTokenizer(line, " :");
			String cmd = tk.nextToken();

			if (cmd.compareTo("APPOINT") == 0)
			{
				int day = Integer.parseInt(tk.nextToken());
				int hour = Integer.parseInt(tk.nextToken());
				int minute = Integer.parseInt(tk.nextToken());
				int duration = Integer.parseInt(tk.nextToken());
				int peopleN = Integer.parseInt(tk.nextToken());
				String people[] = new String[peopleN];
				
				for (int j = 0; j < peopleN; ++j)
				{
					people[j] = tk.nextToken();
				}
				Meeting met= new Meeting(day,hour,minute,duration,peopleN);

				ListMeeting.add(met); //список всех встреч			
				int start = (hour * 60) + minute;
				int end = start + duration;

			}
		}

	}

}

//класс с данными по встречам
class Meeting{
	private int dayYear;
	private int hour;
	private int minute;
	private int duration;
	private int peopleN;
	private String[] people;
	
	public Meeting(int day, int h, int m, int d, int pn) {
		dayYear=day;
		hour=h;
		minute=m;
		duration=d;
		peopleN=pn;
//		people=name;
	}
	public int getDay() {
		return dayYear;
	}
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public int getDuration() {
		return duration;
	}
	public int getPeopleN() {
		return peopleN;
	}
/*	public String[] getListPeople() {
		return people;
	}*/
}

