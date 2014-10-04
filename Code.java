import java.util.ArrayList;
import java.lang.Math;
public class Code 
{
	char[] c;
	
	//Constructor for a random code
	public Code(int len, char[] colors )
	{
		System.out.println("Generating secret code...");
		c = new char[len];				//Set the length of the code
		int n = colors.length;			//number of valid colors
		for(int r = 0;r<len;r+=1)
		{
			int rand =(int)(Math.random()*n);
			c[r] = colors[rand];		//Assign random colors
		}
	}
	public Code(Code i)
	{
		c=new char[i.size()];			//get code
		for(int n = 0;n<i.size();n+=1)
		{
			c[n]=i.get(n);
		}
	}
	//Make a code out of a string
	public Code(String input)
	{
		c = new char[input.length()];
		for(int i = 0;i<input.length();i+=1)
		{
			c[i]=input.charAt(i);
		}
	}
	//check if code is a valid guess
	public boolean isValid(int s, char[] colors){
		if(this.size()!=s)
		{
			return false;
		}
		for(int r=0; r<this.size();r+=1)
		{
			boolean valid = false;
			for(int c = 0; c<colors.length;c+=1)
			{
				if(this.get(r)==colors[c])
				{
					valid=true;					
				}				
			}
			if(valid==false)
			{
				return false;
			}
		}
		
		
		return true;
	}
	//get length
	public int size()
	{
		return this.c.length;
	}
	//get one element
	public char get(int n)
	{
		return this.c[n];
	}
	//set one element
	public void set(int n, char v)
	{
		this.c[n] = v;
	}
	//check if same
	public boolean equals(Code ans)
	{
		if(ans.size() != this.size())
		{
			return false;
		}
		for(int i = 0; i<this.size();i+=1)
		{
			if(ans.get(i)!=this.get(i))
			{
				return false;
			}
		}
		
		return true;
	}
	//print
	public void print()
	{
		for(int i = 0; i<this.size();i+=1)
		{
			System.out.print(this.get(i));
		}
	}
	//guess feedback
	public feedback getFeedback(Code ans)
	{
		Code a = new Code(ans);
		Code g = new Code(this);
		
		feedback ret = new feedback();
		if(a.size() != g.size())
		{
			return ret;
		}
		for(int i = 0;i<a.size();i+=1)		//Checks for black pegs
		{
			if(g.get(i)==a.get(i)&& g.get(i)!= (char)0)
			{
				ret.addBlack();
				g.set(i,(char) 0);
				a.set(i,(char) 0);
			}
		}
				
		for(int r = 0; r<a.size();r+=1)		//check for white pegs
		{
			char comp = g.get(r);
			
			for(int c = 0; c<a.size();c+=1)
			{
				if(comp == a.get(c)&&comp!=(char)0)
				{
					ret.addWhite();
					g.set(r,(char) 0);
					a.set(c,(char) 0);
				}
			}
		}
		
		return ret;
	}
}
