package com.project.crudapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.crudapi.model.Info;
import com.project.crudapi.payload.ApiResponse;
import com.project.crudapi.service.InfoService;

@RestController
@CrossOrigin("*")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @PostMapping("/api/crud/save")
    public ResponseEntity<Info> createInfo(@Valid @RequestBody Info info) {

        Info createInfo = this.infoService.createInfo(info);
        return new ResponseEntity<Info>(createInfo, HttpStatus.CREATED);
    }

    @GetMapping("/api/crud/")
    public ResponseEntity<List<Info>> getAllInfo() {
        List<Info> allInfo = this.infoService.getAllInfo();
        return new ResponseEntity<List<Info>>(allInfo, HttpStatus.OK);
    }

    @PutMapping("/api/crud/update/{infoId}")
    public ResponseEntity<Info> updateInfo(@RequestBody Info info, @PathVariable("infoId") Long infoId) {
        Info updateInfo = this.infoService.updateInfo(info, infoId);
        return new ResponseEntity<Info>(updateInfo, HttpStatus.OK);
    }

    @DeleteMapping("/api/crud/delete/{infoId}")
    public ResponseEntity<ApiResponse> deleteInfo(@PathVariable("infoId") Long infoId) {
        this.infoService.deleteInfo(infoId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Info deleted successfully !!", true), HttpStatus.OK);
    }
}
