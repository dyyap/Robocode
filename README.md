# Robocode
Robocode Final Report
Team members: David Davila, Daniel Yap
Course: CS 141
Robot Name: DDRobot
Introduction
For the Robocode project, we were given the task of programming an
autonomous robot battle tank that battles other tanks in an arena. The
point of the program is to tell the tank what to do in certain
situations that happen in the arena. A date was given to us where we
would battle our robots in class and hold a tournament.
DDRobot Origins
When we first began working on the Robocode, we implemented many of
the more complex methods that the Robocode API offered, such as the
more advanced bullet methods and adaptor methods. We continued to add
more and more methods to our robot as we continued to work on the
project. As we began testing our robot against the other robots, we
noticed that our robot performed poorly in competitions. The more
methods we added and more complicated we made our robot, the worse it
seemed to perform. Taking that into account, Daniel and I decided to
make our robot less complicated to try and maximize our tank’s
performance.
DDRobot Description/Special Features
The DDRobot is very simplistic. It was programmed to perform stronger
when placed in big battles with a larger amount of tanks. It is
programmed so that if it gets spammed hit, it will keep on going until
it gets to a wall and then it will start to shoot. The DDRobot also
has the ability to ram through everything in its way. Since the
placement of the robot on the field is randomized, the robot was coded
so that its movement and angles were also randomized. In this way our
robot became a “chaos bot.” Since the way that most bots fired didn’t
account for straight forward moving, they would aim but shoot too
early. Utilizing that observation, our robot would go and make itself
a target knowing that a majority of shots would miss. Then our robot
would stop and then shoot, which was more accurate than shooting while
moving. We also implemented our own method so that our tank’s shooting
was more efficient. In conclusion, our code was not very long or
complex by any means, especially compared to the robots of the other
students in class. We were more concerned about the theory and
strategy behind the robot in large battles rather than code length and
complexity.
DDRobot Code
● We created a D DRobot class which extends the R obot superclass
public class DDRobot extends Robot {}
● Our r un method is the method that the robot will run on
public void run () {}
● The following four lines of code set the colors of the tank’s
body, gun, bullets, and scan respectively by passing the colors
through the setters established in the Robocode API
setBodyColor(Color . blue);
setGunColor(Color . black);
setBulletColor(Color . green);
setScanColor(Color . green);
● This while loop is implemented so that the robot will run
continuously in battle
while ( true ){}
● The following 5 lines of code control the movement of the robot,
and give the robot its random nature. The ahead method rams the
robot into the other robots, which you recieve points for in
battle. It also serves the purpose of getting to one of the walls
so that our ability to get hit decreases by half. The value of
1000 is placed so that the robot can reach from wall to wall. The
turnGunRight method moves the tank’s gun in circular direction
(hence the 180 that is passed as an argument), and acts as a
scanner. The t urnRight method just ensures that the robot will
turn and then move in a different direction. The value of 90 was
passed so that the robot would turn right. These lines of the
program contribute to the robot’s effectiveness in large battles.
ahead( 1000 );
turnGunRight( 180 );
turnRight( 90 );
ahead( 1000 );
turnGunRight( 180 );
● The o nScannedRobot method is a method from the Robocode API that
scans around for enemy robots. If it sees a robot, it will call
on the s martFire method and pass the distance from enemy robot,
then call on the s can method which essentially resets that robot,
and then calls on the r esume method to resume the robot’s
functions. If it does not see a robot, the the e lse conditional
path is taken and it will call on the s martFire method to
continue firing. In essence, this method will control the robot’s
firing capabilities in battle.
public void onScannedRobot(ScannedRobotEvent e){}
if (stopWhenSeeRobot) {
smartFire(e . getDistance());
scan();
resume();
} else {
smartFire(e . getDistance());
}
}
● Our s martFire method receives the distance our robot is from
another robot as an argument. The distance received will follow
one of the conditional paths and pass a number through the
robocode f ire method. The higher the number the higher the bullet
strength, but the slower the reload time.
public void smartFire( double robotDistance) {
if (robotDistance > 200 || getEnergy() < 15 ) {
fire( 1 );
} else if (robotDistance > 50 ) {
fire( 2 );
} else {
fire( 3 );
}
}
DDRobot Performance
When battle day came, the DDRobot had some mixed results. In the first
round, which included 5 tanks, our robot placed 3rd and did not
qualify for the next round. We noticed that our robot had a decent
performance at best. We noticed that our robot would consistently make
it to the final two robots in the arena, but would consistently lose
the one on one matchup against the other robots. However, we did
observe that our robot performed exceptionally in the battles where
the entire classes robots were involved, reaching second place in the
battle. This is because our robot was programmed under the assumption
that it would face a large amount of tanks at the same time on battle
day. For this specific battle, our strategy of simplicity and
randomness was very effective.
Potential DDRobot Improvements
A few improvements could have been made to the DDRobot to optimize
performance results and potentially reach past the first few rounds. A
general improvement to be made is to program the robot specifically
for one-on-one battles. We observed that the winning robot, “Cloud9”,
had the opposite problem as our robot did. It would demolish the other
robots one-on-one, but would perform poorly in the class competitions
with the entire classes robots. To improve our bot for one-on-one
battle we should have implemented methods to increase our fire rate to
do more damage more quickly to the enemy bot, and increase the tank’s
speed, since it had trouble dodging enemy fire.
How to test the DDRobot
If you would like to test and/or further develop the DDRobot, please
use the following steps:
1. Download Robocode
○ http://robocode.sourceforge.net/
2. Copy the DDRobot source code from our github repository
○ https://github.com/dyyap/Robocode
3. Go onto Robocode and click on the “Robot” tab at the top of the
page
4. Select “Source Editor” from the drop down menu
5. Once the Robot editor opens, click “File” at the top
6. Click “New”
7. Click “Java File”
8. Paste the DDRobot source code in the editor
9. Click on the “Compiler” tab at the top of the page
10. Click “Compile”
11. The DDRobot is now ready to test!
