import { Component, OnInit } from '@angular/core';
import { Client } from '../model/client';
import { ClientService } from '../service/client-service.service';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {

  clients: Client[] | undefined;

  constructor(private clientService: ClientService) {
  }

  ngOnInit() {
    this.clientService.findAll().subscribe(data => {
      this.clients = data;
    });
  }
}