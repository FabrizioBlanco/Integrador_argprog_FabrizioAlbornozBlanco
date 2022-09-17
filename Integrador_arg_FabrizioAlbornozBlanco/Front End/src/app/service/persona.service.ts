import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { persona } from '../model/Persona.model';


@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  url = "http://localhost:8080/personas/"
  constructor(private http: HttpClient) { }
  //EL "observable" lo usa angular para hacer la peticiones asincronas.
  public getPersona(): Observable<persona>{
    return this.http.get<persona>(this.url+"traer/perfil")
  }
}
