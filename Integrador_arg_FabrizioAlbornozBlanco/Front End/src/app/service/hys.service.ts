import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Skill } from '../model/skill';

@Injectable({
  providedIn: 'root'
})
export class HysService {
  URL = environment.URL + 'hysskill/'
  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Skill[]>{
    return this.httpClient.get<Skill[]>(this.URL + 'lista');
  }
  public detail(id: number): Observable<Skill>{
    return this.httpClient.get<Skill>(this.URL + `detail/${id}`);
  }
  public save(skills: Skill): Observable<any>{
    return this.httpClient.post<any>(this.URL + 'create', skills);
  }
  public update(id: number, skills: Skill): Observable<any>{
    return this.httpClient.put<any>(this.URL + `update/${id}`, skills);
  }
  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.URL + `delete/${id}`);
  }
}
