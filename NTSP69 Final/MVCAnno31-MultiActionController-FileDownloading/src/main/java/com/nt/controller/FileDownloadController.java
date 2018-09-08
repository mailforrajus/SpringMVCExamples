package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.service.ListFilesService;

@Controller
public class FileDownloadController {
	private static final String  DOWNLOAD_PATH="E:/SPRINGUPLOADS";
	//inject service
	@Autowired
	private ListFilesService service;
	
	
	@RequestMapping(value="/listFiles.htm")
	public String  showHomePage(Map<String,Object> map){
		List<String> filesList=null;
		//use service
		filesList=service.getAllFiles();
		//put them in map collection
		map.put("filesList",filesList);
		//return  lvn
		return "show_files";
	}
	
/*	@RequestMapping("/download.htm")
	public  String downloadFile(@RequestParam("fname") String fileName,
			                                           HttpServletRequest req,
			                                            HttpServletResponse res)throws Exception{
		File file=null;
		InputStream is=null;
		OutputStream os=null;
		//Locate the file
		file=new File(DOWNLOAD_PATH+"/"+fileName);
		if(file.exists() && !file.isDirectory()){
			//get file length and make it as response content length
			res.setContentLengthLong(file.length());
			//get the MIME type and make it as responseContent type
			res.setContentType(req.getServletContext().getMimeType(DOWNLOAD_PATH+"/"+fileName));
			//set content-disposition header value having the value "attachment"
			res.setHeader("content-disposition","attachment;fileName="+fileName);
			//create InputStream pointing to the file
			is=new FileInputStream(file);
			//create OutputStream ponting to dest file
			os=res.getOutputStream();
			//copy file content to response obj
			IOUtils.copy(is,os);
			//close stream
			is.close();
			os.close();
		}//if
		return null;
	}//method
*/
	@RequestMapping("/download.htm")
	public  void downloadFile(@RequestParam("fname") String fileName,
			                                           HttpServletRequest req,
			                                            HttpServletResponse res)throws Exception{
		File file=null;
		InputStream is=null;
		OutputStream os=null;
		//Locate the file
		file=new File(DOWNLOAD_PATH+"/"+fileName);
		if(file.exists() && !file.isDirectory()){
			//get file length and make it as response content length
			res.setContentLengthLong(file.length());
			//get the MIME type and make it as responseContent type
			res.setContentType(req.getServletContext().getMimeType(DOWNLOAD_PATH+"/"+fileName));
			//set content-disposition header value having the value "attachment"
			res.setHeader("content-disposition","attachment;fileName="+fileName);
			//create InputStream pointing to the file
			is=new FileInputStream(file);
			//create OutputStream ponting to dest file
			os=res.getOutputStream();
			//copy file content to response obj
			IOUtils.copy(is,os);
			//close stream
			is.close();
			os.close();
		}//if
		return;
	}//method
	
}//class
