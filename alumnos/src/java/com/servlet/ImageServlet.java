package com.servlet;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Image servlet for serving from absolute path.
 * @author BalusC
 * @link http://balusc.blogspot.com/2007/04/imageservlet.html
 */
@WebServlet("/image/*")
public class ImageServlet extends HttpServlet {

   

    private String imagePath;

   

    public void init() throws ServletException {

     
        this.imagePath = "C:\\Users\\UABC\\Documents\\GitHub\\baratheon\\almacen\\web\\resources\\imagenes";

      
    }

   

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("SE CORRIO EL SERVLET DE IMAGEN");
        
       
        String requestedImage = request.getPathInfo();

        
        if (requestedImage == null) {
         
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

    
        File image = new File(imagePath, URLDecoder.decode(requestedImage, "UTF-8"));

      
        if (!image.exists()) {
          
            response.sendError(HttpServletResponse.SC_NOT_FOUND); 
            return;
        }

       
        String contentType = getServletContext().getMimeType(image.getName());

     
        if (contentType == null || !contentType.startsWith("image")) {
          
            response.sendError(HttpServletResponse.SC_NOT_FOUND); 
            return;
        }

     
        response.reset();
        response.setContentType(contentType);
        response.setHeader("Content-Length", String.valueOf(image.length()));

       
        Files.copy(image.toPath(), response.getOutputStream());
    }

}