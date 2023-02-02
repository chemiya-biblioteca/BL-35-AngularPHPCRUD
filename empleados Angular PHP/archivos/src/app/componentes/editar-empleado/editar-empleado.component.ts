import { Component, OnInit } from '@angular/core';
import {Router,ActivatedRoute} from '@angular/router';
import { FormGroup,FormBuilder } from '@angular/forms';
import { CrudService } from 'src/app/servicio/crud.service';
@Component({
  selector: 'app-editar-empleado',
  templateUrl: './editar-empleado.component.html',
  styleUrls: ['./editar-empleado.component.css']
})
export class EditarEmpleadoComponent implements OnInit {
id:any;
formularioEmpleados:FormGroup;
  constructor(private activeRoute:ActivatedRoute, private crudService:CrudService, public formulario:FormBuilder, private ruteador:Router) {
    this.id=this.activeRoute.snapshot.paramMap.get("id");
    this.crudService.obtenerUnEmpleado(this.id).subscribe(respuesta=>{
      this.formularioEmpleados.setValue({
        nombre:respuesta[0]["nombre"],
      correo:respuesta[0]["correo"]
      })
    });
    this.formularioEmpleados=this.formulario.group({
      nombre:[""],
      correo:[""]
    });

   }

  ngOnInit(): void {
    
  }

  enviarDatos():any{
    console.log(this.formularioEmpleados.value);
    this.crudService.editarEmpleado(this.id,this.formularioEmpleados.value).subscribe(()=>{
      this.ruteador.navigateByUrl('/listar-empleado');
    });
  }

}
