public class Library {
    private static int numOpenLibrary;
    private String name;
    private int id;
    private boolean isOpen;
    private Book[] collection;

    public Library(String name, int id, int capacity) {
        this.name = name;
        this.id = id;
        this.isOpen = false;
        collection = new Book[capacity];
    }

    public int getNumOpenLibrary() {
        return this.numOpenLibrary;
    }
    
    public void closeLibrary() {
        if (isOpen && numOpenLibrary >= 0) {
            isOpen = false;
            
            numOpenLibrary--;
        }
    }

    public void openLibrary() {
        if (!isOpen) {
            isOpen = true;
            numOpenLibrary++;
        }
    }

    public void addBook(Book bk) {
        // does this library have room? if capacity blah blah
        
    }
}
