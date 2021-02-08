package com.example.exam.service;

import com.example.exam.dto.DeliverInsertDto;
import com.example.exam.dto.DeliverUpdateDto;
import com.example.exam.exceptions.ErrorUpdateException;
import com.example.exam.exceptions.PreferedTimeException;
import com.example.exam.exceptions.DeliverNotFoundException;
import com.example.exam.model.Deliver;
import com.example.exam.repository.DeliverRepository;
import org.springframework.stereotype.Service;



@Service
public class DeliverService {
    private DeliverRepository deliverRepository;

    public DeliverService(DeliverRepository deliverRepository) {
        this.deliverRepository = deliverRepository;
    }

    public Deliver addDeliver(DeliverInsertDto deliverInsertDto){
        Deliver deliver = new Deliver(deliverInsertDto.getContactPersonName(), deliverInsertDto.getContactPersonPhone(), deliverInsertDto.getAddress(), deliverInsertDto.getPreferredTime(), deliverInsertDto.isDelivered());
        return deliverRepository.addDeliver(deliver);
    }

    public Deliver updateDeliver(DeliverUpdateDto deliverUpdateDto){
        if(! deliverRepository.getDeliverById(deliverUpdateDto.getId()).isPresent()){
            throw new DeliverNotFoundException(deliverUpdateDto.getId());
        }
        Deliver deliverBd = deliverRepository.getDeliverById(deliverUpdateDto.getId()).get();
        if(deliverUpdateDto.preferredTime != null)
        if((  !deliverUpdateDto.preferredTime.isBlank()) && (deliverUpdateDto.delivered==true)){
            throw new PreferedTimeException();
        }
        Deliver deliver = new Deliver();
        deliver.id = deliverUpdateDto.getId();
        deliver.contactPersonName=deliverUpdateDto.getContactPersonName();
        deliver.contactPersonPhone=deliverUpdateDto.getContactPersonPhone();
        deliver.address=deliverUpdateDto.getAddress();
        if(deliverUpdateDto.preferredTime==null || deliverUpdateDto.preferredTime.isBlank()) {
            deliver.delivered = deliverUpdateDto.isDelivered();
            deliver.preferredTime = deliverBd.getPreferredTime();
        }else {
            deliver.preferredTime = deliverUpdateDto.getPreferredTime();
            deliver.delivered = false;
        }
        if(!deliverRepository.updateDeliver(deliver)){
           throw new ErrorUpdateException();
        }
        return deliverRepository.getDeliverById(deliver.getId()).get();
    }

}
