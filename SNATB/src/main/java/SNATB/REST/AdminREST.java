package SNATB.REST;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import SNATB.Entity.Account;
import SNATB.Entity.Admin;
import SNATB.Service.AdminService;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
@CrossOrigin("*")
@RestController
@RequestMapping("/REST/admin")
public class AdminREST {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<Admin> getAllAdmin() {
        return adminService.findAll();
    }

    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable("id") String username) {
        return adminService.findById(username);
    }

    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.save(admin);
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
    public Admin updateAdminById(@PathVariable("id") String username, @RequestBody Admin admin) {
    	return adminService.save(admin);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable("id") String username) {
    	adminService.deleteById(username);
    }
    
//    @GetMapping("/total")
//    public long getTotalAccount() {
//        return adminService.countAccount();  // Trả về tổng số account
//    }
    
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
