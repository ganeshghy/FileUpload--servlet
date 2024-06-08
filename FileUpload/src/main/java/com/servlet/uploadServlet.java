package com.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.classes.uploadJdbc;

@MultipartConfig
public class uploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	uploadJdbc upload = new uploadJdbc();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part p = request.getPart("file");
		System.out.println(p.getContentType());
		
		InputStream in = p.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		StringBuilder content =  new StringBuilder();
		while((line = reader.readLine()) != null) {
			content.append(line);
		}
		request.setAttribute("content", content.toString());
		RequestDispatcher rd = request.getRequestDispatcher("/upload.jsp");
		rd.forward(request, response);
		
//		String fileName = p.getSubmittedFileName();
//		
//		boolean result = upload.uploadFileName(fileName);
//		if(result) {
//			
////			String path = getServletContext().getRealPath("") + File.separator + "imgs";
//			String path = "C:\\Users\\GANESH\\eclipse-java\\FileUpload\\src\\main\\webapp\\imgs";
//			File file = new File(path);
//
//			// Check if the directory exists, if not, create it
//			if (!file.exists()) {
//			    if (file.mkdirs()) {
//			        System.out.println("Directory created successfully.");
//			    } else {
//			        System.err.println("Failed to create directory.");
//			    }
//			}
//
//			// Check if the directory is writable
//			if (file.canWrite()) {
//			    // Assuming 'p' is a PrintWriter or similar object
//			    p.write(path + File.separator + fileName); // Writing to the file
//			    
//			    // Confirming the path where the file is being written
//			    System.out.println("File written to: " + path + File.separator + fileName);
//			} else {
//			    System.err.println("Directory is not writable."); // Error message if directory is not writable
//			}
//
//	}
	}
}
