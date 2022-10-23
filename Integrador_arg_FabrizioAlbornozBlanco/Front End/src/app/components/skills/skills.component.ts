import { Component, OnInit } from '@angular/core'
import { Skill } from 'src/app/model/skill'

import { HysService } from 'src/app/service/hys.service'
import { TokenService } from 'src/app/service/token.service'

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {
  skill: Skill[] = []
  constructor(private hysS: HysService,
    private tokenService: TokenService) { }
  isLogged = false
  ngOnInit(): void {
    this.cargarSkill()
    if(this.tokenService.getToken()){
      this.isLogged = true
    }else{
      this.isLogged = false
    }
  }
  cargarSkill(): void {
    this.hysS.lista().subscribe(
      data => {
        this.skill = data
      })
  }

  delete(id?: number){
    if(id!=undefined){
      this.hysS.delete(id).subscribe(data=>{
        this.cargarSkill()
      },err=>{
        alert("no se pudo eliminar")
      })
    }
  }


}
