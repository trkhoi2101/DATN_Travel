//package SNATB.REST;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import SNATB.Entity.Invoice;
//import SNATB.Service.InvoiceService;
//
//import java.util.List;
//
//@CrossOrigin("*")
//@RestController
//@RequestMapping("/REST/invoice")
//public class InvoiceREST {
//
//    @Autowired
//    private InvoiceService invoiceService;
//
//    @GetMapping
//    public List<Invoice> getAllInvoice() {
//        return invoiceService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Invoice getInvoiceById(@PathVariable("id") Long invoiceId) {
//        return invoiceService.findById(invoiceId);
//    }
//
//    @PostMapping
//    public Invoice createInvoice(@RequestBody Invoice invoice) {
//        return invoiceService.save(invoice);
//    }
//
//    @PutMapping("/{id}")
//    public Invoice updateInvoice(@PathVariable("id") Long invoiceId, @RequestBody Invoice invoice) {
//    	invoice.setInvoiceId(invoiceId);
//        return invoiceService.save(invoice);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteInvoice(@PathVariable("id") Long invoiceId) {
//    	invoiceService.deleteById(invoiceId);
//    }
//}
