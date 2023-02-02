package com.uva.users.Controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uva.users.Exception.VinoException;
import com.uva.users.Model.*;
import com.uva.users.Repository.*;

@RestController
@RequestMapping("ejemploVinos")
@CrossOrigin(origins = "*")
public class ejemploRest {
    private final VinoConRelacionRepository repositoryVino;
    

    ejemploRest(VinoConRelacionRepository repositoryVino) {
        this.repositoryVino = repositoryVino;
       
    }

    @PostMapping()
    public String newVino(@RequestBody VinoConRelacion newVino ) {
       
        

        repositoryVino.save(newVino);
       
        return "guardado con exito";

    }

    

    @GetMapping()
    public List<VinoConRelacion> getVinos() {
        List<VinoConRelacion> vinos = new ArrayList<VinoConRelacion>();

        repositoryVino.findAll().forEach(vinoVisto -> vinos.add(vinoVisto));

        return vinos;

    }

    @GetMapping(value = "/{id}")
    public VinoConRelacion getVinoById(@PathVariable int id) {
        VinoConRelacion vino = repositoryVino.findById(id).orElseThrow(() -> new VinoException("Sin resultado"));
        return vino;

    }

    @PutMapping(value = "/{id}")
    public String actualizarVinoById(@PathVariable int id, @RequestBody VinoConRelacion vino) {
        if (repositoryVino.existsById(id)) {
            VinoConRelacion vinoCorrespondiente = repositoryVino.findById(id).get();
            
            vinoCorrespondiente.setPrecio(vino.getPrecio());
            
            repositoryVino.save(vinoCorrespondiente);
            return "actualizado correctamente";
        } else {
            return "no existe con ese id";
        }
        // illegal argument exception

    }

    @DeleteMapping(value = "/{id}")
    public String borrarVinoById(@PathVariable int id) {
        if (repositoryVino.existsById(id)) {
            repositoryVino.deleteById(id);
            return "eliminado con exito";
        } else {
            return "no existe con ese id";
        }
        // illegal argument exception

    }

    





}