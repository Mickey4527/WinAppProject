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
    
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    public double calVat()
    {
        double vat;
        vat = price + (price * 7/100);
        
        return vat;
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