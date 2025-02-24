package co.analisys.gimnasio.miembros;

import co.analisys.gimnasio.miembros.model.Miembro;
import co.analisys.gimnasio.miembros.model.MiembroID;
import co.analisys.gimnasio.miembros.repository.MiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private MiembroRepository miembroRepository;

    @Override
    public void run(String... args) throws Exception {
        miembroRepository.save(new Miembro(new MiembroID("1"), "Santiago Escobar", "escobar@email.com", LocalDate.now()));
        miembroRepository.save(new Miembro(new MiembroID("2"), "David Donneys", "donneys@email.com", LocalDate.now().minusDays(10)));
        miembroRepository.save(new Miembro(new MiembroID("3"), "Santiago Arboleda", "arboleda@email.com", LocalDate.now().minusDays(30)));

        System.out.println("Datos de prueba de Miembros cargados exitosamente.");
    }
}
