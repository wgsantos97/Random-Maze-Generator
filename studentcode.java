class studentcode extends mazedfs
{
	public studentcode(int bh0, int mh0, int mw0) // don't change constructor
	{
		super(bh0,mh0,mw0); 
	}

	public void digout(int y, int x)   // modify this function
	{
		// The following is a skeleton program that demonstrates the mechanics
		// needed for the completion of the program.

		// We always dig out two spaces at a time: we look two spaces ahead
		// in the direction we're trying to dig out, and if that space has
		// not already been dug out, we dig out that space as well as the
		// intermediate space.  This makes sure that there's always a wall
		// separating adjacent corridors.

		M[y][x] = 1;  // digout maze at coordinate y,x
		drawblock(y,x);  // change graphical display to reflect space dug out
		delay(40); // slows animation

		//Permutation of Directions
		int[] P = {0,1,2,3};
		for(int i=0; i<P.length; i++){
			int r = i+(int)(Math.random()*P.length-i); //r is between i and P.length-1
			int temp = P[i]; //swap each element with some random element
			P[i] = P[r];
			P[r] = temp;
		}

		//NESW -> 0,1,2,3
		int []dX = {0, 1, 0, -1};
		int []dY = {-1, 0, 1, 0};

		for(int dir=0; dir<4; dir++){
			int rand=P[dir];
			int dx = dX[rand], dy = dY[rand];
			int nx = x+dx*2, ny = y+dy*2;

			if (nx>=0 && nx<mw && ny>=0 && ny<mh && M[ny][nx]==0) // always check for maze boundaries //order matters 
			{
				M[y+dy][x+dx] = 1;
				drawblock(y+dy,x+dx);
				digout(ny,nx);
			}
		}//done!
	}//digout
}//studentcode subclass

