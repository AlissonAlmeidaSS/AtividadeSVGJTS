package com.ifpb.edu.tarerajtssvg;

/**
 *
 * @author aliss
 */
import com.vividsolutions.jts.geom.Geometry;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;

public class TranformandoSVG {
    
    private static final String NAME_FILE = "Desenho";
    
    public static File GeneratePNG(Geometry a, Geometry b) {
        
        
        try {
            String svg_URI_input = GenerateSVG(a, b).getPath();
            TranscoderInput input_svg_image = new TranscoderInput(svg_URI_input);      
            
            try (OutputStream png_ostream = new FileOutputStream(NAME_FILE + ".png")) {
                TranscoderOutput output_png_image = new TranscoderOutput(png_ostream);
                
                PNGTranscoder my_converter = new PNGTranscoder();
                
                my_converter.transcode(input_svg_image, output_png_image);
                
                png_ostream.flush();
            } 
        } catch (IOException | TranscoderException ex) {
            return null;
        }
        
        return new File(NAME_FILE + ".png");
    }
    
    private static File GenerateSVG(Geometry a, Geometry b) {
        
        StringBuilder builder = new StringBuilder();
        
        builder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        builder.append("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//ENG\" \"http://www.w3c.org/Graphics/SVG/1.1/DTD/svg11.dtd\">");
        
        ViewBox vb = new ViewBox(a, b);
        
        builder.append("<svg xmlns=\"http://www.w3.org/2000/svg\" "
                + "xmlns:xlink=\"http://www.w3.org/1999/xlink\" width=\"293\" height=\"256\"");
        builder.append(" viewBox=\"");
        builder.append(vb.getViewBox());
        builder.append("\">");
        
        builder.append("<desc>Desenho das Coordenadas</desc>");
        builder.append("<title>Desenho</title>");
        
        builder.append("<path d=\"");
        builder.append(ViewBox.getSVG(a));
        builder.append("\" fill=\"red\" fill-opacity=\"1\" />");
        
        builder.append("<path d=\"");
        builder.append(ViewBox.getSVG(b));
        builder.append("\" fill=\"blue\" fill-opacity=\"1\" />");
        
        builder.append("</svg>");
        
        File file = new File(NAME_FILE + ".svg");
        try {
            if (file.exists()) 
                file.delete();
            
            file.createNewFile();
        
            try (BufferedWriter writer = new BufferedWriter(new PrintWriter(new FileWriter(file, true), true))) {
                writer.write(builder.toString());
            }
        } catch (IOException ex) {
        }
        
        
        return file;
    }

}