package com.adepuu.exercises.session10;

import java.util.HashMap;
import java.util.Map;

// Abstract class representing a library material
abstract class LibraryMaterial {
    private String title;
    private int availabilityCount;

    public LibraryMaterial(String title, int availabilityCount) {
        this.title = title;
        this.availabilityCount = availabilityCount;
    }

    public String getTitle() {
        return title;
    }

    public int getAvailabilityCount() {
        return availabilityCount;
    }

    public void setAvailabilityCount(int availabilityCount) {
        this.availabilityCount = availabilityCount;
    }

    public abstract void borrow();

    public abstract void returnMaterial();
}

// Concrete class representing a book
class Book extends LibraryMaterial {
    public Book(String title, int availabilityCount) {
        super(title, availabilityCount);
    }

    @Override
    public void borrow() {
        if (getAvailabilityCount() > 0) {
            setAvailabilityCount(getAvailabilityCount() - 1);
            System.out.println("Book \"" + getTitle() + "\" has been borrowed.");
        } else {
            System.out.println("Book \"" + getTitle() + "\" is not available for borrowing.");
        }
    }

    @Override
    public void returnMaterial() {
        setAvailabilityCount(getAvailabilityCount() + 1);
        System.out.println("Book \"" + getTitle() + "\" has been returned.");
    }
}

// Concrete class representing a DVD
class DVD extends LibraryMaterial {
    public DVD(String title, int availabilityCount) {
        super(title, availabilityCount);
    }

    @Override
    public void borrow() {
        if (getAvailabilityCount() > 0) {
            setAvailabilityCount(getAvailabilityCount() - 1);
            System.out.println("DVD \"" + getTitle() + "\" has been borrowed.");
        } else {
            System.out.println("DVD \"" + getTitle() + "\" is not available for borrowing.");
        }
    }

    @Override
    public void returnMaterial() {
        setAvailabilityCount(getAvailabilityCount() + 1);
        System.out.println("DVD \"" + getTitle() + "\" has been returned.");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create library materials
        Book book1 = new Book("Harry Potter", 2);
        DVD dvd1 = new DVD("Inception", 1);

        // Map to keep track of available materials
        Map<String, LibraryMaterial> libraryMaterials = new HashMap<>();
        libraryMaterials.put(book1.getTitle(), book1);
        libraryMaterials.put(dvd1.getTitle(), dvd1);

        // Borrow and return materials
        borrowMaterial(libraryMaterials, "Harry Potter");
        borrowMaterial(libraryMaterials, "Inception");
        borrowMaterial(libraryMaterials, "Harry Potter");

        returnMaterial(libraryMaterials, "Inception");
        returnMaterial(libraryMaterials, "Harry Potter");
    }

    // Method to borrow a material
    public static void borrowMaterial(Map<String, LibraryMaterial> libraryMaterials, String title) {
        LibraryMaterial material = libraryMaterials.get(title);
        if (material != null) {
            material.borrow();
        } else {
            System.out.println("Material \"" + title + "\" not found in the library.");
        }
    }

    // Method to return a material
    public static void returnMaterial(Map<String, LibraryMaterial> libraryMaterials, String title) {
        LibraryMaterial material = libraryMaterials.get(title);
        if (material != null) {
            material.returnMaterial();
        } else {
            System.out.println("Material \"" + title + "\" not found in the library.");
        }
    }
}
