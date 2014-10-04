
public class feedback  //set black and white variables for feedback
{
	int b,w;
	
	public feedback()
	{
		b=0;
		w=0;
		
	}
	public void addBlack()	//inc black
	{
		this.b+=1;
	}
	public void addWhite()	//inc white
	{
		this.w+=1;
	}
	public int getBlack()	//get num blacks
	{
		return this.b;
	}
	public int getWhite()	//get num whites
	{
		return this.w;
	}
	//print feedback message
	public void print()
	{
	System.out.print(" -> Result: ");
		if(this.getBlack()>0)
			System.out.print(this.getBlack()+" black peg");
		if(this.getBlack()>1)
			System.out.print("s");
		if(this.getBlack()>0 && this.getWhite()>0)
			System.out.print(" and ");
		if(this.getWhite()>0)
			System.out.print(this.getWhite()+ " white peg");
		if(this.getWhite()>0)
			System.out.print("s");
		if(this.getBlack()==0&&this.getWhite()==0)
			System.out.print("No pegs");
	}
}
