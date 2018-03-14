
package asdf;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import java.awt.*;



public class DDRobot extends Robot {

	

	public void run() {
		// Set colors
		setBodyColor(Color.blue);
		setGunColor(Color.black);
		setBulletColor(Color.green);
		setScanColor(Color.green);



		// Spin gun back and forth
		while (true) {
			
			ahead(1000);
			turnGunRight(180);
			turnRight(90);
			
			ahead(1000);
			turnGunRight(180);

	 
	public void onScannedRobot(ScannedRobotEvent e) {
	
		 
//kind of stole my idea of an altering firing system, but the devs did it better
// smartfire system cc dev.
		if (stopWhenSeeRobot) {
			
			smartFire(e.getDistance());
			
			scan();
			
			resume();
		} else {
			smartFire(e.getDistance());
		}
	}
	


	public void smartFire(double robotDistance) {
		if (robotDistance > 200 || getEnergy() < 15) {
			fire(1);
		} else if (robotDistance > 50) {
			fire(2);
		} else {
			fire(3);
		}
	}
	}

