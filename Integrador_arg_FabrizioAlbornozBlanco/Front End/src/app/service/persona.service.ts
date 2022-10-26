import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core'; //permite que el servicio sea inyectado en los componentes
import { Observable } from 'rxjs';
import { Persona } from '../model/Persona.model';
import { environment } from 'src/environments/environment';



@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  URL = environment.URL + 'personas/'
  
  constructor(private http: HttpClient) { }
  //EL "observable" lo usa angular para hacer la peticiones asincronas.
  public list():Observable<Persona[]>{
    return this.http.get<Persona[]>(this.URL + 'lista')
  }
  public detail(id:number):Observable<Persona>{
    return this.http.get<Persona>(this.URL + `detail/${id}`)
  }
  public update(id:number, persona: Persona): Observable<any>{
    return this.http.put<any>(this.URL + `update/${id}`, persona)
  }
  public save(persona:Persona): Observable<any>{
    return this.http.post<Persona>(this.URL + 'create', persona)
  }
}
