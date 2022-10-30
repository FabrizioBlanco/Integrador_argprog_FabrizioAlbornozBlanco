import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/model/Persona.model';
import { ImageService } from 'src/app/service/image.service';
import { PersonaService } from 'src/app/service/persona.service';
import { TokenService } from 'src/app/service/token.service';




@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit {
  persona: Persona = new Persona ("","","","")
  constructor(private personaService: PersonaService, 
              private tokenService: TokenService,
              private imagenService: ImageService) {}
  isLogged = false

  ngOnInit(): void {
    // this.persona.img = this.imagenService.images
    // console.log('llamada desde la variable images: '+this.persona.img);
    // this.persona.img = this.imagenService.getImages()
    // console.log('llamada desde el método getImages(): '+this.persona.img);
    
    this.cargarPersona()
    if(this.tokenService.getToken()){
      this.isLogged = true
    }else{
      this.isLogged = false
    }
    
  }
  cargarPersona(){
    this.personaService.detail(1).subscribe(
      data=>{
        this.persona = data
      }
    )
  }
  
}