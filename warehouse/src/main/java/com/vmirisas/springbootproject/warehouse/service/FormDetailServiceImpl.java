package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.FormDetailDTO;
import com.vmirisas.springbootproject.warehouse.entity.FormDetail;
import com.vmirisas.springbootproject.warehouse.repository.FormDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormDetailServiceImpl implements FormDetailService{
    @Autowired
    private FormDetailRepository formDetailRepository;

    @Override
    public List<FormDetail> findAll() {
        return formDetailRepository.findAll();
    }

    @Override
    public FormDetail findById(Long theId) {
       return this.formDetailRepository.findById(theId).orElseThrow(() -> new RuntimeException("Did not find Form Detail with id " + theId));
    }

    @Override
    public FormDetail save(FormDetailDTO theFormDetail) {
        return this.formDetailRepository.save(new FormDetail(theFormDetail));
    }

//    @Override
//    public FormDetail save(FormDetail formDetail) {
//        formDetailRepository.save(formDetail);
//    }

    @Override
    public void deleteById(Long theId) {
        FormDetail formDetail = this.formDetailRepository.findById(theId).orElseThrow(() -> new RuntimeException("Did not find Form Detail with id " + theId));
        formDetailRepository.deleteById(theId);
    }

    @Override
    public List<FormDetailDTO> toDtoList(List<FormDetail> details) {
        List<FormDetailDTO> list = new ArrayList<>();
        for (FormDetail d : details) {
            list.add(new FormDetailDTO(d));
        }
        return list;
    }


}
