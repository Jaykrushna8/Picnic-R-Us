/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.model;


public class IngredientModel {
  private int id;
  private String name;
  private String description;
  private int perUnitPrice;
  private int manuId;
  private int unitOfMeasureId;
  
   public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
      this.id=id;
    }
    public int getUnitOfMeasureId()
    {
        return unitOfMeasureId;
    }
    public void setUnitOfmeasureId(int id)
    {
      this.unitOfMeasureId=id;
    }
    public int getPerUnitPrice()
    {
        return perUnitPrice;
    }
    public void setPerUnitPrice(int perUnitPrice)
    {
      this.perUnitPrice=perUnitPrice;
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
    public int getManuId()
    {
        return manuId;
    }
    public void setManuId(int manuId)
    {
      this.manuId=manuId;
    }
}
