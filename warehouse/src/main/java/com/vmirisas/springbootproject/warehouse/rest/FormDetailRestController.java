package com.vmirisas.springbootproject.warehouse.rest;

import com.vmirisas.springbootproject.warehouse.dto.FormDetailDTO;
import com.vmirisas.springbootproject.warehouse.service.FormDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FormDetailRestController {

    @Autowired
    private FormDetailService formDetailService;

    @GetMapping("formDetail")
    public List<FormDetailDTO> findAll() {
        return formDetailService.findAll();
    }

    @GetMapping("/formDetail/{formDetailId}")
    public FormDetailDTO getFormDetail(@PathVariable Long formDetailId) {

        FormDetailDTO theFormDetail = formDetailService.findById(formDetailId);

        if(theFormDetail == null) {
            throw new RuntimeException("Form Detail id not found - " + formDetailId);
        }

        return theFormDetail;
    }

    @PostMapping("/formDetail")
    public FormDetailDTO addFormDetail(@RequestBody FormDetailDTO theFormDetail) {
        // also just in case the pass an ID in JSON ... set id to null

        theFormDetail.setId(0L);

        formDetailService.save(theFormDetail);

        return theFormDetail;
    }

    @PutMapping("/formDetail")
    public FormDetailDTO updateFormDetailDTO(@RequestBody FormDetailDTO theFormDetail) {

        formDetailService.save(theFormDetail);

        return theFormDetail;
    }

    @DeleteMapping("/formDetail/{formDetailId}")
    public String deleteFormDetail(@PathVariable Long formDetailId) {

        FormDetailDTO tempFormDetail = formDetailService.findById(formDetailId);

        if (tempFormDetail == null) {

            throw new RuntimeException("Form Detail id not found - " + formDetailId);
        }

        formDetailService.deleteById(formDetailId);

        return "Deleted Transaction Form id - " + formDetailId;
    }
}
