package com.company;
public class Main {

    static sender send = new sender();
    static receiver rec = new receiver();

    public static void main(String[] args)  {
        new UI();
        send.Connect();
        rec.Connect();
    }
    public static void Action(String text){
        send.Send(text);
    }
}