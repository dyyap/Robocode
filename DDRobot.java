
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
			turnright(90);
			ahead(100);
			for (int i = 0; i < 30; i++) {
				turnGunLeft(gunIncrement);
			}
			gunIncrement *= -1;
		}
	}



	 */
	public void onScannedRobot(ScannedRobotEvent e) {
	
		if (stopWhenSeeRobot) {
			// Stop everything!  You can safely call stop multiple times.
			smartFire(e.getDistance());
			// Look for another robot.
			// NOTE:  If you call scan() inside onScannedRobot, and it sees a robot,
			// the game will interrupt the event handler and start it over
			scan();
			// We won't get here if we saw another robot.
			// Okay, we didn't see another robot... start moving or turning again.
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

