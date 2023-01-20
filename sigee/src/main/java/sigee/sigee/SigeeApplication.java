package sigee.sigee;

import sigee.sigee.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sigee.sigee.service.IUsuarioService;

@SpringBootApplication
public class SigeeApplication implements CommandLineRunner{

//    @Autowired
//    private Iusuarioservice usuarioService;
    
    
    public static void main(String[] args) {
        SpringApplication.run(SigeeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//       usuarioService.salvar(new usuario("lolo", passwordEncoder().encode("lolo"), "ADMIN", true));
//       usuarioService.salvar(new usuario("lala", passwordEncoder().encode("lala"), "TECNICO", true));
   }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
