package SNATB.REST;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import SNATB.Entity.Account;
import SNATB.Service.AccountService;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
@CrossOrigin("*")
@RestController
@RequestMapping("/REST/account")
public class AccountREST {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAllAccount() {
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable("id") String username) {
        return accountService.findById(username);
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.save(account);
    }
//    @PostMapping
//    public ResponseEntity<?> createAccount(@Valid @RequestBody Account account, BindingResult bindingResult) {
//        // Kiểm tra nếu có lỗi validation
//        if (bindingResult.hasErrors()) {
//            // Lấy thông tin lỗi
//            StringBuilder errorMessages = new StringBuilder();
//            bindingResult.getAllErrors().forEach(error -> {
//                errorMessages.append(error.getDefaultMessage()).append("\n");
//            });
//            // Trả về lỗi với mã lỗi 400 (Bad Request)
//            return ResponseEntity.badRequest().body(errorMessages.toString());
//        }
//        
//        // Nếu không có lỗi validation, lưu tài khoản
//        Account savedAccount = accountService.save(account);
//        
//        // Trả về tài khoản đã lưu với mã 200 (OK)
//        return ResponseEntity.ok(savedAccount);
//    }
    
    @PutMapping("/{id}")
    public Account updateAccountById(@PathVariable("id") String username, @RequestBody Account account) {
    	return accountService.save(account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable("id") String username) {
        accountService.deleteById(username);
    }
    
    @GetMapping("/total")
    public long getTotalAccount() {
        return accountService.countAccount();  // Trả về tổng số account
    }
    
//    @Autowired
//    private JwtUtil jwtUtil;

    // Đăng nhập
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
//        String username = loginRequest.get("username");
//        String password = loginRequest.get("password");
//
//        Account account = accountService.validateLogin(username, password);
//
//        if (account != null) {
//            // Tạo JWT Token
//            String token = jwtUtil.generateToken(username);
//            return ResponseEntity.ok(Map.of(
//                "message", "Login successful",
//                "token", token,
//                "username", username
//            ));
//        } else {
//            return ResponseEntity.status(401).body(Map.of(
//                "message", "Invalid username or password"
//            ));
//        }
//    }
}
