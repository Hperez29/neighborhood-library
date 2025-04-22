package com.pluralsight;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedout;
    private String checkedOutto;

    public Book(int id, String isbn, String title, boolean isCheckedout, String checkedOutto) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedout = isCheckedout;
        this.checkedOutto = checkedOutto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedout() {
        return isCheckedout;
    }

    public void setCheckedout(boolean checkedout) {
        isCheckedout = checkedout;
    }

    public String getCheckedOutto() {
        return checkedOutto;
    }

    public void setCheckedOutto(String checkedOutto) {
        this.checkedOutto = checkedOutto;
    }

    public void checkOut(String name){
        this.isCheckedout = true;
        this.checkedOutto = name;
    }
    public void checkIn(){
        this.checkedOutto = "";
        this.isCheckedout = false;
    }
}

