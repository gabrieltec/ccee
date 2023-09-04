import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AgenteService {
  constructor(private http: HttpClient) {}
  private readonly URL_BASE = 'http://localhost:8080';
  private readonly URL_AGENTE = `${this.URL_BASE}/api/v1/agente`;

  public getAgentes() {
    return this.http.get<any[]>(`${this.URL_AGENTE}`);
  }

  public sendFile(file: FileList) {
    let body = new FormData();
    body.append('file', file[0]);
    return this.http.post<any>(`${this.URL_AGENTE}/upload`, body);
  }
}
