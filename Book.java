import Product.Category;

/* A book IS A product that has additional information - e.g. title, author

 	 A book also comes in different formats ("Paperback", "Hardcover", "EBook")
 	 
 	 The format is specified as a specific "stock type" in get/set/reduce stockCount methods.

*/
public class Book extends Product {
  private String author;
  private String title;

  // Stock related information NOTE: inherited stockCount variable is used for
  // EBooks
  int paperbackStock;
  int hardcoverStock;

  public Book(String name, String id, double price, int paperbackStock, int hardcoverStock, String title,
      String author) {
    // Make use of the constructor in the super class Product. Initialize additional
    // Book instance variables.
    // Set category to BOOKS
    super(name, id, price, Integer.MAX_VALUE, Category.BOOKS);
    this.paperbackStock = paperbackStock;
    this.hardcoverStock = hardcoverStock;

    this.author = author;
    this.title = title;

  }

  // Check if a valid format
  public boolean validOptions(String productOptions) {
    // check productOptions for "Paperback" or "Hardcover" or "EBook"
    // if it is one of these, return true, else return false
    if (productOptions.equalsIgnoreCase("Paperback")) {
      return true;
    } else if (productOptions.equalsIgnoreCase("Hardcover")) {
      return true;
    } else if (productOptions.equalsIgnoreCase("Ebook")) {
      return true;
    } else {
      return false;
    }

  }

  // Override getStockCount() in super class.
  public int getStockCount(String productOptions) {
    // Use the productOptions to check for (and return) the number of stock for
    // "Paperback" etc
    // Use the variables paperbackStock and hardcoverStock at the top.
    // For "EBook", use the inherited stockCount variable.
    if (productOptions.equalsIgnoreCase("EBook")) {
      return super.getStockCount("");
    } else if (productOptions.equalsIgnoreCase("PAPERBACK")) {
      return this.paperbackStock;
    } else if (productOptions.equalsIgnoreCase("HARDBACK")) {
      return this.hardcoverStock;
    } else {
      return 1;
    }

  }

  public void setStockCount(int stockCount, String productOptions) {
    // Use the productOptions to check for (and set) the number of stock for
    // "Paperback" etc
    // Use the variables paperbackStock and hardcoverStock at the top.
    // For "EBook", set the inherited stockCount variable.
    if (productOptions.equalsIgnoreCase("EBOOK")) {

      super.setStockCount(stockCount, productOptions);
    } else if (productOptions.equalsIgnoreCase("PAPERBACK")) {

      this.paperbackStock = stockCount;
    } else if (productOptions.equalsIgnoreCase("HARDBACK")) {
      this.hardcoverStock = stockCount;
    }

  }

  /*
   * When a book is ordered, reduce the stock count for the specific stock type
   */
  public void reduceStockCount(String productOptions) {
    // Use the productOptions to check for (and reduce) the number of stock for
    // "Paperback" etc
    // Use the variables paperbackStock and hardcoverStock at the top.
    // For "EBook", set the inherited stockCount variable.

    if (productOptions.equalsIgnoreCase("EBOOK")) {

      super.reduceStockCount("");
    } else if (productOptions.equalsIgnoreCase("PAPERBACK")) {

      this.paperbackStock--;
    } else if (productOptions.equalsIgnoreCase("HARDBACK")) {

      this.hardcoverStock--;
    }

  }

  /*
   * Print product information in super class and append Book specific information
   * title and author
   */
  public void print() {
    // Replace the line below.
    // Make use of the super class print() method and append the title and author
    // info. See the video
    super.print();
    System.out.printf(" Book Title " + this.title + " Author: " + this.author);

    System.out.print("\nBook");
  }
}
