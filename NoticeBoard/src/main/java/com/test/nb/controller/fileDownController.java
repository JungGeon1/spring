package com.test.nb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class fileDownController {
	
	@RequestMapping("/moveFileDown")
	public String moveFiledown() {
		
		return "nBoard/filewDown";
	} 
	
	
	
	@RequestMapping("/fileDown")
	public String bbsService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // 서버경로
		String path = "/uploadfile";
		// 절대경로
		String saveDirectory  = req.getSession().getServletContext().getRealPath(path);
        String filename = req.getParameter("fileName");
        
        File file = new File(saveDirectory + '\\'+filename);
        
//        resp.setContentType("aplication/octet-stream");        // download 동일
        resp.setContentType("aplication/download");
//        resp.setContentLength((int) file.length());
        resp.setContentLength((int) file.length());
        
        // 모든 브라우저가 지원
        filename = URLEncoder.encode(filename, "utf-8").replace("+", "%20").replace("(", "%28").replace(")", "%29");
        
        // 익스플로러는 지원 안됨
//        originFileName = new String(originFileName.getBytes("utf-8"), "iso-8859-1").replace("+", "%20");
 
        // Content-Disposition: form-data; name="fileName"; filename="파일명"
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\";");
        
        OutputStream out = resp.getOutputStream();
        FileInputStream fis = null;
        
        try {
            int temp;
            fis = new FileInputStream(file);
            while((temp = fis.read()) != -1) {
                out.write(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        
        return null;
    }



}
