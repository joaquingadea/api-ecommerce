package com.joacog.ecommerce.controller;
import com.joacog.ecommerce.service.IUserService;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
        public String register(@RequestParam String username, @RequestParam String password){

            return null;
        }

        @PostMapping("/login")
        public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
            // Simulación de autenticación. En producción, validar contra base de datos.
            if ("user".equals(username) && "password".equals(password)) {
                // Guardar información del usuario en la sesión
                session.setAttribute("username", username);
                return "Usuario autenticado con éxito";
            } else {
                return "Credenciales inválidas";
            }
        }

        @GetMapping("/logout")
        public String logout(HttpSession session) {
            // Invalidar la sesión
            session.invalidate();
            return "Sesión cerrada";
        }

        @GetMapping("/userinfo")
        public Map<String, Object> userInfo(HttpSession session) {
            // Verificar si el usuario tiene una sesión activa
            String username = (String) session.getAttribute("username");
            if (username != null) {
                return Map.of("username", username, "sessionId", session.getId());
            } else {
                return Map.of("message", "No hay sesión activa");
            }
        }
}
