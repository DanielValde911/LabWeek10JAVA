package org.example;

class FunFact {
    private String fact;
    private int length;
    public FunFact(){};

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String toString(){
        return "FunFact [ fact:" +fact+", length:" + length+" ]";
    }
}
