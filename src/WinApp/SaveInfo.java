/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WinApp;

/**
 *
 * @author mix_z
 */
public class SaveInfo {
     private double price;
     private int stock;
    
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    public void setStock(int stock)
    {
        this.stock = stock;
    }
     
    public double calSumProduct()
    {
        double sum;
        sum = price * stock;
        
        return sum;
    }
}

 // SaveInfo info = new SaveInfo();
       // double price = Double.parseDouble(txtPrice.getText());
        
       // if(chkVat.isSelected())
       //{
       //     info.setPrice(price);  
        //    JOptionPane.showMessageDialog(this, info.calVat());
       // }
       // else
        //{
        //    JOptionPane.showMessageDialog(this, price);
        //}