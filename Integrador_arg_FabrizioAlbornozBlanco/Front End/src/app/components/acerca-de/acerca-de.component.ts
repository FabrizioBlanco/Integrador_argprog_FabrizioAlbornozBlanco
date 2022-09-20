import { Component, OnInit } from '@angular/core';
import { persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';


@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit {
  persona: persona = new persona("","","");
  constructor(public personaService: PersonaService) {}

  //aquí llamamos/usamos a nuestro servicio de persona  
  ngOnInit(): void {
    this.personaService
      .getPersona()
      .subscribe(data => { 
      /*suscribe conecta el observer con los eventos observables.
      Cuando detecta un cambio, ejecuta el código.*/
        this.persona=data;
      })
  }
  
}