package profiles;

//Este perfil de profile vai ser de test

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import services.DBService;

//@Configuration
//@Profile("test")
public class TestProfile {

  /*  @Autowired
    private DBService dbService;

    //@Bean
    @PostConstruct //vai ignorar
    public void instanciaDB() {
        this.dbService.instanciaDB();
    }*/
}
