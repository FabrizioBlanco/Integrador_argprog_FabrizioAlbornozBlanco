import { Component, OnInit } from '@angular/core';
import { Experiencia } from 'src/app/model/experiencia';
import { SExperienciaService } from 'src/app/service/s-experiencia.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {
  expe: Experiencia[] = []
  constructor(private sExperiencia: SExperienciaService, private tokenService: TokenService) { }

  isLogged = false
  ngOnInit(): void {
    this.cargarExperiencia()
    //validamos si estamos logeados o no
    if(this.tokenService.getToken()){
      this.isLogged = true
    }else{
      this.isLogged = false
    }
  }
  cargarExperiencia():void{
    this.sExperiencia.lista().subscribe(data=>{this.expe = data})
  }
  delete(id:number):void{
    if(id != undefined){
      this.sExperiencia.delete(id).subscribe(data=>{
        //que vuelva a cargar las experiencias nuevamente
        this.cargarExperiencia()
      }, err=>{
        alert("Error al intentar borrar la experiencia")
      })
    }
  }
}
