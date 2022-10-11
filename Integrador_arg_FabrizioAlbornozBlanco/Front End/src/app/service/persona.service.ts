import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core'; //permite que el servicio sea inyectado en los componentes
import { Observable } from 'rxjs';
import { persona } from '../model/persona.model';


@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  URL = 'http://localhost:8080/personas/'
  constructor(private http: HttpClient) { }
  //EL "observable" lo usa angular para hacer la peticiones asincronas.
  public getPersona(): Observable<persona>{
    return this.http.get<persona>(this.URL+'traer')
  }
}
