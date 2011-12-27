public class Sample {
	private static Frame frame = new Frame(600, 600, "3D Turtle Graphics");

	public static void main(String args[]){
		//this is sample.
		//Turtle(sleeptime, frame).
		foo( new Turtle(10, frame), 0.4 );
	}

	//draw passeri
	private static void foo(Turtle t, double arg){
		if (arg < 0.01) return;

		for(int i=0; i<3; i++){
			t.down(30);
			t.fd(arg);
			foo( t, arg/2 );
			t.bk(arg);
			t.up(30);
			t.twist(120);
		}
	}
}
