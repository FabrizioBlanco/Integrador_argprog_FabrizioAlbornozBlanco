import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sociales',
  templateUrl: './sociales.component.html',
  styleUrls: ['./sociales.component.css']
})
export class SocialesComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }
  login(){
    this.router.navigate(['/login'])
  }
}
