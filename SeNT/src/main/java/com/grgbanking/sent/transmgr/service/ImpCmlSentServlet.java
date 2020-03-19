package com.grgbanking.sent.transmgr.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grgbanking.sent.utils.ResultBMP;




/**
 * Servlet implementation class BMPServlet
 */
public class ImpCmlSentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImpCmlSentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	{
		
		 
		try {
		response.setContentType("image/jpg");
	
		String fileNameString =request.getParameter("urlName");
		int serialSnseq=Integer.parseInt(request.getParameter("serialSnseq"));
		//int  index =Integer.parseInt(request.getParameter("index"));
/*		int index=12;*/
		if(! new File(fileNameString).exists()){
			BufferedImage  img = new BufferedImage(360, 60, BufferedImage.TYPE_INT_ARGB);
		    Graphics g = img.getGraphics();
		    Font f1 = new Font("TimesRoman",Font.BOLD,40);
		    g.setFont(f1);
		    g.setColor(Color.WHITE);
		    g.drawString("NO File to Number", 20, 50);
		  g.dispose();
			/*Graphics2D g2d = img.createGraphics();  
			// 画图 
			g2d.setColor(new Color(255,0,0));  
			g2d.setStroke(new BasicStroke(1)); 
;
			g2d.drawString("No File to Number", 20, 50);
			g2d.dr
			g2d.dispose();*/
			ImageIO.write(img, "jpg", response.getOutputStream());
			
		}else{
			File f= new File("t1.bmp");
			
			ResultBMP  bmp = new ResultBMP(new FileInputStream(fileNameString), new FileOutputStream(f), serialSnseq);
				ImageIO.write(ImageIO.read(f), "jpg", response.getOutputStream());
				f.delete();	
		
			
		}
		
	
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}

		System.out.println("now image");
	
		
	}

}
