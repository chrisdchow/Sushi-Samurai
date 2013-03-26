package com.hackamaroo.hw2;

import java.util.*;

import android.util.Log;

public class Collision {
	private double closeness; //closest point on the line segment drawn by the user
	private double score; //score based off of closeness
	
	public Collision(){
		closeness = -1; 
		score = 0; 
	}
	
/*	
	public boolean checkCollisionAY(Point first, Point last, int xc, int yc, int rc){
		double slope = (last.getY() - first.getY()) / (last.getX() - first.getX()); 
		double b = last.getY() - slope * last.getX(); 
		distanceAY =  (Math.abs(slope*xc - yc + b) / Math.sqrt(slope*slope + 1));
		closeness = distance(last.getX(), last.getY(), xc, yc); 
		//be warned that this closeness can be very skewed b/c android doesn't sample EVERY point
		
		if (distanceAY <= rc && closeness < 2*rc){
			score = (1 / (distanceAY + (closeness / 
					distance(last.getX(), last.getY(), first.getX(), first.getY())))); 
			//Log.v("score = ", Double.toString(score));
			return true; 
		}
		score = 0; 
		return false; 
		
		//Trying out newest refactoring of collisions
		//return checkCollisionsVectors(first, last,  xc,  yc, rc); 

	}
*/	
	public double distance(double d, double e, double f, double g){
		return ( Math.sqrt((d-f)*(d-f) + (e - g)*(e-g)));
	}
	
	/**
	 * 
	 * @return score (double)
	 */
	public double getScore(){
		return score; 
	}
	
	public double getCloseness(){
		return closeness; 
	}
	
	public void reset(){
		closeness = -1; 
		score = 0; 
	}
	
    public Point closest_point_on_seg(Point a, Point b, double xc, double yc){
    	Point cPoint = new Point (xc, yc);
        Vector seg_v = new Vector(a, b);
        Vector pt_v = new Vector(a, cPoint);
        if (a.distance(b) <= 0){
            //"Invalid segment length"
        }
        
        Vector seg_v_unit = new Vector(a, b);
        seg_v_unit.makeUnit();
        
        double proj = pt_v.dot(seg_v_unit);
        //System.out.println("proj = " + proj);
        //System.out.println("seg_v.length() = " + seg_v.length());
        if (proj <= 0){
            return a;
        }
        if (proj >= seg_v.magnitude()){
            return b;
        }
        Point closest = seg_v_unit.timesAdd(proj, a);
        //System.out.println("closest x = " + closest.getX());
        //System.out.println("closest y = " + closest.getY());
        return closest;
    }

    public boolean checkCollisionsVectors(Point a, Point b, double xc, double yc, double circ_rad){
        Point closest = closest_point_on_seg(a, b, xc, yc);
        Point circ_pos = new Point(xc, yc);
        closeness = circ_pos.distance(closest);
        score = calcScore(closeness); 
        System.out.println(score);
        if (closeness > 1.0*circ_rad){ 
        	//can change the constant*circ_rad to be more stringent or lenient for diff difficulty
            return false;
        }
        else{
            //Collision!!
        	return true; 
        }
        
    }
    
    private int calcScore(double c){
    	if (c < 1000){
    		//score is based off of a circular target with different regions associated with different points
    		//max score possible is 1000
    		return (int) (1000 - c); 
    	}
    	return 0; 
    }


}

