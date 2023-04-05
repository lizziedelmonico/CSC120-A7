import java.util.Hashtable;
import java.util.Scanner;
/* This is a stub for the Library class */
public class Library extends Building{
  
  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

  /**
   * The constructor that initializes various variables that will be used in the Library.
   * @param name: The name of the library.
   * @param address: The address of the library.
   * @param nFloors: The number of floors the library has. 
   */
  public Library(String name, String address, int nFloors, boolean hasElevator){
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    this.hasElevator = hasElevator;
  }
  
  /**
   * Creates a library with only the name. 
   * @param name: The name of the library. 
   */
  public Library(String name){
    super(name);
    this.collection = new Hashtable<String, Boolean>();
  }

  /**
   * Creates a library with only the name and address.
   * @param name: The name of the library. 
   * @param address: The library's address. 
   */
  public Library(String name, String address){
    super(name, address);
    this.collection = new Hashtable<String, Boolean>();
  }

  /**
   * Adds a book to the library. 
   * @param title: The title and author of the book.
   */
  public void addTitle(String title){
    collection.put(title, true);
  }

  /**
   * Removes a specific book from the library and returns its title.
   * @param title: The title and author of the book.
   * @return: The title and author of the book being removed. 
   */
  public String returnTitle(String title){
    collection.remove(title, false);
    return title;
  }

  /**
   * Checks out a book from the library.
   * @param title: The title and author of the book being checked out.
   */
  public void checkOut(String title){
    collection.replace(title, false);
  }

  /**
   * Returns a book to the library. 
   * @param title: The title and author of the book being returned. 
   */
  public void returnBook(String title){
    collection.replace(title, true);
  }

  /**
   * Checks if a specific book is in the library's collection.
   * @param title: The title and author of the book.
   * @return: Whether or not the book is in the library's collection.
   */
  public boolean containsTitle(String title){
    return collection.containsKey(title);
  }

  /**
   * Checks if a specific book is available to check out.
   * @param title: The title and author of the book.
   * @return: Whether or not the book is available to check out.
   */
  public boolean isAvailable(String title){
    return collection.containsKey(title);
  }

  /**
   * Prints the library's entire collection. 
   */
  public void printCollection(){
    System.out.println("Library: " + collection);
  }

  /**
   * Adds specific information regarding the library class to the parent showOptions() method.
   */
  @Override
  public void showOptions(){
    super.showOptions();
    System.out.println("\n addTitle() \n returnTitle() \n checkOut() \n returnBook() \n containsTitle() \n isAvailable() \n printCollection()");
  }

  /**
   * Adds specific information regarding the library class to the parent goToFloor() method.
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
   * Prints out the specific information of the user-input library.
   * @param args: The various variables used in the class. 
   */
  public static void main(String[] args) {
    Library neilson = new Library("Neilson", "7 Neilson Drive", 5, true);
    System.out.println(neilson);
  }
  
}