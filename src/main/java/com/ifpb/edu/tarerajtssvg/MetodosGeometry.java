/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.edu.tarerajtssvg;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;

/**
 *
 * @author aliss
 */
public class MetodosGeometry {
    
    public double areaA(Geometry a) {
        return a.getArea();        
    }
    
    public double areab(Geometry b) {
        return b.getArea();        
    }
    
    public Point centroidA(Geometry a) {
        return a.getCentroid();
    }
    
    public Point centroidB(Geometry b) {
        return b.getCentroid();        
    }
    
    public static boolean containsAB(Geometry a, Geometry b) {
        return a.contains(b);
    }
    
    public static boolean containsBA(Geometry a, Geometry b) {
        return b.contains(a);
    }
    
    public static boolean coversAB(Geometry a, Geometry b) {
        return a.covers(b);
    }
    
    public static boolean coversBA(Geometry a, Geometry b) {
        return b.covers(a);
    }
    
    public static boolean overlapsAB(Geometry a, Geometry b) {
        return a.overlaps(b);
    }
    
    public static boolean overlapsBA(Geometry a, Geometry b) {
        return b.overlaps(a);
    }
    
    public static boolean touchesAB(Geometry a, Geometry b) {
        return a.touches(b);
    }
    
    public static boolean touchesBA(Geometry a, Geometry b) {
        return b.touches(a);
    }
    
    public static boolean withinAB(Geometry a, Geometry b) {
        return a.within(b);
    }
    
    public static boolean withinBA(Geometry a, Geometry b) {
        return b.within(a);
    }
}