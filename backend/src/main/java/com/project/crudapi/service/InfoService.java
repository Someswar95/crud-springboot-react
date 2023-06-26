package com.project.crudapi.service;

import java.util.List;

import com.project.crudapi.model.Info;

public interface InfoService {
    
    //create
    Info createInfo(Info info);

    //get all info
    List<Info> getAllInfo();

    //update info
    Info updateInfo(Info info, Long infoId);

    //delete info
    Void deleteInfo(Long infoId); 

}
