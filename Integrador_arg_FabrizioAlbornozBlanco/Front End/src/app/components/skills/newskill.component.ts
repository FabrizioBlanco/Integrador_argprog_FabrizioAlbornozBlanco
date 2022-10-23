import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Skill } from 'src/app/model/skill';
import { HysService } from 'src/app/service/hys.service';

@Component({
  selector: 'app-newskill',
  templateUrl: './newskill.component.html',
  styleUrls: ['./newskill.component.css']
})
export class NewskillComponent implements OnInit {
  nombre: string
  porcentaje: number
  constructor(private hysS: HysService,
              private router: Router) { }

  ngOnInit(): void {
  }
  onCreate():void{
    const skill = new Skill(this.nombre, this.porcentaje)
    this.hysS.save(skill).subscribe(mensaje=>{
      alert("Skill añadida correctamente")
      this.router.navigate([''])
    }, err=>{
      alert("falló")
      this.router.navigate([''])
    })
  }
}
