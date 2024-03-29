/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.edu.tarerajtssvg;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;

/**
 *
 * @author aliss
 */
public class ViewBox {
    
    private final Geometry geom1;
    private final Geometry geom2;

    public ViewBox(Geometry geom1, Geometry geom2) {
        this.geom1 = geom1;
        this.geom2 = geom2;
    }
    
    public String getViewBox() {
        Geometry uniao = geom1.union(geom2);
        Geometry envelope = uniao.getEnvelope();
        
        StringBuilder builder = new StringBuilder();
        
        builder.append(getXMin(envelope));
        builder.append(" ");
        builder.append(getYMin(envelope));
        builder.append(" ");
        builder.append(getXMax(envelope) - getXMin(envelope));
        builder.append(" ");
        builder.append(getYMax(envelope) - getYMin(envelope));
        builder.append(" ");
        
        return builder.toString();
    }


    private double getXMin(Geometry envelope) {
        Coordinate coordenadas[] = envelope.getCoordinates();
        
        double xMin = coordenadas[0].x;
        
        for(Coordinate c: coordenadas)
            if (c.x < xMin)
                xMin = c.x;
        
        return xMin;
    }
    
    private double getYMin(Geometry envelope) {
        Coordinate coordenadas[] = envelope.getCoordinates();
        
        double yMin = coordenadas[0].y;
        
        for(Coordinate c: coordenadas)
            if (c.y < yMin)
                yMin = c.y;
        
        return yMin;
    }
    
    private double getXMax(Geometry envelope) {
        Coordinate coordenadas[] = envelope.getCoordinates();
        
        double xMax = coordenadas[0].x;
        
        for(Coordinate c: coordenadas)
            if (c.x > xMax)
                xMax = c.x;
        
        return xMax;
    }
    
    private double getYMax(Geometry envelope) {
        Coordinate coordenadas[] = envelope.getCoordinates();
        
        double yMax = coordenadas[0].y;
        
        for(Coordinate c: coordenadas)
            if (c.y > yMax)
                yMax = c.y;
        
        return yMax;
    }
    
      public static String getSVG(Geometry geometria) {

        StringBuilder builder = new StringBuilder();

        Coordinate[] coordenadas = geometria.getCoordinates();

        builder.append("M");
        builder.append(" ");
        builder.append(coordenadas[0].x);
        builder.append(" ");
        builder.append(coordenadas[0].y);

        builder.append(" ");

        for (Coordinate c : coordenadas) {
            builder.append("L");
            builder.append(" ");
            builder.append((Double) c.x);
            builder.append(" ");
            builder.append((Double) c.y);
            builder.append(" ");
        }

        builder.append("Z");

        return builder.toString();
    }
} 