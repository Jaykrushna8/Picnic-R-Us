
package com.pru.model;


public class ItemIngredients {
   
    private int id;
    private int itemId;
    private int ingredientId;
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
      this.id=id;
    }
    public int getItemId()
    {
        return itemId;
    }
    public void setItemId(int itemId)
    {
      this.itemId=itemId;
    }
     public int getIngredientId()
    {
        return ingredientId;
    }
    public void setMenuItemId(int ingredientId)
    {
      this.ingredientId=ingredientId;
    }
}
