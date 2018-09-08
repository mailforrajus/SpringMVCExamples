package com.nt.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("filesService")
public class ListFilesServiceImpl implements ListFilesService {
   private static final String  DOWNLOAD_PATH="E:/SPRINGUPLOADS";
   
	@Override
	public List<String> getAllFiles() {
		File downLoadDir=null;
		File[] allFiles=null;
		List<String> onlyFiles=null; 
	   //Locate the directory	
		downLoadDir=new File(DOWNLOAD_PATH);
		if(downLoadDir.exists() && downLoadDir.isDirectory()){
			allFiles=downLoadDir.listFiles();
			onlyFiles=new ArrayList();
			for(File file:allFiles){
				 if(!file.isDirectory())
					onlyFiles.add(file.getName()); 
			}//for
		}//if
		return onlyFiles;
	}//method
}//class
