package com.nt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.nt.command.FileUploadCommand;

@Controller
public class FileUploadController {
	private static final String UPLOAD_PATH="E:/SPRINGUPLOADS";

	@RequestMapping(method=RequestMethod.GET,value="/upload.htm")
	public  String showForm(@ModelAttribute("uplCmd") FileUploadCommand cmd){
		 return "file_upload";
	 }
	
	
	/*@RequestMapping(method=RequestMethod.POST,value="/upload.htm")
	public  String upload(Map<String,String> map,
			                                     @ModelAttribute("uplCmd") FileUploadCommand cmd)throws Exception{
		 File uploadDir=null;
		 MultipartFile file1=null,file2=null;
		 String fileName1=null,fileName2=null;
		 InputStream is1=null,is2=null;
		 OutputStream os1=null,os2=null;
		 byte[] buffer=null;
		 int bytesRead=0;
		 
		 
		 //Locate folder on server machine file system 
		 uploadDir=new File(UPLOAD_PATH);
		 //check wheather directory is existed or not
		 if(!uploadDir.exists())
			   uploadDir.mkdir();
		 //get  uploaded file through Command class object
		file1=cmd.getFile1();
		file2=cmd.getFile2();
		//get names of the uploaded files
		fileName1=file1.getOriginalFilename();
		fileName2=file2.getOriginalFilename();
		//create InputStream pointing to the uploaded files
		is1=file1.getInputStream();
		is2=file2.getInputStream();
		//create OutputStream pointing to dest files
		os1=new FileOutputStream(UPLOAD_PATH+"/"+fileName1);
		os2=new FileOutputStream(UPLOAD_PATH+"/"+fileName2);
		//complete file uploading1
		buffer=new byte[4096];
		while((bytesRead=is1.read(buffer))!=-1){
			os1.write(buffer, 0, bytesRead);
		}
		
		//complete file uploading2
		buffer=new byte[4096];
		while((bytesRead=is2.read(buffer))!=-1){
			os2.write(buffer, 0, bytesRead);
		}
		
		//close streams
		is1.close(); is2.close();
		os1.close(); os2.close();
		//add the names of the uploaded files to  Map collection
		map.put("fname1",fileName1);
		map.put("fname2",fileName2);
		
		return "upload_result";
	}//method
*/		
	
	@RequestMapping(method=RequestMethod.POST,value="/upload.htm")
	public  String upload(Map<String,String> map,
			                                     @ModelAttribute("uplCmd") FileUploadCommand cmd)throws Exception{
		 File uploadDir=null;
		 MultipartFile file1=null,file2=null;
		 String fileName1=null,fileName2=null;
		 InputStream is1=null,is2=null;
		 OutputStream os1=null,os2=null;
		 //Locate folder on server machine file system 
		 uploadDir=new File(UPLOAD_PATH);
		 //check wheather directory is existed or not
		 if(!uploadDir.exists())
			   uploadDir.mkdir();
		 //get  uploaded file through Command class object
		file1=cmd.getFile1();
		file2=cmd.getFile2();
		//get names of the uploaded files
		fileName1=file1.getOriginalFilename();
		fileName2=file2.getOriginalFilename();
		//create InputStream pointing to the uploaded files
		is1=file1.getInputStream();
		is2=file2.getInputStream();
		//create OutputStream pointing to dest files
		os1=new FileOutputStream(UPLOAD_PATH+"/"+fileName1);
		os2=new FileOutputStream(UPLOAD_PATH+"/"+fileName2);
		//complete file uploading1
	     IOUtils.copy(is1,os1);
		//complete file uploading2
	     IOUtils.copy(is2,os2);
		
		//close streams
		is1.close(); is2.close();
		os1.close(); os2.close();
		//add the names of the uploaded files to  Map collection
		map.put("fname1",fileName1);
		map.put("fname2",fileName2);
		
		return "upload_result";
	}//method
	
	
	
}//class
