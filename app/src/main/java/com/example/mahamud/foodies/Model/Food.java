package com.example.mahamud.foodies.Model;

public class Food {
    private String Name;

    private String Image;
    private String Description;
    private String Price;

    private String Discount;

    private String MenuId;
    public Food()
    {

    }

    public Food(String name, String image, String description, String price, String discount, String menuId) {
        Name = name;
        Image = image;
        Description = description;
        Price = price;
        Discount = discount;
        MenuId = menuId;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public void setName(String name) {

        Name = name;
    }

    public String getName() {

        return Name;
    }

    public String getImage() {
        return Image;
    }

    public String getDiscount() {
        return Discount;
    }
}

