package com.fileuploaddemo;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FileController {

	@PostMapping("/uploadfile")
	public ModelAndView uploadfile(@RequestParam("myfile") MultipartFile file, HttpServletRequest req) {

		// File path
		String path = req.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources"
				+ File.separator + "image" + File.separator + file.getOriginalFilename();

		System.out.println(path);

		// Ensure directory exists
        File directory = new File(req.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources"
                + File.separator + "image");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        
		try {
			FileOutputStream fout = new FileOutputStream(path);
			byte[] data = file.getBytes();
			fout.write(data);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView errorMv = new ModelAndView("error");
			errorMv.addObject("message", "File upload failed: " + e.getMessage());
			return errorMv;
		}

		// Return ModelAndView
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		mv.addObject("image", file.getOriginalFilename());
		return mv;
	}
}
