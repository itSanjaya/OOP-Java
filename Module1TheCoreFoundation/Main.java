// Create a class named Book.
// Give it three attributes: title (String), author (String), and totalPages (int).
// Create a constructor to initialize these three attributes.
// Create a method named readPages(int pagesRead) that subtracts pages from totalPages and prints out how many pages are left in the book.

class Book {
	String title;
	String author;
	int totalPages;
	
	Book(String bookTitle, String bookAuthor, int numberPages){
		this.title = bookTitle;
		this.author = bookAuthor;
		this.totalPages = numberPages;
	}
	
	void readPages(int pagesRead) {
		this.totalPages -= pagesRead;
		System.out.println("Number of pages left to read are:" + this.totalPages);
	}
}

public class Main{
	public static void main(String[] args){
		Book newBook = new Book ("OOP Java", "Ram Pur", 590);
		
		newBook.readPages(198);
	}
}