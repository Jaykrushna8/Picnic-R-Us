/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.model;


public class UnitOfMeasureModel {
  private int id;
  private String name;
  private String description;
  private String icon;
  
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
    public String getIcon()
    {
        return icon;
    }
    public void setIcon(String icon)
    {
      this.icon=icon;
    }
}
