import java.util.*;

public class LibraryApp {
    static Scanner sc = new Scanner(System.in);
    static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1) Add  2) Borrow/Return  3) Report  4) Exit");
            int c = Integer.parseInt(sc.nextLine());
            if (c == 1) add();
            else if (c == 2) toggle();
            else if (c == 3) report();
            else if (c == 4) break;
        }
    }

    static void add() {
        System.out.print("Title: ");
        books.add(new Book(sc.nextLine()));
    }

    static void toggle() {
        for (int i = 0; i < books.size(); i++)
            System.out.println((i+1)+") "+books.get(i));
        if (books.isEmpty()) return;
        int n = Integer.parseInt(sc.nextLine())-1;
        if (n>=0 && n<books.size()) {
            books.get(n).borrowed = !books.get(n).borrowed;
        }
    }

    static void report() {
        int b=0; for (Book bk:books) if(bk.borrowed) b++;
        System.out.println("Total: "+books.size()+" Borrowed: "+b);
    }

    static class Book {
        String title; boolean borrowed;
        Book(String t){ title=t; }
        public String toString(){ return title+(borrowed?" (Borrowed)":" (Available)"); }
    }
}
