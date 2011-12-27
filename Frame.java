import javax.swing.JFrame;
import java.awt.*;
import javax.media.j3d.*;

import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.behaviors.vp.*;
import javax.vecmath.*;

public class Frame extends JFrame {
	private Canvas3D canvas;
	private SimpleUniverse universe;
	
	public Frame(int width, int height, String title){
		super(title);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
		canvas = new Canvas3D(config);
		canvas.setSize(new Dimension(width, height));
		
		universe = new SimpleUniverse(canvas);
		universe.getViewingPlatform().setNominalViewingTransform();
		setBehavior();

		add(canvas);
		this.pack();
		this.setVisible(true);
	}

	public void addTurtle(Turtle t){
		t.setFrame(this);
	}

	public void addShape(Shape3D shape){
		BranchGroup tmp = new BranchGroup();
		tmp.addChild( shape );
		tmp.compile();
		universe.addBranchGraph(tmp);
	}
	
	private void setBehavior(){
		OrbitBehavior orbit = new OrbitBehavior(canvas, OrbitBehavior.REVERSE_ALL);
		orbit.setSchedulingBounds(
				new BoundingSphere(new Point3d(0,0,0), 100));
		universe.getViewingPlatform().setViewPlatformBehavior(orbit);
	}
}
