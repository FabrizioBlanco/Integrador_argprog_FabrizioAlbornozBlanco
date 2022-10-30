import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Persona } from 'src/app/model/Persona.model';
import { ImageService } from 'src/app/service/image.service';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-edit-acerca-de',
  templateUrl: './edit-acerca-de.component.html',
  styleUrls: ['./edit-acerca-de.component.css']
})
export class EditAcercaDeComponent implements OnInit {
  persona: Persona = null
  constructor(private personaS: PersonaService, 
              private activatedRouter : ActivatedRoute, 
              private router: Router,
              public imageService: ImageService) { }

  ngOnInit(): void {
    
    const id = this.activatedRouter.snapshot.params['id']
    this.personaS.detail(id).subscribe(data=>{
      this.persona = data
    }, err=>{
      alert('no se pudo actualizar')
      this.router.navigate([''])
    })
  }
  onUpdate():void{
    const id = this.activatedRouter.snapshot.params['id'] 
    console.log('acá se activa el traer la imangen con la función');    
    this.persona.img = this.imageService.getImage()
    this.personaS.update(id, this.persona).subscribe(
      data=>{
        this.router.navigate([''])
      },err=>{
        alert("error al modificar")
        this.router.navigate([''])
      }
    )
  }

  
upLoadImage($event: any):void{
    const id = this.activatedRouter.snapshot.params['id']//capturamos el id de la imagen
    const nombre = 'perfil_' + id
    this.imageService.upLoadImage($event,nombre)
  }

  
  
}
