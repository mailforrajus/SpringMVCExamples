package com.nt.service;

import javax.annotation.Resource;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.external.ICCScoreComp;

@Service("cbService")
public class CrickBuzzFindScoreServiceImpl implements CrickBuzzFindScoreService {
    @Autowired
	private  ICCScoreComp extComp;
    
    public CrickBuzzFindScoreServiceImpl() {
		System.out.println("CBFSSI:0-param constructor");
	}
	

	@Override
	public String findScore(int mid) {
		return extComp.getScore(mid);
	}

}
