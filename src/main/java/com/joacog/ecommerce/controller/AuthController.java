package com.joacog.ecommerce.controller;
import com.joacog.ecommerce.model.User;
import com.joacog.ecommerce.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final IUserService userService;



    @Autowired
    public AuthController(IUserService userService) {
        this.userService = userService;
    }

    

    //REGISTER

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user){

        if (user.getUsername() == null || user.getUsername().isEmpty()){
            return ResponseEntity.badRequest().body("Completar el nombre de usuario");
        }

        if (userService.existsUserByName(user.getUsername())){
            return ResponseEntity.badRequest().body("El nombre de usuario ya existe");
        }

        if (user.getPassword().isEmpty()){
            return ResponseEntity.badRequest().body("La contraseña no puede estar vacía");
        }
        if (user.getPassword().length() < 8){
            return ResponseEntity.badRequest().body("La contraseña debe tener mínimo 8 dígitos");
        }


        User newUser = new User(1L,user.getUsername(),user.getPassword());
        userService.createUser(newUser);
        return ResponseEntity.ok().body("Usuario registrado correctamente, volver al login e iniciar sesion");

        
    }

    //LOGIN
    

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {


        List<User> userList = userService.getUsers();

        for (User u : userList){

            if (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
            // Guardar información del usuario en la sesión
                session.setAttribute("username", user.getUsername());
                return ResponseEntity.ok().body("Usuario autenticado con éxito");
            }
            else {
                return ResponseEntity.badRequest().body("Credenciales inválidas");
            }
        }
        return null;
    } 

    //LOG OUT

    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        // Invalidar la sesión
        session.invalidate();
        return ResponseEntity.ok().body("Sesión cerrada");
    }

    @GetMapping("/userinfo")
    public Map<String, Object> userInfo(HttpSession session) {
        // Verificar si el usuario tiene una sesión activa
        String username = (String) session.getAttribute("username");
        if (username != null) {
            return Map.of("username", username, "sessionId", session.getId());
        }
        else {
            return Map.of("message", "No hay sesión activa");
        }
    }
}
