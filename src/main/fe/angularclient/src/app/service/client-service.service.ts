import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Client } from '../model/client';

@Injectable()
export class ClientService {

  private getClientsUrl: string;
  private addClientUrl: string;

  constructor(private http: HttpClient) {
    this.getClientsUrl = 'http://localhost:8080/getClients';
    this.addClientUrl = 'http://localhost:8080/client';
  }

  public findAll(): Observable<Client[]> {
    return this.http.get<Client[]>(this.getClientsUrl);
  }

  public save(client: Client) {
    return this.http.post<Client>(this.addClientUrl, client);
  }
}
