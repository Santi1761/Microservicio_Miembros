package co.analisys.gimnasio.miembros;

import co.analisys.gimnasio.miembros.dto.MiembroDTO;
import co.analisys.gimnasio.miembros.model.Miembro;
import co.analisys.gimnasio.miembros.model.MiembroID;
import co.analisys.gimnasio.miembros.service.IMiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private IMiembroService miembroRepository;

    @Override
    public void run(String... args) throws Exception {
        MiembroDTO miembro1 = new MiembroDTO("X1", "Carlos Rodríguez", "prueba@email.com", LocalDate.now());


        miembroRepository.registrar(miembro1);


        System.out.println("Datos de prueba de Miembros cargados exitosamente.");
    }
}
