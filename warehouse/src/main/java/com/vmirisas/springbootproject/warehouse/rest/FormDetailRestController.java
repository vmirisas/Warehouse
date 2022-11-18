package com.vmirisas.springbootproject.warehouse.rest;

import com.vmirisas.springbootproject.warehouse.dto.FormDetailDTO;
import com.vmirisas.springbootproject.warehouse.service.FormDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formDetail")
public class FormDetailRestController {

    @Autowired
    private FormDetailService formDetailService;

    @GetMapping("")
    public List<FormDetailDTO> findAll() {
        return this.formDetailService.toDtoList(this.formDetailService.findAll());
    }

    @GetMapping("/{formDetailId}")
    public FormDetailDTO getFormDetail(@PathVariable Long formDetailId) {
        return new FormDetailDTO(this.formDetailService.findById(formDetailId));
    }

    @PostMapping("")
    public FormDetailDTO addFormDetail(@RequestBody FormDetailDTO theFormDetail) {
        // also just in case the pass an ID in JSON ... set id to null
        theFormDetail.setFormDetailId(null);
        return new FormDetailDTO(this.formDetailService.save(theFormDetail));
    }

    @PutMapping("")
    public FormDetailDTO updateFormDetailDTO(@RequestBody FormDetailDTO theFormDetail) {
        return new FormDetailDTO(this.formDetailService.save(theFormDetail));
    }

    @DeleteMapping("/{formDetailId}")
    public String deleteFormDetail(@PathVariable Long formDetailId) {
        formDetailService.deleteById(formDetailId);
        return "Deleted Form Detail id - " + formDetailId;
    }
}
