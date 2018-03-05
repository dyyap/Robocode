
package asdf;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import java.awt.*;



public class DDRobot extends Robot {

	static int corner = 0; // Which corner we are currently using
	// static so that it keeps it between rounds.
	boolean stopWhenSeeRobot = false; // See goCorner()


	public void run() {
		// Set colors
		setBodyColor(Color.blue);
		setGunColor(Color.black);
		setBulletColor(Color.green);
		setScanColor(Color.green);


		// Initialize gun turn speed to 3
		int gunIncrement = 3;

		// Spin gun back and forth
		while (true) {
			
			ahead(100);
			turnRight(90);
			ahead(100);
			for (int i = 0; i < 30; i++) {
				turnGunLeft(gunIncrement);
			}
			gunIncrement *= -1;
		}
	}



	 
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

