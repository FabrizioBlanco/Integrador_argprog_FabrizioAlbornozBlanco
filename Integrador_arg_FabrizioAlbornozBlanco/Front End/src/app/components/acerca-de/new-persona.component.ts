import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Persona } from 'src/app/model/Persona.model';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-new-persona',
  templateUrl: './new-persona.component.html',
  styleUrls: ['./new-persona.component.css']
})
export class NewPersonaComponent implements OnInit {
  nombreP: string
  apellidoP:string
  descripcionP:string
  imgP:string

  constructor(private personaS: PersonaService, private router:Router) { }

  ngOnInit(): void {  
  }
  onCreate(){
    const persona = new Persona(this.nombreP, this.apellidoP, this.imgP,this.descripcionP)
    this.personaS.save(persona).subscribe(
      data =>{
        alert("persona creada")
        this.router.navigate([''])
      },err=>{
        alert("Error")
        this.router.navigate([''])
      }
    )
  }
  cambiarImg($event:any){
    
  }
}
