import javax.vecmath.*;
import javax.media.j3d.*;

public class Turtle {
	private Point3d point;
	private Transform3D angle;
	private Frame frame;
	private int sleeptime;

	public Turtle(int sleeptime){
		point = new Point3d();
		angle = new Transform3D();
		this.sleeptime = sleeptime;
	}

	public Turtle(){
		this(500);
	}

	public Turtle(int sleeptime, Frame frame){
		this(sleeptime);
		setFrame(frame);
	}

	public void setFrame(Frame frame){
		this.frame = frame;
	}

	public void fd(double d){
		Point3d taihi = point;

		Vector3d v = new Vector3d(d,0,0);
		angle.transform(v);
		point = new Point3d(
			point.x + v.x,
			point.y + v.y,
			point.z + v.z
		);
		
		Point3d[] vertex = {taihi, point};

		LineArray la = new LineArray(2, GeometryArray.COORDINATES);
		la.setCoordinates(0, vertex);

		if( null == frame )
			System.out.println("please set frame before turtle.fd");
		else
			frame.addShape(new Shape3D(la));
		try{
			Thread.sleep(sleeptime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void bk(double d){
		Point3d taihi = point;

		Vector3d v = new Vector3d(-d,0,0);
		angle.transform(v);
		point = new Point3d(
			point.x + v.x,
			point.y + v.y,
			point.z + v.z
		);
	}

	public void left(double arg){
		Transform3D tmp = new Transform3D();
		tmp.rotY( Math.PI * arg / 180 );
		angle.mul(tmp);
	}

	public void right(double arg){
		left(-arg);
	}

	public void up(double arg){
		Transform3D tmp = new Transform3D();
		tmp.rotZ( Math.PI * arg / 180 );
		angle.mul(tmp);
	}

	public void down(double arg){
		up(-arg);
	}

	public void twist(double arg){
		Transform3D tmp = new Transform3D();
		tmp.rotX( Math.PI * arg / 180 );
		angle.mul(tmp);
	}

	public void r_twist(double arg){
		twist(-arg);
	}
}
