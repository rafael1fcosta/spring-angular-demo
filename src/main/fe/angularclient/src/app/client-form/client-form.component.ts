import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from '../model/client';
import { ClientService } from '../service/client-service.service';

@Component({
  selector: 'app-client-form',
  templateUrl: './client-form.component.html',
  styleUrls: ['./client-form.component.css']
})
export class ClientFormComponent {

  client: Client;

  constructor(
    private route: ActivatedRoute, 
      private router: Router, 
        private clientService: ClientService) {
    this.client = new Client();
  }

  onSubmit() {
    this.clientService.save(this.client).subscribe(result => this.gotoClientList());
  }

  gotoClientList() {
    this.router.navigate(['/clients']);
  }
}