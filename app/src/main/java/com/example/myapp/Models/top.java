package com.example.myapp.Models;

public class top {
    int toppic;
    String text;

    public top(int toppic,String text) {
        this.toppic = toppic;
        this.text=text;
    }

    public int gettopPic() {
        return this.toppic;
    }

    public void setPic(int toppic) {
        this.toppic = toppic;
    }
    public void setText(String text) {
        this.text = text;
    }

    public String gettopText() {
        if(this.text==null)
            return "";
        return text;
    }
}
