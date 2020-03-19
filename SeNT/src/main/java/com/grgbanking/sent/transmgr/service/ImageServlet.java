package com.grgbanking.sent.transmgr.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grgbanking.sent.utils.StreamUtil;

/**
 * @author yt
 * 
 */
public class ImageServlet extends HttpServlet
{

	private static final long serialVersionUID = 8731273867445599979L;
	private static Logger logger = LoggerFactory.getLogger(ImageServlet.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("image/jpg");
		String urlName = req.getParameter("urlName");
		URLConnection con = null;
		if( urlName.startsWith("http:") )
		{
			try
			{
				URL u = new URL(urlName);
				con = u.openConnection();
				BufferedImage image = ImageIO.read(con.getInputStream());
				ImageIO.write(image, "jpg", response.getOutputStream());
			}
			catch( IOException e )
			{
				logger.error("Image unavailable by http["+urlName+"].");
				BufferedImage img = new BufferedImage(320, 32, BufferedImage.TYPE_INT_ARGB);
				Graphics g = img.getGraphics();
				Font f1 = new Font("TimesRoman", Font.PLAIN, 16);
				g.setFont(f1);
				g.setColor(Color.WHITE);
				g.drawString("Image not found.", 5, 16);
				g.dispose();
				ImageIO.write(img, "jpg", response.getOutputStream());
				logger.error("", e);
			}
		}
		// 从服务器的本地取图片
		else
		{
			File file = new File(urlName);
			FileInputStream fis = null;
			try
			{
				if( new File(urlName).exists() )
				{
					fis = new FileInputStream(file);
					BufferedImage image = ImageIO.read(fis);
					ImageIO.write(image, "jpg", response.getOutputStream());
				}
				else
				{
					logger.error("Image file not found. path=["+urlName+"]");
					BufferedImage img = new BufferedImage(320, 32, BufferedImage.TYPE_INT_ARGB);
					Graphics g = img.getGraphics();
					Font f1 = new Font("TimesRoman", Font.PLAIN, 16);
					g.setFont(f1);
					g.setColor(Color.WHITE);
					g.drawString("Image file not found.", 5, 16);
					g.dispose();
					ImageIO.write(img, "jpg", response.getOutputStream());
				}
			}
			catch( IOException e )
			{
				logger.error("", e);
			}
			finally 
			{
				StreamUtil.close(fis);
			}
		}
	}
}
