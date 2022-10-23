import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Skill } from 'src/app/model/skill';
import { HysService } from 'src/app/service/hys.service';

@Component({
  selector: 'app-editskill',
  templateUrl: './editskill.component.html',
  styleUrls: ['./editskill.component.css']
})
export class EditskillComponent implements OnInit {
  hys: Skill = null
  constructor(private hysS: HysService,
              private activatedRouter: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id']
    this.hysS.detail(id).subscribe(
      data=>{
        this.hys = data
      }, err=>{
        alert('no se pudo actualizar')
        this.router.navigate([''])
      }
    )
  }
  onUpdate():void{
    const id = this.activatedRouter.snapshot.params['id']
    this.hysS.update(id, this.hys).subscribe(
      data =>{
        this.router.navigate([''])
      },err=>{
        alert("Error al modificar la Skill")
        this.router.navigate([''])
      }
    )
  }
}
