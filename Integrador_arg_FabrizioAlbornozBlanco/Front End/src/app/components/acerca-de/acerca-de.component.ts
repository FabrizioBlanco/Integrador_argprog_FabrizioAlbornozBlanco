import { Component, OnInit } from '@angular/core';
import { persona } from 'src/app/model/Persona.model';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit {
  persona: persona = new persona("","","")
  constructor(public personaService: PersonaService) { }

  ngOnInit(): void {
    //suscribe conecta el observer con los eventos observables. Cuando detecta un cambio, ejecuta el código.
    this.personaService.getPersona().subscribe(data => {this.persona=data})
  }

}
