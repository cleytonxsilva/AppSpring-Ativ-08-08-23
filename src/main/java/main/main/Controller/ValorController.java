package main.main.Controller;

import main.main.Entity.Valor;
import main.main.Service.ValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpServerErrorException;

@Controller
@RequestMapping(value = "/api/app")
public class ValorController {
    @Autowired
    private ValorService  valorService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
            return ResponseEntity.ok(this.valorService.findAll());
    }

    @GetMapping("/infos")
    public ResponseEntity<?> informacao(){
        return ResponseEntity.ok(this.valorService.informacao());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Valor valor){
        try{
            this.valorService.create(valor);
            return ResponseEntity.ok("Valor cadastrado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.internalServerError().body("Deu ruim!");
        }
    }
}
