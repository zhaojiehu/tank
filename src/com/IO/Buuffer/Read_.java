package com.IO.Buuffer;

public abstract class Read_ {
    public void b(){};
    public void a(){};
}
class A extends Read_{
    public void b(){
        System.out.println("1");
    }
}
class B extends Read_{
    public void a(){
        System.out.println("2");
    }
}
class Buffer extends Read_{
    private Read_ in;

    public Buffer(Read_ in) {
        this.in = in;
    }
    public void bufferA(){
        for (int i = 0; i < 10; i++) {
              in.b();
        }
    }
}
