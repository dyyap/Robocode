
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

		// Save # of other bots
		others = getOthers();

		// Move to a corner
		goCorner();

		// Initialize gun turn speed to 3
		int gunIncrement = 3;

		// Spin gun back and forth
		while (true) {
			for (int i = 0; i < 30; i++) {
				turnGunLeft(gunIncrement);
			}
			gunIncrement *= -1;
		}
	}

	/**
	 * goCorner:  A very inefficient way to get to a corner.  Can you do better?
	 */
	public void goCorner() {
		// We don't want to stop when we're just turning...
		stopWhenSeeRobot = false;
		// turn to face the wall to the "right" of our desired corner.
		turnRight(normalRelativeAngleDegrees(corner - getHeading()));
		// Ok, now we don't want to crash into any robot in our way...
		stopWhenSeeRobot = true;
		
		ahead(5000);
	
		turnLeft(90);
		// Move to the corner
		ahead(5000);
		// Turn gun to starting point
		turnGunLeft(90);
	}

	/**

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

