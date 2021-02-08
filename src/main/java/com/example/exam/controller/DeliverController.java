package com.example.exam.controller;

import com.example.exam.dto.DeliverInsertDto;
import com.example.exam.dto.DeliverUpdateDto;
import com.example.exam.model.Deliver;
import com.example.exam.service.DeliverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/deliver")
public class DeliverController {
    @Autowired
    private DeliverService deliverService;

    @PostMapping("/add")
    public Deliver addDeliver(@RequestBody @Valid DeliverInsertDto deliverInsertDto){
        return deliverService.addDeliver(deliverInsertDto);
    }

    @PutMapping("/update")
    public Deliver updateDeliver(@RequestBody @Valid DeliverUpdateDto deliverUpdateDto){
        return deliverService.updateDeliver(deliverUpdateDto);
    }
}
