/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.model;


public class ManuItemModel {
  private int id;
  private String name;
  private String description;
  private String menuItemType;
  private int menuId;
  private int perHeadCost;
  
   public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
      this.id=id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
      this.name=name;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
      this.description=description;
    }
    public String getMenuItemType()
    {
        return menuItemType;
    }
    public void setMenuItemType(String menuItemType)
    {
      this.menuItemType=menuItemType;
    }
     public int getMenuId()
    {
        return menuId;
    }
    public void setMenuId(int menuId)
    {
      this.menuId=menuId;
    }
     public int getPerHeadCost()
    {
        return perHeadCost;
    }
    public void setPerHeadCost(int perHeadCost)
    {
      this.perHeadCost=perHeadCost;
    }
}
