import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class CeilingFan {

  private String[] speeds = {"OFF", "SPEED 1", "SPEED 2", "SPEED 3"};
  private String[] directions = {"Clockwise", "Anti-Clockwise"};
  private int currentSpeed = 0;
  private int direction = 0;

   /*
    * If the speed of the fan is equal to or greater than 4, then the fan will be turned OFF.
    * If the date is 25th December, then the fan will be turned OFF.
    * Otherwise, the speed will be increased till the speed of 3, and then turned OFF if the cord is pulled again.
    */
  public void changeSpeed() {
    currentSpeed++;
    if(currentSpeed >= 4 ||(LocalDate.now().getMonthValue() == 12
        && LocalDate.now().getDayOfMonth() == 25)) {
      currentSpeed = 0;
    }
  }

  /*
   * Calling this method will the reverse the direction of rotation of the fan from clockwise to
   * anticlockwise or anticlockwise to clockwise
   */
  public void changeDirection() {
    if (direction == 0) {
      direction = 1;
    } else {
      direction = 0;
    }
  }

  @Override
  public String toString() {
    String format = "Fan is running at %s and rotating in %s direction";
    String fanOff = "Fan is OFF";
    if(currentSpeed == 0) {
      return fanOff;
    }
    return String.format(format, speeds[currentSpeed], directions[direction]);
  }

  public static void main(String[] args) {
    CeilingFan ceilingFan = new CeilingFan();
    Scanner scanner = new Scanner(System.in);
    while(true) {
      System.out.println("Enter c to change speed, r to reverse direction, any thing else to exit");
      String s = scanner.nextLine();
      if(s.equalsIgnoreCase("c")) {
        ceilingFan.changeSpeed();
      } else if (s.equalsIgnoreCase("r")) {
        ceilingFan.changeDirection();
      } else {
        break;
      }
      System.out.println(ceilingFan);
    }
  }
}
