package com.project.crudapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.crudapi.exception.ResourceNotFoundException;
import com.project.crudapi.model.Info;
import com.project.crudapi.repository.InfoRepo;
import com.project.crudapi.service.InfoService;

@Service
public class InfoServiceImpl implements InfoService{

    @Autowired
    private InfoRepo infoRepo;

    @Override
    public Info createInfo(Info info) {
        Info savedInfo = this.infoRepo.save(info);
        return savedInfo;
    }

    @Override
    public List<Info> getAllInfo() {
        List<Info> infoes = this.infoRepo.findAll();
        return infoes;
    }

    @Override
    public Info updateInfo(Info info, Long infoId) {
        Info infos = this.infoRepo.findById(infoId).orElseThrow(()-> new ResourceNotFoundException("Info","Info Id",infoId));
        infos.setName(info.getName());
        infos.setEmail(info.getEmail());
        Info saveInfo = this.infoRepo.save(infos);
        return saveInfo;
    }

    @Override
    public Void deleteInfo(Long infoId) {
        Info info = this.infoRepo.findById(infoId).orElseThrow(()-> new ResourceNotFoundException("Info","Info Id",infoId));
        this.infoRepo.delete(info);
        return null;
    }

    

    
}
