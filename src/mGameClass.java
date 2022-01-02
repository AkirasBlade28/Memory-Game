import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;



public class mGameClass {
	
	private Random rand;
	private ArrayList <String> ranStr;
	private ArrayList <Character> ranChars;
	
	mGameClass (Random r, ArrayList <String> l ){
		this.rand = r;
		this.ranStr = l;
		
	}
	public static ArrayList <Integer> ranNumbers (Random rand)
	{   
		ArrayList <Integer> arList = new ArrayList<>();
		HashMap <Integer,Integer> map = new HashMap<>(); // using HashMaps key storing ability to prevent duplicate numbers to be stored
														// when generating random number from 1 to 20 

			for(int i=0; i<20; ++i) {  //4*5
			
			boolean isTrue = false;
			
			while(isTrue == false) {
			
				int val = rand.nextInt(20)+1;
				if(map.containsKey(val)) {
					isTrue = false;
				}
				else if(!map.containsKey(val)) {
					    
					map.put(val, null); 
					arList.add(val); // using array list instead of map for actual storing the values is done because I noticed that
									//  when invoking the map key integers value we get sorted list, which is not needed. 
					break;
					
				}
			}
			; // left intentionally
		}
		map.clear(); // map closed for further use
		return arList;
	}
	
	public ArrayList <Character> getChars (){
		
		return ranChars;
	}
	
	public  ArrayList <String> ranC (Random rand, ArrayList <String> ranStr, ArrayList <Character> cr){
		this.ranChars = cr;
		ArrayList <Integer> arList = ranNumbers(rand);
		ranChars = new ArrayList<>();
		
		
		for(int i=0; i<arList.size(); ++i) {
			int r = arList.get(i);
			char p = digitConvert(r);
			ranChars.add(p);
		}
		
		for(int i=0; i<ranChars.size(); ++i) {
			char c = ranChars.get(i);
			String s = imagesReferances(c);
			ranStr.add(s);
		}
		
		return ranStr;
	}
	
	public static char digitConvert (int val)
	{
		switch (val)
		{
		case 1:
			return '!';//1       
		case 2:
			return '&';//2
		case 3:
			return '%';//3
		case 4:
			return '#';//4
		case 5:
			return '@';//5..n
		case 6:
			return '!';
		case 7:
			return '&';
		case 8:
			return '%';
		case 9:
			return '#';
		case 10:
			return '@';
		case 11:
			return '!';
		case 12:
			return '&';
		case 13:
			return '%';
		case 14:
			return '#';
		case 15:
			return '@';
		case 16:
			return '!';
		case 17:
			return '&';
		case 18:
			return '%';
		case 19:
			return '#';
		case 20:
			return '@';
			default:
			return ' ';
		}
	}
	
	public static String  imagesReferances(char c)
	{
			switch(c) {
			
			case '@':
				return "/resources/a.png";
			
			case '!':
				return "/resources/b.png";
				
			case '#':
				return "/resources/c.png";
				
			case '%':
				return "/resources/d.png";
				
			case '&':
				return "/resources/e.png";
			
			default:
				return " ";
			}	
	}
}
