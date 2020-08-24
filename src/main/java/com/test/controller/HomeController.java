package com.test.controller;


import com.test.Models.Items;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;


import java.sql.*;
import java.util.ArrayList;





@Controller
public class HomeController {




   @RequestMapping("/")
           public ModelAndView welcomeMethod()
   {
       return new ModelAndView("welcome", "message", "Welcome to Imperial Coffee!");

   }

    //Method to get an arraylist of all items at Imperial Coffee.
    public ArrayList<Items> getItems()
    {

        String selectItems = "select ProductName,Description,Quantity,Price,Itemid,Types from items";
        String url = "jdbc:mysql://localhost:3306/coffeeshopdb";
        String userName = "root";
        String password = "access.passWord";
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection c = DriverManager.getConnection(url,userName,password);

            Statement st = c.createStatement();

            ResultSet rs =st.executeQuery(selectItems);
            ArrayList<Items> itemList = new ArrayList<Items>();

            while (rs.next())
            {
                String product = rs.getString(1);
                String describe = rs.getString(2);
                String quantity = rs.getString(3);
                String price = rs.getString(4);
                String id = rs.getString(5);
                String type = rs.getString(6);
                Items temp = new Items(product,describe,quantity,price,id,type);

                itemList.add(temp);

            }
            return itemList;
        }
        catch(Exception ex)
        {
            return null;
        }


    }

    public ArrayList<Items> getItem(String prodName)
    {

        String selectItem = "select * from items where ProductName = '"+prodName+"'";
        String url = "jdbc:mysql://localhost:3306/coffeeshopdb";
        String userName = "root";
        String password = "access.passWord";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection c = DriverManager.getConnection(url,userName,password);

            Statement st = c.createStatement();



            ResultSet rs = st.executeQuery(selectItem);


            ArrayList<Items> itemList = new ArrayList<Items>();


            while(rs.next()) {

                String product = rs.getString(1);
                String describe = rs.getString(2);
                String quantity = rs.getString(3);
                String price = rs.getString(4);
                String id = rs.getString(5);
                String type = rs.getString(6);
                Items itemToEdit = new Items(product, describe, quantity, price, id, type);
                itemList.add(itemToEdit);


            }





            st.close();
            c.close();
            return itemList;
        }
        catch(Exception ex)
        {

            System.out.println("Error message to test");
            return null;
        }


    }

   @RequestMapping("saveEdit")
   //Method to save changes made by an admin to the database.
   public ModelAndView updateFormMethod(@RequestParam("name") String name,@RequestParam("describe") String description, @RequestParam("qty") String quantity,
                                         @RequestParam("price") String price,@RequestParam("id") String Id) throws SQLException, ClassNotFoundException {


        try {
            String url = "jdbc:mysql://localhost:3306/coffeeshopdb";
            String username = "root";
            String password = "access.passWord";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement pst = con.prepareStatement("update items set ProductName = ?, Description = ?, Quantity = ?, Price = ? where Itemid = ?");

            pst.setString(1, name);
            pst.setString(2, description);
            pst.setString(3, quantity);
            pst.setString(4, price);
            pst.setString(5, Id);

            pst.executeUpdate();

            pst.close();
            con.close();

        }
        catch (Exception ex){
            return null;
        }

        return new ModelAndView("ItemAdmin", "displayItems",getItems());

    }



    @RequestMapping("processForm")
    //Method to register new users and put their info in the database.
    public ModelAndView processFormMethod(@RequestParam("Fname") String fiName, @RequestParam("Lname")
            String lastName,@RequestParam("gender") String sex, @RequestParam("eMail") String email, @RequestParam("phoneNum") String num, @RequestParam("pWord")
                                          String psword, @RequestParam("confirmPword") String passwordConfirm, @RequestParam("Address") String Address, @RequestParam("Zip") String zip) throws ClassNotFoundException, SQLException {


        String url = "jdbc:mysql://localhost:3306/coffeeshopdb";
        String username = "root";
        String password = "access.passWord";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement pst = con.prepareStatement("insert into users(FirstName, LastName, Gender, Email, PhoneNumber, UserPassword, ConfirmPassword, Address, Zip)" + "values(?,?,?,?,?,?,?,?,?)");

        pst.setString(1, fiName);
        pst.setString(2, lastName);
        pst.setString(3, sex);
        pst.setString(4, email);
        pst.setString(5, num);
        pst.setString(6, psword);
        pst.setString(7,passwordConfirm);
        pst.setString(8,Address);
        pst.setString(9,zip);

        pst.executeUpdate();
        pst.close();
        con.close();




        return new ModelAndView("addUser", "showName", fiName);

    }

    @RequestMapping("processPhoto")
    public void processThePhoto(@RequestParam("photo") CommonsMultipartFile photoData){
        System.out.println(photoData.getContentType());
    }

   @RequestMapping("registrationForm")

    public ModelAndView registerMethod() {

       return new ModelAndView("registrationForm", "", "");
   }

   @RequestMapping("addUser")
   public ModelAndView showNameMethod(@RequestParam("Fname") String firstName)
   {
       return new ModelAndView("addUser", "showName", firstName);


   }

    @RequestMapping("ItemAdmin")
    public ModelAndView showAdmin()
    {
        ArrayList<Items> itemList = getItems();
        return new ModelAndView("ItemAdmin", "displayItems", itemList);


    }
    @RequestMapping("delItem")
    //Method to delete an item from the database.
    public ModelAndView deleteAdmin(@RequestParam("id") String itemToRemove) throws SQLException {

        try {
            String url = "jdbc:mysql://localhost:3306/coffeeshopdb";
            String username = "root";
            String password = "access.passWord";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement pst = con.prepareStatement("delete from items where ProductName = ?");

            pst.setString(1, itemToRemove);

            pst.executeUpdate();
            pst.close();
            con.close();
        }

        catch (Exception ex) {
                return null;
        }
            return new ModelAndView("ItemAdmin", "displayItems", getItems());

    }

    @RequestMapping("editItem")
    //Method to retrieve the row to be edited and populate the view with the info from that row in the database.
    public String editAdmin(@RequestParam("id") String itemToEdit, Model model){

       ArrayList<Items> edits = getItem(itemToEdit);
       String one = edits.get(0).getProductName();
       String two = edits.get(0).getDescription();
       String three = edits.get(0).getQuantity();
       String four = edits.get(0).getPrice();
       String five = edits.get(0).getItemid();


       model.addAttribute("products", one);
       model.addAttribute("descs", two);
       model.addAttribute("qtys", three);
       model.addAttribute("prices", four);
       model.addAttribute("itemID", five);

        return "toEdit";

    }

    @RequestMapping("addItem")
    public ModelAndView addAnItem(){
        return new ModelAndView("addNewItem","","");
    }

    @RequestMapping("add")
    //Method to add a new item to the database.
    public ModelAndView addANewItem(@RequestParam("name")String name, @RequestParam("description") String desc,
                                   @RequestParam("qty") String quant, @RequestParam("price") String price, @RequestParam("type") String type) throws SQLException, ClassNotFoundException {

        try {
            String url = "jdbc:mysql://localhost:3306/coffeeshopdb";
            String username = "root";
            String password = "access.passWord";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement pst = con.prepareStatement("insert into items(ProductName,Description,Quantity,Price,Types)" + "values(?,?,?,?,?)");

            pst.setString(1, name);
            pst.setString(2, desc);
            pst.setString(3, quant);
            pst.setString(4, price);
            pst.setString(5,type);



            pst.executeUpdate();

            pst.close();
            con.close();

        }
        catch (Exception ex){
            System.out.println("reached this point");
            return null;

        }

        return new ModelAndView("ItemAdmin", "displayItems",getItems());



    }



   }

