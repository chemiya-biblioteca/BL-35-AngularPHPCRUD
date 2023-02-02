import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from "rxjs";
import {Empleado} from "./Empleado";


@Injectable({
  providedIn: 'root'
})
export class CrudService {
API:string="http://localhost/php/empleados/";
  constructor(private clienteHTTP:HttpClient) { }


  agregarEmpleado(datosEmpleado:Empleado):Observable<any>{
    console.log(datosEmpleado);
    return this.clienteHTTP.post(this.API+"?insertar=1",datosEmpleado);
  }

  obtenerEmpleados(){
    return this.clienteHTTP.get(this.API);
  }

  borrarEmpleado(id:any):Observable<any>{
    return this.clienteHTTP.get(this.API+"?borrar="+id);
  }

  obtenerUnEmpleado(id:any):Observable<any>{
    return this.clienteHTTP.get(this.API+"?consultar="+id);
  }

  editarEmpleado(id:any,datosEmpleado:any):Observable<any>{
    console.log(datosEmpleado);
    return this.clienteHTTP.post(this.API+"?actualizar="+id,datosEmpleado);
  }
}
