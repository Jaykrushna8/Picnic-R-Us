/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.model;

/**
 *
 * @author R.B.Shah
 */
public class CalendarModel {
  public int id;
    public String title;
    public String color;
    public String start;
    public String end;
    
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
      this.id=id;
    }
    public String getColor()
    {
        return color;
    }
    public void setColor(String color)
    {
      this.color=color;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
      this.title=title;
    }
    public String getStart()
    {
        return start;
    }
    public void setStart(String start)
    {
      this.start=start;
    }
    public String getEnd()
    {
        return end;
    }
    public void setEnd(String end)
    {
      this.end=end;
    }
    
}

