package com.example.myapp.Models;

public class Face {
    int pic;
    String text;

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Face(int pic, String text) {
        this.pic = pic;
        this.text = text;
    }
}
