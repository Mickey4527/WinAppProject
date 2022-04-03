/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WinApp;

public class showInfo {
    private int qua;
    private double price;
    private String name, company, type, b, more, date;
    
    
    public showInfo(String date, String name, String company, String type, String b, int qua ,double price, String more)
    {
        this.name = name;
        this.company = company;
        this.type = type;
        this.b = b;
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
    
    public String getB(){
        return b;
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
