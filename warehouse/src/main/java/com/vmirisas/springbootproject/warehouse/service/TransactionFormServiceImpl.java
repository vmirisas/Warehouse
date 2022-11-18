package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.FormDetailDTO;
import com.vmirisas.springbootproject.warehouse.dto.StockDTO;
import com.vmirisas.springbootproject.warehouse.dto.TransactionFormDTO;
import com.vmirisas.springbootproject.warehouse.entity.*;
import com.vmirisas.springbootproject.warehouse.entity.enums.FormType;
import com.vmirisas.springbootproject.warehouse.repository.TransactionFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionFormServiceImpl implements TransactionFormService{

    @Autowired
    private TransactionFormRepository transactionFormRepository;

    @Autowired
    private ProductService productService;
    @Autowired
    private ShelfService shelfService;
    @Autowired
    private StockService stockService;

//    @Override
//    public List<TransactionFormDTO> findAll() {
//
//        List<TransactionForm> transactionFormList = transactionFormRepository.findAll();
//        List<TransactionFormDTO> transactionFormDTOList = new ArrayList<>();
//
//        for (TransactionForm form: transactionFormList) {
//
//            TransactionFormDTO transactionFormDTO = new TransactionFormDTO();
//
//            transactionFormDTO.setTransactionFormId(form.getTransactionFormId());
//            transactionFormDTO.setType(form.getType());
//            transactionFormDTO.setDate(form.getDate());
//            transactionFormDTO.setDescription(form.getDescription());
////            transactionFormDTO.setFormDetailList(form.getFormDetailList());
//
//            List<FormDetail> formDetailList = form.getFormDetailList();
//            List<FormDetailDTO> formDetailDTOList = new ArrayList<>();
//
//            for (FormDetail detail:formDetailList) {
//
//                FormDetailDTO formDetailDTO = new FormDetailDTO(detail);
//
//                formDetailDTO.setFormDetailId(detail.getFormDetailId());
//                formDetailDTO.setTransactionFormId(form.getTransactionFormId());
//                formDetailDTO.setShelfCode(detail.getShelf().getShelfCode());
//                formDetailDTO.setBarcode(detail.getProduct().getBarcode());
//                formDetailDTO.setQuantity(detail.getQuantity());
//
//                formDetailDTOList.add(formDetailDTO);
//            }
//            transactionFormDTO.setFormDetailList(formDetailDTOList);
//            transactionFormDTOList.add(transactionFormDTO);
//        }
//
////        for(TransactionForm form:transactionFormList) {
////            transactionFormDTOList.add(new TransactionFormDTO(form));
////        }
//
//        return transactionFormDTOList;
//    }

    @Override
    public List<TransactionForm> findAll() {
        return transactionFormRepository.findAll();
    }

//    @Override
//    public TransactionFormDTO findById(Long theId) {
//        Optional<TransactionForm> result = transactionFormRepository.findById(theId);
//
//        TransactionFormDTO theTransactionForm;
//
//        if(result.isPresent()) {
//            theTransactionForm = new TransactionFormDTO(result.get());
//
//        } else {
//            throw new RuntimeException("Did not find transaction form id - " + theId);
//        }
//
//        return theTransactionForm;
//    }

    @Override
    public TransactionForm findById(Long theId) {
        return this.transactionFormRepository.findById(theId).orElseThrow(() -> new RuntimeException("Transaction form with id '" + theId + "' not found"));
    }

//    @Override
//    public void save(TransactionFormDTO theTransactionForm) {
//
//        TransactionForm transactionForm = new TransactionForm(theTransactionForm);
//
////        transactionForm.setTransactionFormId(theTransactionForm.getTransactionFormId());
////        transactionForm.setTransactionFormId(null);
//        transactionForm.setDate(new Date());
//
//        List<FormDetail> formDetailList = new ArrayList<>();
//
//        for (FormDetailDTO detailDTO : theTransactionForm.getFormDetailList()) {
//
//            FormDetail detail = new FormDetail();
//
////            detail.setTransactionFormId(transactionForm.getTransactionFormId());
//
//            Product product = productService.findProductByBarcode(detailDTO.getBarcode());
//            detail.setProduct(product);
//
//            Shelf shelf = shelfService.findShelfByCode(detailDTO.getShelfCode());
//            detail.setShelf(shelf);
//
//            detail.setQuantity(detailDTO.getQuantity());
//
//            detail.setTransactionForm(transactionForm);
//
//            if (transactionForm.getType().equalsIgnoreCase("import"))
//            {
//
//                Stock stock = new Stock(stockService.getStockToImport(product.getBarcode(), shelf.getShelfCode()));
//
//                if (stock.getStockId() != null ) {
//
//                    int stockQuantity = stock.getQuantity();
//                    int importedQuantity = detailDTO.getQuantity();
//
//                    stock.setStockId(0L);
//                    stock.setShelf(shelf);
//                    stock.setProduct(product);
//                    stock.setQuantity(stockQuantity + importedQuantity);
//                    stock.setDate(new Date());
//
//                } else {
//
//                    stock.setStockId(0L);
//                    stock.setShelf(shelf);
//                    stock.setProduct(product);
//                    stock.setQuantity(detailDTO.getQuantity());
//                    stock.setDate(new Date());
//
//                }
//
//                stockService.save(stock);
//
//                formDetailList.add(detail);
//
//            } else if (transactionForm.getType().equalsIgnoreCase("export")) {
//
//                int currentQuantity = stockService.getStockToExport(product.getBarcode(), shelf.getShelfCode());
//                int exportedQuantity = detail.getQuantity();
//
//                if (exportedQuantity > currentQuantity) {
//                    throw new RuntimeException("The exported quantity is greater than the current stock");
//                }
//
//                Stock stock = new Stock();
//                stock.setStockId(0L);
//                stock.setShelf(shelf);
//                stock.setProduct(product);
//                stock.setDate(new Date());
//                stock.setQuantity(currentQuantity - exportedQuantity);
//
//                stockService.save(stock);
//
//                formDetailList.add(detail);
//
//            } else {
//
//                throw new RuntimeException("Did not find transaction type - " + transactionForm.getType());
//
//            }
//        }
//
//        transactionForm.setFormDetailList(formDetailList);
//        transactionFormRepository.save(transactionForm);
//
////        for(FormDetail formDetail: formDetailList){
////            formDetail.setTransactionFormId(transactionFormRepository.getLastTransactionFormId());
////            formDetailService.save(formDetail);
////        }
//
//    }

    @Override
    public TransactionForm save(TransactionFormDTO theForm) {
        return transactionFormRepository.save(toEntity(theForm));

//        List<FormDetail> formDetailList = new ArrayList<>();
//        for (FormDetailDTO detailDTO : theTransactionForm.getFormDetailList()) {
//
//        }
//        return transactionFormRepository.save(new TransactionForm(theForm));
    }

    @Override
    public void deleteById(Long theId) {
        TransactionForm form = this.transactionFormRepository.findById(theId).orElseThrow(() -> new RuntimeException("Transaction form with id '" + theId + "' not found"));
        transactionFormRepository.delete(form);

        //transactionFormRepository.deleteById(theId);
    }

//    @Override
//    public Long getLastTransactionFormId() {
//        Optional<Long> formId = Optional.ofNullable(transactionFormRepository.getLastTransactionFormId());
//
//        Long transactionFormId = 0L;
//
//        if (formId.isPresent()) {
//           transactionFormId = formId.get();
//        } else {
//            throw new RuntimeException("Did not find transaction Form id - " + transactionFormId);
//        }
//
//        return transactionFormId;
//    }

    @Override
    public List<TransactionFormDTO> toDtoList(List<TransactionForm> forms) {
        List<TransactionFormDTO> list = new ArrayList<>();
        for (TransactionForm f : forms) {
            list.add(new TransactionFormDTO(f));
        }
        return list;
    }

    @Override
    public TransactionForm toEntity(TransactionFormDTO transactionFormDTO) {
        TransactionForm form = new TransactionForm(transactionFormDTO);

        List <FormDetail> formDetailList = new ArrayList<>();

        for (FormDetailDTO formDetailDTO : transactionFormDTO.getFormDetailList()){
            FormDetail detail = new FormDetail();

            detail.setTransactionForm(form);

            Product product = this.productService.findProductByBarcode(formDetailDTO.getBarcode());
            detail.setProduct(product);

            Shelf shelf = this.shelfService.findShelfByCode(formDetailDTO.getShelfCode());
            detail.setShelf(shelf);

            detail.setQuantity(formDetailDTO.getQuantity());

            formDetailList.add(detail);

            if (form.getType() == FormType.IMPORT){

                Stock stockExisting = new Stock(stockService.getStockToImport(product.getBarcode(), shelf.getShelfCode()));
                Stock stock = new Stock();
                if (stockExisting.getStockId() != null ) {

                    int stockQuantity = stockExisting.getQuantity();
                    int importedQuantity = detail.getQuantity();


                    stock.setShelf(shelf);
                    stock.setProduct(product);
                    stock.setQuantity(stockQuantity + importedQuantity);
                    stock.setDate(form.getDate());

                } else {

                    stock.setShelf(shelf);
                    stock.setProduct(product);
                    stock.setQuantity(detail.getQuantity());
                    stock.setDate(form.getDate());
                }
                stockService.save(new StockDTO(stock));

            } else if (form.getType() == FormType.EXPORT) {

                int currentQuantity = stockService.getStockToExport(product.getBarcode(), shelf.getShelfCode());
                int exportedQuantity = detail.getQuantity();

                if (exportedQuantity > currentQuantity) {
                    throw new RuntimeException("The exported quantity is greater than the current stock");
                }

                Stock stock = new Stock();
                stock.setShelf(shelf);
                stock.setProduct(product);
                stock.setDate(form.getDate());
                stock.setQuantity(currentQuantity - exportedQuantity);

                stockService.save(stock);
            }

//            Stock stock = new Stock();
//            stock.setShelf(shelf);
//            stock.setProduct(product);
//            stock.setQuantity(detail.getQuantity());
//            stock.setDate(form.getDate());
//
//            stockService.save(stock);
        }
        form.setFormDetailList(formDetailList);
        return form;
    }


}
