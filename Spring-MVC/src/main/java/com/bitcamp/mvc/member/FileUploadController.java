package com.bitcamp.mvc.member;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitcamp.mvc.domain.Report;

@Controller
public class FileUploadController {
		
	String path="/uploadfile";
	
	@RequestMapping("/fileupload/uploadForm")
	public String getForm() {
		return"fileupload/uploadForm";
	}
	//@RequestParam 사용
	@RequestMapping(value = "/fileupload/upload1" ,method = RequestMethod.POST)
	public String upload1(@RequestParam("sno")String sno, 
						  @RequestParam("report")MultipartFile file,
						  Model model,
						  HttpServletRequest request
						) {
		
		model.addAttribute("sno", sno);
		model.addAttribute("fileName", file.getOriginalFilename());
		model.addAttribute("fileSize", file.getSize());
		//파일저장
		String dir=request.getSession().getServletContext().getRealPath(path);
		try {
			if(!file.isEmpty()&&file.getSize()>0) {
			file.transferTo(new File(dir,sno+"_"+file.getOriginalFilename()));
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "fileupload/upload";
	}
	
	//MultipartHttpServletRequest 사용
	@RequestMapping(value = "/fileupload/upload2" ,method = RequestMethod.POST)
	public String upload1(
			MultipartHttpServletRequest request,
			Model model
						) {
		String sno=request.getParameter("sno");
		MultipartFile file=request.getFile("report");
		
		
		
		model.addAttribute("sno", sno);
		model.addAttribute("fileName", file.getOriginalFilename());
		model.addAttribute("fileSize", file.getSize());
		return "fileupload/upload";
	}
	//커맨드객체이용
	@RequestMapping(value = "/fileupload/upload3" ,method = RequestMethod.POST)
	public String upload1(Report report,
			  HttpServletRequest request,
			  Model model) {
		
		String path="/uploadfile";
		String dir= request.getSession().getServletContext().getRealPath(path);
		MultipartFile file= report.getReport();
		System.out.println(file);
		if(!file.isEmpty()&&file.getSize()>0) {
			try {
				file.transferTo(new File(dir,file.getOriginalFilename()));
				model.addAttribute("photo",dir+"\\"+file.getOriginalFilename());
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		System.out.println(dir+"\\"+file.getOriginalFilename());
		
		return "fileupload/upload";
	}
}
