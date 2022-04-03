/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WinApp;

public class showInfo {
    private int qua;
    private double price;
    private String name, company, type, counter, more, date;
    
    
    public showInfo(String date, String name, String company, String type, String counter, int qua ,double price, String more)
    {
        this.name = name;
        this.company = company;
        this.type = type;
        this.counter = counter;
        this.more = more;
        this.date = date;
        this.qua = qua;
        this.price = price;
    }
    
    public String getDate(){
        return date;
    }
    public String getName(){
        return name;
    }
    
    public String getCompany(){
        return company;
    }
     
    public String getType(){
        return type;
    }
    
    public String getCounter(){
        return counter;
    }
    public double getPrice(){
        return price;
    }
    public int getQua(){
        return qua;
    }
    public String getMore(){
        return more;
    }
}
