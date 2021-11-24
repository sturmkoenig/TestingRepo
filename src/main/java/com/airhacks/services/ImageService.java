package com.airhacks.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

@Path("image")
public class ImageService {

	

	@GET
	@Path("wallpaper")
	@Produces("image/png")
	public Response getFullImage() {

		BufferedImage image = null;

		try {
			image = ImageIO.read(new File("C:\\Users\\llauer\\wallpaperflare.com_wallpaper.jpg"));
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ImageIO.write(image, "png", byteArrayOutputStream);
			byte[] imageData = byteArrayOutputStream.toByteArray();
			return Response.ok(imageData).build();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return Response.serverError().build();
	}
	

}
