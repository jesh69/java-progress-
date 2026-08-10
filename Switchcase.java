public class Switchcase {
  public static void main(String[] args) {
    int choice = 1;

    // 1 = Coffee
    // 2 = tea

    switch (choice) {
      case 1:
        System.out.println("You ordered Coffee");
       break;
      case 2:
        System.out.println("You ordered Tea");
       break;
      default:
        System.out.println("Invalid choice");
    }
  }
}
