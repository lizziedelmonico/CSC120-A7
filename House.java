import java.util.ArrayList;
import java.util.Scanner;


/* This is a stub for the House class */
public class House extends Building{

  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  public int hasResidents;
  private boolean hasElevator;

 /**
  * A constructor that initializes various variables. 
  * @param name: The name of the house. 
  * @param address: The address of the house. 
  * @param nFloors: The number of floors in the house.
  * @param hasDiningRoom: If the house has a dining room. 
  */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
  }

  /**
   * Creates a house with only its name, address, number of floors, and if it has an elevator. 
   * @param name: The name of the house. 
   * @param address: The address of the house. 
   * @param nFloors: The number of floors the house has. 
   * @param hasElevator: If the house has an elevator. 
   */
  public House(String name, String address, int nFloors, boolean hasElevator){
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasElevator = hasElevator;
  }

  /**
   * Creates a house with only its name, address, and if it has a dining room.
   * @param name: The name of the house. 
   * @param address: The address of the house. 
   * @param hasDiningRoom: If the house has a dining room. 
   */
  public House(String name, String address, boolean hasDiningRoom){
    super(name, address);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
  }

  /**
   * Adds a resident to the array list of names.
   * @param name: the name of the resident moving in.
   */
  public void moveIn(String name){
    this.residents.add(name);
  }

  /**
   * Removes a resident from the array list of names. 
   * @param name: The name of the resident moving out. 
   * @return: name of the resident moving out.
   */
  public String moveOut(String name){
    this.residents.remove(name);
    return name;
  }

  /**
   * States whether or not a specific person lives in the house. 
   * @param person: The name of a person whom the user wants to search for. 
   * @return: Whether or not the person lives in the house.
   */
  public boolean isResident(String person){
    return this.residents.contains(person);
  }

/**
 * Adds specific information regarding the house class to the parent showOptions() method. 
 */
  @Override
  public void showOptions(){
    super.showOptions();
    System.out.println("\n moveIn() \n moveOut() \n isResident()");
  }

  /**
   * Adds specific information regarding the house class to the parent goToFloor() method. 
   */
  @Override
  public void goToFloor(int floorNum){
    super.goToFloor(floorNum);
    if (hasElevator == true){
      Scanner scanner = new Scanner(System.in);
      System.out.println("What floor do you want to go to?");
      int floor = scanner.nextInt();
      System.out.println("You are now on floor # " + floor + "of" + this.name);
      scanner.close();
    }
  }

  /**
   * Gives a description of the house (number of residents and if it has a dining room).
   * @return: The description stating the number of residents in the house and whether or not it has a dining room.
   */
  public String toString(){
    String description = super.toString();
    description += ". This house currently has " + this.residents.size() + " residents.";
    if (this.hasDiningRoom) {
      description += " This house has a dining room.";
    } else {
    description += "This house does not have a dining room.";
    }
    return description;
  }
  
  /**
   * Prints out the information of a specific house. 
   * @param args: The various variables used in the class. 
   */
  public static void main(String[] args) {
    House scales = new House("Scales", "170 Elm Street", 5, true, true);
    System.out.println(scales);
  }

}